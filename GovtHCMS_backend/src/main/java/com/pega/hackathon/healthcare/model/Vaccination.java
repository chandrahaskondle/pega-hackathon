package com.pega.hackathon.healthcare.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Getter
@Setter
public class Vaccination implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(unique = true, nullable = false)
    private int id;
    @ManyToOne
    private Vaccine vaccine;
    private Date dateOfVaccination;
    private Date dateOfRegistration;
    @ManyToOne
    private CitizenUser user;
    @ManyToOne
    private HealthCareProvider healthCareProvider;
    private String location;
    private String notes;
    private boolean isVaccinated;
}
