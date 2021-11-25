package com.pega.hackathon.healthcare.controllers;

import com.pega.hackathon.healthcare.model.CitizenUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class GovernmentAdminController {

    public String login() {
        return "";
    }

    @PostMapping
    public String registerHealthCareAdmin(@RequestBody CitizenUser citizenUser) {
        return "";
    }

    public String getVaccineReports() {
        return "";
    }
}
