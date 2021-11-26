package com.pega.hackathon.healthcare.controllers;

import com.pega.hackathon.healthcare.model.*;
import com.pega.hackathon.healthcare.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user/healthCareProvider")
@CrossOrigin
public class HealthCareProviderController {

    @Autowired
    private HealthCareProviderRepository healthCareProviderRepository;

    @Autowired
    private VaccinationDriveRepository vaccinationDriveRepository;

    @Autowired
    private VaccinationRepository vaccinationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CertificateRepository certificateRepository;

    public String login() {
        return "";
    }

    @PostMapping
    public String register(@RequestBody HealthCareProvider healthCareProvider) {
        this.healthCareProviderRepository.save(healthCareProvider);
        return HttpStatus.OK.toString();
    }

    @PostMapping(path = "/vaccinationDrive", consumes = "application/json")
    public String createVaccinationDrive(@RequestBody VaccinationDrive vaccinationDrive) {
        this.vaccinationDriveRepository.save(vaccinationDrive);
        return HttpStatus.OK.toString();
    }

    @PostMapping(path = "/user/{userName}/certificate", consumes = "application/json")
    public String createVaccinationCertificate(@PathVariable String healthCareProviderName,
                                           @PathVariable String userName,
                                           @RequestBody VaccinationDrive vaccinationDrive) {
        Certificate cert = new Certificate();
        cert.setUserName(userName);
        cert.setIllness(vaccinationDrive.getIllness());
        cert.setVaccine(vaccinationDrive.getVaccine().getName());
        cert.setHealthCareProvider(vaccinationDrive.getHealthCareProvider().getUserName());
        cert.setDateOfVaccination(new Date());
        cert.setAddress(vaccinationDrive.getAddress().toString());
        this.certificateRepository.save(cert);
        return HttpStatus.OK.toString();
    }

    @PutMapping(path = "/user/{userName}/vaccination", consumes = "application/json")
    private String updateVaccinationHistoryForUser(@PathVariable String userName) {
        CitizenUser user = (CitizenUser) this.userRepository.findByUserName(userName);
        Vaccination[] vaxArr = this.vaccinationRepository.findByUser(user);
        Vaccination lastVaccination = vaxArr[vaxArr.length-1];
        lastVaccination.setDateOfVaccination(new Date());
        lastVaccination.setVaccinated(true);
        this.vaccinationRepository.save(lastVaccination);
        return HttpStatus.OK.toString();
    }
}
