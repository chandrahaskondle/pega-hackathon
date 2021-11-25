package com.pega.hackathon.healthcare.controllers;

import com.pega.hackathon.healthcare.model.CitizenUser;
import com.pega.hackathon.healthcare.model.GovernmentAdmin;
import com.pega.hackathon.healthcare.repositories.GovernmentAdminRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/govAdmin")
@CrossOrigin
public class GovernmentAdminController {

    private GovernmentAdminRepository governmentAdminRepository;

    public GovernmentAdminController(GovernmentAdminRepository governmentAdminRepository) {
        this.governmentAdminRepository = governmentAdminRepository;
    }

    public String login() {
        return "";
    }

    @PostMapping
    public String register(@RequestBody GovernmentAdmin governmentAdmin) {
        this.governmentAdminRepository.save(governmentAdmin);
        return HttpStatus.OK.toString();
    }

    public String getVaccineReports() {
        return "";
    }
}
