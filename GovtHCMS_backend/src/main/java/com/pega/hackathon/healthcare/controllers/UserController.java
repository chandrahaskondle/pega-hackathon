package com.pega.hackathon.healthcare.controllers;


import com.pega.hackathon.healthcare.model.*;
import com.pega.hackathon.healthcare.repositories.CitizenUserRepository;
import com.pega.hackathon.healthcare.repositories.IllnessRepository;
import com.pega.hackathon.healthcare.repositories.VaccinationDriveRepository;
import com.pega.hackathon.healthcare.repositories.VaccinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user/citizen")
@CrossOrigin
public class UserController {

    @Autowired
    private CitizenUserRepository citizenUserRepository;

    @Autowired
    private VaccinationRepository vaccinationRepository;

    @Autowired
    private IllnessRepository illnessRepository;

    @Autowired
    private VaccinationDriveRepository vaccinationDriveRepository;

    public String login() {
        return "";
    }

    @PostMapping(path = "/register", consumes = "application/json")
    public String register(@RequestBody CitizenUser citizenUser) {
        this.citizenUserRepository.save(citizenUser);
        return HttpStatus.OK.toString();
    }

    @GetMapping("/{userName}")
    public String getUser(@PathVariable String userName) {
        CitizenUser user = (CitizenUser) citizenUserRepository.findByUserName(userName);
        return user.getFirstName();
    }

    @PostMapping(path = "/{userName}/updateVax", consumes = "application/json")
    private String updateVaccinationHistory(@PathVariable String userName, @RequestBody Vaccination vaccination) {
        this.vaccinationRepository.save(vaccination);
        return HttpStatus.OK.toString();
    }

    @PostMapping(path = "/{userName}/registerVax", consumes = "application/json")
    private String registerForVaccination(@PathVariable String userName, @RequestBody VaccinationDrive vaccinationDrive) {
        vaccinationDrive.setIsSlotAvailable(false);
        this.vaccinationDriveRepository.save(vaccinationDrive);
        CitizenUser user = (CitizenUser) citizenUserRepository.findByUserName(userName);

        Vaccination vax = new Vaccination();
        vax.setLocation(vaccinationDrive.getAddress().toString());
        vax.setHealthCareProvider(vaccinationDrive.getHealthCareProvider());
        vax.setDateOfRegistration(new Date());
        vax.setVaccine(vaccinationDrive.getVaccine());
        vax.setUser(user);
        this.vaccinationRepository.save(vax);

        return HttpStatus.OK.toString();
    }

    @PostMapping(path = "/{userName}/reportIllness", consumes = "application/json")
    private String reportIllness(@PathVariable String userName, @RequestBody Illness illness) {
        this.illnessRepository.save(illness);
        return HttpStatus.OK.toString();
    }

    @GetMapping("/{userName}/vaxHistory")
    private Vaccination[] getVaccinationHistory(@PathVariable String userName) {
        CitizenUser user = (CitizenUser) this.citizenUserRepository.findByUserName(userName);
        return this.vaccinationRepository.findByUser(user);
    }

    @GetMapping("/{userName}/vaxCert")
    private String getVaccinationCertificate(@PathVariable String userName) {
        return "";
    }
}
