package com.pega.hackathon.healthcare.controllers;

import com.pega.hackathon.healthcare.model.Vaccine;
import com.pega.hackathon.healthcare.repositories.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vaccine")
@CrossOrigin
public class VaccineController {

    @Autowired
    private VaccineRepository vaccineRepository;

    @PostMapping
    public String registerVaccine(@RequestBody Vaccine vaccine) {
        this.vaccineRepository.save(vaccine);
        return HttpStatus.OK.toString();
    }
}
