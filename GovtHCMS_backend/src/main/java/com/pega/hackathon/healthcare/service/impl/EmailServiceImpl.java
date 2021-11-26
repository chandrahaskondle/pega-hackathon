package com.pega.hackathon.healthcare.service.impl;

import com.pega.hackathon.healthcare.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String toEmail, Integer appointmentId) {
        String vaxRegMessage = "Your Appointment-ID for vaccination is " + appointmentId;
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject("Registered for Vaccination: Appointment-ID");
        simpleMailMessage.setText(vaxRegMessage);
        simpleMailMessage.setFrom("noreply@ghcms.com");
        javaMailSender.send(simpleMailMessage);
    }
}
