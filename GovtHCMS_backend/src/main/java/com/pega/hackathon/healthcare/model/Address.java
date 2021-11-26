package com.pega.hackathon.healthcare.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    private String houseNumber;
    private String addressLine1;
    private String addressLine2;
    private String Country;
    private String city;
    private String state;
    private String postalCode;

    @Override
    public String toString() {
        return houseNumber + ", "
                + addressLine1 + ", "
                + addressLine2 + ", "
                + city + ", "
                + state + ", "
                + Country + ", "
                + "( " + postalCode + ")";
    }
}
