package com.pega.hackathon.healthcare.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class CitizenUser extends User {

    public CitizenUser(int id, String userName, String password) {
        super(id, userName, password);
    }

    public AadharDetails getAadharDetails() {
        return aadharDetails;
    }

    public void setAadharDetails(AadharDetails aadharDetails) {
        this.aadharDetails = aadharDetails;
    }

    private AadharDetails aadharDetails;
    private   Date dateOfBirth;


}
