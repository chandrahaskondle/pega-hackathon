package com.pega.hackathon.aadharservice.controller;


import com.pega.hackathon.aadharservice.model.Response;
import com.pega.hackathon.aadharservice.model.VerificationResponse;
import com.pega.hackathon.aadharservice.service.AadharService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class AadharVerificationController {

    @Autowired
    private AadharService aadharService;

    @GetMapping("/sendOtp")
    public ResponseEntity<Response> sendOtp(@RequestParam String aadharNumber) {
        Response otpResponse = new Response();
        String response = aadharService.sendOtp(aadharNumber);
        otpResponse.setAadhar(aadharNumber);
        otpResponse.setResponseMessage(response);
        return new ResponseEntity<>(otpResponse, HttpStatus.OK);


    }
    @GetMapping("/verifyOtp")
    public ResponseEntity<Response> verifyOtp(@RequestParam String otp, @RequestParam String aadharNumber){
        Response otpResponse = aadharService.verifyOtp(otp, aadharNumber);
        return new ResponseEntity<>(otpResponse, HttpStatus.OK);
    }
}
