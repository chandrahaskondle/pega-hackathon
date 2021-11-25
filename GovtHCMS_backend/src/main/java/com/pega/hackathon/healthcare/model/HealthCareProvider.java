package com.pega.hackathon.healthcare.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorValue("healthcare_provider")
public class HealthCareProvider extends User {

    private String associatedInstitute;
}
