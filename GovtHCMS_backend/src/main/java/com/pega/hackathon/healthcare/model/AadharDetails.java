package com.pega.hackathon.healthcare.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class AadharDetails {

    @Id
    private String aadharId;
    private String phoneNumber;

    @OneToOne(mappedBy = "aadharDetails", optional = false)
    private CitizenUser citizenUser;

}
