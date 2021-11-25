package com.pega.hackathon.healthcare.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AadharDetails {
    public String getAadharId() {
        return aadharId;
    }

    public void setAadharId(String aadharId) {
        this.aadharId = aadharId;
    }

    @Id
    private String aadharId;
    private String phoneNumber;
}
