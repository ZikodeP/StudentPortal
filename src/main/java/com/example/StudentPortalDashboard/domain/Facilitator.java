package com.example.StudentPortalDashboard.domain;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Facilitator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String employeeNumber;
    public String fullnames;
    public String email;
    public String modules;
    public String isAdmin;
    public String dateEmployed;
    public String faculty;
}
