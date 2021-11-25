package com.pega.hackathon.healthcare.repositories;

import com.pega.hackathon.healthcare.model.Vaccination;
import org.springframework.data.repository.CrudRepository;

public interface VaccinationRepository extends CrudRepository<Vaccination, Integer> {
}
