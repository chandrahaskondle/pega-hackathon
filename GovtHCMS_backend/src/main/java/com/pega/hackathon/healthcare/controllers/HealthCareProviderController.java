package com.pega.hackathon.healthcare.controllers;

import com.pega.hackathon.healthcare.model.HealthCareProvider;
import com.pega.hackathon.healthcare.repositories.HealthCareProviderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/healthCareProvider")
@CrossOrigin
public class HealthCareProviderController {

    private HealthCareProviderRepository healthCareProviderRepository;

    public HealthCareProviderController(HealthCareProviderRepository healthCareProviderRepository) {
        this.healthCareProviderRepository = healthCareProviderRepository;
    }

    public String login() {
        return "";
    }

    @PostMapping
    public String register(@RequestBody HealthCareProvider healthCareProvider) {
        this.healthCareProviderRepository.save(healthCareProvider);
        return HttpStatus.OK.toString();
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
