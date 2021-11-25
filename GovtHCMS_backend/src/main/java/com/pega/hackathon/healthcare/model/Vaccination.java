package com.pega.hackathon.healthcare.model;

import java.util.Date;

public class Vaccination {
    private int id;
    private Vaccine vaccine;
    private Date dateOfVaccination;
    private Date dateOfRegistration;
    private CitizenUser user;
    private HealthCareProvider healthCareProvider;
    private String location;
    private String notes;
    private boolean isVaccinated;
}
