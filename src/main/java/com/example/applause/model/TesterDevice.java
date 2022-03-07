package com.example.applause.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
