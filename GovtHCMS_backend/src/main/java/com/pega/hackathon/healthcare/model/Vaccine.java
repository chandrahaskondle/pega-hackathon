package com.pega.hackathon.healthcare.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vaccine {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    private int id;
    private String name;
    private double price;
    private String description;
}
