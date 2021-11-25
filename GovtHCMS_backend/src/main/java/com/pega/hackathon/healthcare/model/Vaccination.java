package com.pega.hackathon.healthcare.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Vaccination implements Serializable {

    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "id")
    private Vaccine vaccine;

    public Date getDateOfVaccination() {
        return dateOfVaccination;
    }

    public void setDateOfVaccination(Date dateOfVaccination) {
        this.dateOfVaccination = dateOfVaccination;
    }

    private Date dateOfVaccination;
    private Date dateOfRegistration;
    @ManyToOne
    @JoinColumn(name = "id")
    private CitizenUser user;
    @ManyToOne
    @JoinColumn(name = "id")
    private HealthCareProvider healthCareProvider;
    private String location;
    private String notes;
    private boolean isVaccinated;
}
