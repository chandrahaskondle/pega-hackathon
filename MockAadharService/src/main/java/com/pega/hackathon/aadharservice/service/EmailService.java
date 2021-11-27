package com.pega.hackathon.aadharservice.service;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    public void sendEmail(String toEmail, String otp);
}
