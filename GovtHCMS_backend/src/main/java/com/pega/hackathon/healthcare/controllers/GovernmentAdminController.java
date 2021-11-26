package com.pega.hackathon.healthcare.controllers;

import com.pega.hackathon.healthcare.model.CitizenUser;
import com.pega.hackathon.healthcare.model.GovernmentAdmin;
import com.pega.hackathon.healthcare.model.Vaccination;
import com.pega.hackathon.healthcare.repositories.GovernmentAdminRepository;
import com.pega.hackathon.healthcare.repositories.VaccinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user/govAdmin")
@CrossOrigin
public class GovernmentAdminController {

    @Autowired
    private GovernmentAdminRepository governmentAdminRepository;

    @Autowired
    private VaccinationRepository vaccinationRepository;

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

    @GetMapping(path = "/vaccination/{location}")
    public ResponseEntity<List<Vaccination>> getVaccinationsByLocation(@PathVariable String location) {
        List<Vaccination> vaccinations = new ArrayList<>();
        this.vaccinationRepository.findByLocation(location).forEach(vaccinations::add);
        return new ResponseEntity<>(vaccinations, HttpStatus.OK);
    }
}
