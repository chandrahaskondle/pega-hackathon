package com.pega.hackathon.aadharservice.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl {
    public static final String ACCOUNT_SID = "AC22642a5754f47f8eaa2939cc7ed30af4";
    public static final String AUTH_TOKEN = "f364eeb6fc0e846a6465ad165aaf7c4b";

    SmsServiceImpl() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public String sendSms(String mobileNumber, String otp) {
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(mobileNumber),
                        new com.twilio.type.PhoneNumber("+18647546251"),
                        "Otp for aadhar verification is " + otp + " Otp is valid for 5 min")
                .create();
        return message.getStatus().name();
    }
}