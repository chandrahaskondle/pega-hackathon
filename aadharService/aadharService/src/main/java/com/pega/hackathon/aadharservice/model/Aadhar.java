package com.pega.hackathon.aadharservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Aadhar implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(unique = true)
    private String aadharNumber;

    private String phoneNumber;

    private String emailId;

    private Boolean isVerified;

    private Date verifiedDate;
}
