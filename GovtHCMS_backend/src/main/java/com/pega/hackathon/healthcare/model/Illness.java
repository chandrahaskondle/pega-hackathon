package com.pega.hackathon.healthcare.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Illness {

    public String getIllnessName() {
        return illnessName;
    }

    public void setIllnessName(String illnessName) {
        this.illnessName = illnessName;
    }

    @Id
    private String illnessName;
    private CitizenUser user;
    private String typeOfIllness;
    private String symptoms;

}
