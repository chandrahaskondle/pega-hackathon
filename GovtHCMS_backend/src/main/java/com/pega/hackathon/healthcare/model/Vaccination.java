package com.pega.hackathon.healthcare.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Vaccination implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(unique = true, nullable = false)
    private int id;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Vaccine vaccine;
    private Date dateOfVaccination;
    private Date dateOfRegistration;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private CitizenUser user;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private HealthCareProvider healthCareProvider;
    private String location;
    private String notes;
    private boolean isVaccinated;
    private int appointmentId;
}
