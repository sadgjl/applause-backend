package com.example.applause.dao;

import com.example.applause.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {

    List<Device> findAll();
    List<Device> findDevicesByDeviceId(@RequestParam("deviceId") Integer deviceId);
}
