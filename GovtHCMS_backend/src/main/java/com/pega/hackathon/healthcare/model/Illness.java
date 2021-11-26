package com.pega.hackathon.healthcare.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Illness implements Serializable {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(unique = true)
    private String illnessName;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private CitizenUser user;
    private String typeOfIllness;
    private String symptoms;

}
