package com.pega.hackathon.healthcare.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GovernmentAdmin extends User{

    public GovernmentAdmin(int id, String userName, String password) {
        super(id, userName, password);
    }
}
