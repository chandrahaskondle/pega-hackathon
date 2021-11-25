package com.pega.hackathon.healthcare.controllers;

import com.pega.hackathon.healthcare.model.CitizenUser;
import com.pega.hackathon.healthcare.model.HealthCareProvider;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class HealthCareProviderController {

    public String login() {
        return "";
    }

    @PostMapping
    public String register(@RequestBody HealthCareProvider healthCareProvider) {
        return "";
    }

    public String createVaccinationDrive() {
        return "";
    }

    public String createVaccineCertificate() {
        return "";
    }

    private String updateVaccinationHistory() {
        return "";
    }
}
