package com.example.StudentPortalDashboard.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String employeNumber;
    private String fullnames;
    private String email;
    private String dateOfBirth;
    private String dateCreated;
}
