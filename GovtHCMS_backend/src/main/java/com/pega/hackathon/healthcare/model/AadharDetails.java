package com.pega.hackathon.healthcare.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class AadharDetails   implements Serializable {

    @Id
    @Column(unique = true, nullable = false)
    private String aadharId;
    private String phoneNumber;

    @OneToOne(mappedBy = "aadharDetails", optional = false)
    private CitizenUser citizenUser;

}
