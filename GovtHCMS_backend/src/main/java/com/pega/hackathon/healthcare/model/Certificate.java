package com.pega.hackathon.healthcare.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Certificate {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(unique = true, nullable = false)
    private Integer id;
    private String userName;
    private String healthCareProvider;
    private String address;
    private String illness;
    private String vaccine;
    private Date dateOfVaccination;
}
