package com.pega.hackathon.healthcare.service;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    void sendEmail(String toEmail, Integer appointmentId);
}
