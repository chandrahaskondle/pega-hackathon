package com.pega.hackathon.healthcare.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorValue("citizen_user")

public class CitizenUser extends User {

    @Column(unique = true)
    private String aadharNumber;
    private Date dateOfBirth;
    private Boolean isKycVerified;

}
