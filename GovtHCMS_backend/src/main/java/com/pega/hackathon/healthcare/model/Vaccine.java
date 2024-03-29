package com.pega.hackathon.healthcare.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Vaccine {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(unique = true, nullable = false)
    private int id;
    private String name;
    private double price;
    private String description;
}
