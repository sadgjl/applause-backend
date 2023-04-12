package com.example.applause.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


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
