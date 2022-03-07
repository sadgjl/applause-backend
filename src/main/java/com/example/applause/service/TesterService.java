package com.example.applause.service;

import com.example.applause.dao.BugRepository;
import com.example.applause.dao.DeviceRepository;
import com.example.applause.dao.TestersRepository;
import com.example.applause.model.Bug;
import com.example.applause.model.Tester;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TesterService {

    Logger logger = LoggerFactory.getLogger(TesterService.class);

    final TestersRepository testersRepository;
    final DeviceRepository deviceRepository;
    final BugRepository bugRepository;

    public TesterService(TestersRepository testersRepository, DeviceRepository deviceRepository, BugRepository bugRepository) {
        this.testersRepository = testersRepository;
        this.deviceRepository = deviceRepository;
        this.bugRepository = bugRepository;
    }

    public List<Tester> findAll() {
        return testersRepository.findAll();
    }

    public List<Tester> findTestersByCountryAndDevice(List<String> countries, List<Integer> deviceId) {

        try {
            List<Tester> testersListFromDB = testersRepository.findTestersByCountry(countries);
            logger.info("retrieved testers from DB matching country, list size = " + testersListFromDB.size());

            //getting id list of testers that match our search criteria to pass it to DB call
            List<Integer> testerIds = testersListFromDB.stream().map(Tester::getTesterId).collect(Collectors.toList());

            List<Bug> bugsList = bugRepository.findBugByDeviceIdAndTesterId(testerIds, deviceId);
            logger.info("retrieved bug list from DB matching testerId and deviceId, list size = " + bugsList.size());

            //calculate experience for each tester
            Map<Integer, Integer> experienceMap = new HashMap<>();
            for (Bug bug : bugsList) {
                experienceMap.putIfAbsent(bug.getTesterId(), 1);
                experienceMap.computeIfPresent(bug.getTesterId(), (k, v) -> v + 1);
            }
            //filtering testers that have no selected devices
            List<Tester> filteredTestersList = testersListFromDB.stream().filter(c -> experienceMap.containsKey(c.getTesterId())).collect(Collectors.toList());

            filteredTestersList.forEach(c -> c.setExperience(experienceMap.get(c.getTesterId())));
            List<Tester> sortedResult = filteredTestersList.stream().sorted(Tester::compareTo).collect(Collectors.toList());

            sortedResult.forEach(c -> logger.debug(c.toString()));
            logger.info("filtered and sorted list size = " + sortedResult.size());

            return sortedResult;
        } catch (Exception e) {
            logger.error("was not able to persist data");
            e.printStackTrace();
            return null;
        }
    }
}
