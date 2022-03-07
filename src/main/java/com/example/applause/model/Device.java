package com.example.applause.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "devices")
@Data
public class Device {

    @Id
    @Column(name = "deviceid")
    private int deviceId;
    @Column(name = "description")
    private String description;
}
