package com.pega.hackathon.healthcare.controllers;


import com.pega.hackathon.healthcare.model.*;
import com.pega.hackathon.healthcare.repositories.CitizenUserRepository;
import com.pega.hackathon.healthcare.repositories.IllnessRepository;
import com.pega.hackathon.healthcare.repositories.VaccinationDriveRepository;
import com.pega.hackathon.healthcare.repositories.VaccinationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin
public class UserController {

    private CitizenUserRepository citizenUserRepository;
    private VaccinationRepository vaccinationRepository;
    private IllnessRepository illnessRepository;
    private VaccinationDriveRepository vaccinationDriveRepository;

    public UserController(CitizenUserRepository citizenUserRepository,
                          VaccinationRepository vaccinationRepository,
                          IllnessRepository illnessRepository,
                          VaccinationDriveRepository vaccinationDriveRepository) {
        this.citizenUserRepository = citizenUserRepository;
        this.vaccinationRepository = vaccinationRepository;
        this.illnessRepository = illnessRepository;
        this.vaccinationDriveRepository = vaccinationDriveRepository;
    }

    public String login() {
        return "";
    }

    @PostMapping(path = "/user", consumes = "application/json")
    public String register(@RequestBody CitizenUser citizenUser) {
        this.citizenUserRepository.save(citizenUser);
        return HttpStatus.OK.toString();
    }

    @GetMapping("/user/{userName}")
    public String getUser(@PathVariable String userName) {
        CitizenUser user = (CitizenUser) citizenUserRepository.findByUserName(userName);
        return user.getFirstName();
    }

    @PostMapping(path = "/user/{userName}/updateVax", consumes = "application/json")
    private String updateVaccinationHistory(@PathVariable String userName, @RequestBody Vaccination vaccination) {
        this.vaccinationRepository.save(vaccination);
        return HttpStatus.OK.toString();
    }

    @PostMapping(path = "/user/{userName}/registerVax", consumes = "application/json")
    private String registerForVaccination(@PathVariable String userName, @RequestBody VaccinationDrive vaccinationDrive) {
        vaccinationDrive.setIsSlotAvailable(false);
        this.vaccinationDriveRepository.save(vaccinationDrive);
        CitizenUser user = (CitizenUser) citizenUserRepository.findByUserName(userName);

        Vaccination vax = new Vaccination();
        vax.setLocation(vaccinationDrive.getLocation());
        vax.setHealthCareProvider(vaccinationDrive.getHealthCareProvider());
        vax.setDateOfRegistration(new Date());
        vax.setVaccine(vaccinationDrive.getVaccine());
        vax.setUser(user);
        this.vaccinationRepository.save(vax);

        return HttpStatus.OK.toString();
    }

    @PostMapping(path = "/user/{userName}/reportIllness", consumes = "application/json")
    private String reportIllness(@PathVariable String userName, @RequestBody Illness illness) {
        this.illnessRepository.save(illness);
        return HttpStatus.OK.toString();
    }

    @GetMapping("/user/{userName}/vaxHistory")
    private Vaccination[] getVaccinationHistory(@PathVariable String userName) {
        CitizenUser user = (CitizenUser) this.citizenUserRepository.findByUserName(userName);
        return this.vaccinationRepository.findByUser(user);
    }

    @GetMapping("/user/{userName}/vaxCert")
    private String getVaccinationCertificate(@PathVariable String userName) {
        return "";
    }
}
