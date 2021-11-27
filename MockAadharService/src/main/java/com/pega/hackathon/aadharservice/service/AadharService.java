package com.pega.hackathon.aadharservice.service;


import com.pega.hackathon.aadharservice.model.Response;
import org.springframework.stereotype.Service;

@Service
public interface AadharService {

    String sendOtp(String aadharNumber);

    Response verifyOtp(String otp, String aadharNumber);

}
