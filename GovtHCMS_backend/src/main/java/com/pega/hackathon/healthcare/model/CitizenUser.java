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


    @OneToOne
    @JoinColumn(name = "aadharId", nullable = false)
    private AadharDetails aadharDetails;
    private Date dateOfBirth;


}
