package com.example.applause.model;

import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bugs")
@Data
public class Bug {
    @Id
    @Column(name = "bugid")
    private int bugId;
    @Column(name = "deviceid")
    private int deviceId;
    @Column(name = "testerid")
    private int testerId;
}
