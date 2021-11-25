package com.pega.hackathon.healthcare.controllers;


import com.pega.hackathon.healthcare.model.CitizenUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    public String login() {
        return "";
    }

    @PostMapping
    public String register(@RequestBody CitizenUser citizenUser) {
        return "";
    }

    private String updateVaccinationHistory() {
        return "";
    }

    private String registerForVaccination() {
        return "";
    }

    private String reportIllness() {
        return "";
    }

    private String getVaccinationHistory() {
        return "";
    }

    private String getVaccinationCertificate() {
        return "";
    }
}
