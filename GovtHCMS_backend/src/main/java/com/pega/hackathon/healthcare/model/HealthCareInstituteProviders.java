package com.pega.hackathon.healthcare.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter

public class HealthCareInstituteProviders {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    private String instituteName;

    @Column(unique = true)
    private String workEmail;

    private String userInstituteId;

}
