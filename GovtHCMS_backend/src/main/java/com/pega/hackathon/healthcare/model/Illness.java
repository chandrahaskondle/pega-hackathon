package com.pega.hackathon.healthcare.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Illness implements Serializable {


    @Id
    private String illnessName;
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private CitizenUser user;
    private String typeOfIllness;
    private String symptoms;

}
