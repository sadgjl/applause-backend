package com.example.applause.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "testers")
public class Tester implements Comparable<Tester> {

    @Id
    @Column(name = "testerid")
    private int testerId;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "country")
    private String country;
    @Column(name = "lastlogin")
    private Date lastLogin;
    @Transient
    private int experience;

    @Override
    public int compareTo(Tester o) {
        return o.getExperience() - this.getExperience();
    }
}
