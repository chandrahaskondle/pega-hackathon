package com.pega.hackathon.healthcare.controllers;


import com.pega.hackathon.healthcare.model.*;
import com.pega.hackathon.healthcare.repositories.*;
import com.pega.hackathon.healthcare.service.EmailService;
import com.pega.hackathon.healthcare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/user/citizen")
@CrossOrigin
public class UserController {

    private static Random rand;

    @Autowired
    private CitizenUserRepository citizenUserRepository;

    @Autowired
    private VaccinationRepository vaccinationRepository;

    @Autowired
    private IllnessRepository illnessRepository;

    @Autowired
    private VaccinationDriveRepository vaccinationDriveRepository;

    @Autowired
    private CertificateRepository certificateRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    public String login() {
        return "";
    }

    @PostMapping(path = "/register", consumes = "application/json")
    public String register(@RequestBody CitizenUser citizenUser) {
        userService.registerUser(citizenUser);
        return HttpStatus.OK.toString();
    }

    @PostMapping(path = "/loginUser", consumes = "application/json")
    public String loginUser(@RequestBody MyUserDetails myUserDetails) {
        return HttpStatus.OK.toString();
    }

    @GetMapping("/{userName}")
    public String getUser(@PathVariable String userName) {
        CitizenUser user = (CitizenUser) citizenUserRepository.findByUserName(userName);
        return user.getFirstName();
    }

    @PostMapping(path = "/{userName}/vaccination/history", consumes = "application/json")
    private String createVaccinationHistory(@PathVariable String healthCareProviderUserName, @RequestBody Vaccination vaccination) {
        CitizenUser user = (CitizenUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.userService.save(vaccination,user,healthCareProviderUserName);
        return HttpStatus.OK.toString();
    }

    @PostMapping(path = "/{userName}/vaccination/register", consumes = "application/json")
    private String registerForVaccinationDrive(@PathVariable String userName,
                                               @RequestBody VaccinationDrive vaccinationDrive) {
        vaccinationDrive.setIsSlotAvailable(false);
        this.vaccinationDriveRepository.save(vaccinationDrive);
        CitizenUser user = (CitizenUser) citizenUserRepository.findByUserName(userName);

        Vaccination vax = new Vaccination();
        vax.setLocation(vaccinationDrive.getAddress().toString());
        vax.setHealthCareProvider(vaccinationDrive.getHealthCareProvider());
        vax.setDateOfRegistration(new Date());
        vax.setVaccine(vaccinationDrive.getVaccine());
        vax.setUser(user);
        int appointmentId = rand.nextInt(100000);
        vax.setAppointmentId(appointmentId);
        this.vaccinationRepository.save(vax);
        emailService.sendEmail(user.getEmailAddress(), appointmentId);
        return HttpStatus.OK.toString();
    }

    @PostMapping(path = "/{userName}/reportIllness", consumes = "application/json")
    private String reportIllness(@PathVariable String userName, @RequestBody Illness illness) {
        this.illnessRepository.save(illness);
        return HttpStatus.OK.toString();
    }

    @GetMapping("/{userName}/vaccination/history")
    private ResponseEntity<List<Vaccination>> getVaccinationHistory(@PathVariable String userName) {
        CitizenUser user = (CitizenUser) this.citizenUserRepository.findByUserName(userName);
        List<Vaccination> vaccinations = new ArrayList<>();
        this.vaccinationRepository.findByUser(user).forEach(vaccinations::add);
        return new ResponseEntity<>(vaccinations, HttpStatus.OK);
    }

    @GetMapping(value = "/certificate",produces = MediaType.APPLICATION_PDF_VALUE)
    private ResponseEntity getVaccinationCertificate(@RequestParam int certificateId) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal().toString());
        ByteArrayInputStream bis = this.userService.generatePDF(certificateId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
