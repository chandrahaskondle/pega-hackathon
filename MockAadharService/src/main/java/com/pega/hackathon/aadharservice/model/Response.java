package com.pega.hackathon.aadharservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Response {

    private String aadhar;
    private String responseMessage;

    public Response() {

    }
}
