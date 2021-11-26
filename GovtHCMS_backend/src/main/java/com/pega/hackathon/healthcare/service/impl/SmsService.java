package com.pega.hackathon.healthcare.service.impl;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class SmsService {

    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    public void sendSMS() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("+14159352345"),
                        new com.twilio.type.PhoneNumber("+14158141829"),
                        "Where's Wallace?")
                .create();

       // System.out.println(message.getSid());
    }
}
