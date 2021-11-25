package com.pega.hackathon.healthcare.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "user")
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private String gender;
    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Address address;


}
