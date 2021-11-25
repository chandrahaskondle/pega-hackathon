package com.pega.hackathon.healthcare.model;

import javax.persistence.Entity;

@Entity
public class HealthCareProvider extends User{
    public HealthCareProvider(int id, String userName, String password) {
        super(id, userName, password);
    }
}
