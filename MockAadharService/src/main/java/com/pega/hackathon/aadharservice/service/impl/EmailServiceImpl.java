package com.pega.hackathon.aadharservice.service.impl;

import com.pega.hackathon.aadharservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String toEmail, String otp) {
        String otpMessage = "Opt to verify KYC is " + otp;
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject("Verify your Aadhar");
        simpleMailMessage.setText(otpMessage);
        simpleMailMessage.setFrom("noreply@ghcms.com");
        javaMailSender.send(simpleMailMessage);
    }
}
