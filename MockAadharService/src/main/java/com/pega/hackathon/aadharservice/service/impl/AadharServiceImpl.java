package com.pega.hackathon.aadharservice.service.impl;

import com.pega.hackathon.aadharservice.model.Aadhar;
import com.pega.hackathon.aadharservice.model.OtpDetails;
import com.pega.hackathon.aadharservice.model.Response;
import com.pega.hackathon.aadharservice.repo.AadharRepo;
import com.pega.hackathon.aadharservice.repo.OtpDetailsRepo;
import com.pega.hackathon.aadharservice.service.AadharService;
import com.pega.hackathon.aadharservice.service.EmailService;
import com.pega.hackathon.aadharservice.service.SmsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class AadharServiceImpl implements AadharService {

    @Autowired
    private AadharRepo aadharRepo;

    @Autowired
    private OtpDetailsRepo otpDetailsRepo;

    @Autowired
    private EmailService emailService;

    @Autowired
    private SmsServiceImpl smsService;

    @Override
    public String sendOtp(String aadharNumber) {
        Aadhar aadharByAadharNumber = aadharRepo.findByAadharNumber(aadharNumber);
        if (aadharByAadharNumber != null) {
            OtpDetails otpDetails = new OtpDetails();
            otpDetails.setAadhar(aadharByAadharNumber);
            Random random = new Random();
            int otp = 100000 + random.nextInt(900000);
            otpDetails.setOtp(String.valueOf(otp));
            otpDetails.setCreatedDate(new Date());
            otpDetails.setEmailId(aadharByAadharNumber.getEmailId());
            otpDetails.setPhoneNumber(aadharByAadharNumber.getPhoneNumber());
            emailService.sendEmail(aadharByAadharNumber.getEmailId(), String.valueOf(otp));
            otpDetails.setModeOfCommunication("EMAIL");
            otpDetails.setIsEmailSent(true);
            smsService.sendSms(aadharByAadharNumber.getPhoneNumber(), String.valueOf(otp));
            otpDetailsRepo.save(otpDetails);
        } else {
            return "Invalid Aadhar Number";
        }
        return "Otp sent Successfully";
    }

    @Override
    public Response verifyOtp(String otp, String aadharNumber) {
        Response response = new Response();
        response.setAadhar(aadharNumber);
        if (otp == null) {
            response.setResponseMessage("Invalid otp");
        } else {
            OtpDetails otpDetails = otpDetailsRepo.findByAadhar_AadharNumberAndOtp(aadharNumber, otp);
            if (otpDetails.getOtp() != null && otpDetails.getAadhar() != null) {
                long diff = System.currentTimeMillis() - otpDetails.getCreatedDate().getTime();
                long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);
                if (minutes > 5) {
                    response.setResponseMessage("otp expired");
                } else {
                    Aadhar aadhar = aadharRepo.findByAadharNumber(aadharNumber);
                    aadhar.setIsVerified(true);
                    aadhar.setVerifiedDate(new Date());
                    aadharRepo.save(aadhar);
                    response.setResponseMessage("Kyc verified successfully");
                }
            } else {
                response.setResponseMessage("Invalid otp");
            }
        }
        return response;
    }
}
