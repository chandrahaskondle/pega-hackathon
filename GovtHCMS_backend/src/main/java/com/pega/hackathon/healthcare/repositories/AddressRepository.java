package com.pega.hackathon.healthcare.repositories;

import com.pega.hackathon.healthcare.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
