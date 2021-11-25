package com.pega.hackathon.healthcare.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
public class VaccinationDrive {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(unique = true, nullable = false)
    private int id;
    private String illness;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Vaccine vaccine;
    private Date vaccinationDate;
    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Address address;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private HealthCareProvider healthCareProvider;
    private Boolean isSlotAvailable;
}
