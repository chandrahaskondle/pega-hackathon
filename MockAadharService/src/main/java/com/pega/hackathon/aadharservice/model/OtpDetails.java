package com.pega.hackathon.aadharservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OtpDetails {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    private String phoneNumber;
    private String otp;
    private String emailId;
    private Date createdDate;
    private Boolean isEmailSent;
    private String modeOfCommunication;
    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Aadhar aadhar;
}
