package com.example.applause.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
