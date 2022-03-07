package com.example.applause.controller;

import com.example.applause.dao.DeviceRepository;
import com.example.applause.model.Device;
import com.example.applause.model.Tester;
import com.example.applause.service.TesterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api/v2/")
@RestController
public class TestersController {

    Logger logger = LoggerFactory.getLogger(TestersController.class);

    final
    TesterService testerService;
    DeviceRepository deviceRepository;

    public TestersController(TesterService testerService, DeviceRepository deviceRepository) {
        this.testerService = testerService;
        this.deviceRepository = deviceRepository;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<Object> getTesters() {
        logger.info("Received a testers request, start processing...");
        try {
            List<Tester> result = testerService.findAll();
            logger.info("Testers request processed");
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

    @GetMapping(path = "/devices")
    public ResponseEntity<Object> getAllDevices() {
        logger.info("Received a devices request, start processing...");
        try {
            List<Device> result = deviceRepository.findAll();
            logger.info("Devices request processed");
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

    @GetMapping(path = "/testers")
    public ResponseEntity<Object> getTestersByCountryAndDevice2(@RequestParam List<String> countries, @RequestParam List<Integer> devices) {
        logger.info("Received a request, start processing...");
        try {
            List<Tester> result = testerService.findTestersByCountryAndDevice(countries, devices);
            logger.info("Processed request successfully");
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            logger.error("Was not able to process a request");
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }
}

