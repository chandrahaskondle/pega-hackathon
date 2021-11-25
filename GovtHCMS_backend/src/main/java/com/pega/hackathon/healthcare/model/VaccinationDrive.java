package com.pega.hackathon.healthcare.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class VaccinationDrive {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(unique = true, nullable = false)
    private int id;
    private String illness;
    @ManyToOne
    private Vaccine vaccine;
    private Date vaccinationDate;
    private String location;
    @ManyToOne
    private HealthCareProvider healthCareProvider;
    private Boolean isSlotAvailable;
}
