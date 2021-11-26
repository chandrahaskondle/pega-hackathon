package com.pega.hackathon.healthcare.controllers;

import com.pega.hackathon.healthcare.model.Address;
import com.pega.hackathon.healthcare.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @PostMapping
    public String registerVaccine(@RequestBody Address address) {
        this.addressRepository.save(address);
        return HttpStatus.OK.toString();
    }
}
