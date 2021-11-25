package com.pega.hackathon.healthcare.repositories;

import com.pega.hackathon.healthcare.model.Vaccine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepository extends CrudRepository<Vaccine, Integer> {
}
