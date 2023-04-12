package com.example.applause.model;

import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tester_devices")
@Data
public class TesterDevice {

    @Id
    @Column(name = "testerid")
    private int testerid;
    @Column(name = "deviceid")
    private int deviceid;
}
