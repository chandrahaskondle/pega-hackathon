package com.pega.hackathon.healthcare.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Vaccination {

    @Id
    private int id;
    private Vaccine vaccine;

    public Date getDateOfVaccination() {
        return dateOfVaccination;
    }

    public void setDateOfVaccination(Date dateOfVaccination) {
        this.dateOfVaccination = dateOfVaccination;
    }

    private Date dateOfVaccination;
    private Date dateOfRegistration;
    private CitizenUser user;
    private HealthCareProvider healthCareProvider;
    private String location;
    private String notes;
    private boolean isVaccinated;
}
