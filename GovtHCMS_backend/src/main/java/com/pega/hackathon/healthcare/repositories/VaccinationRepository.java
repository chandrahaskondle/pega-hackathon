package com.pega.hackathon.healthcare.repositories;

import com.pega.hackathon.healthcare.model.CitizenUser;
import com.pega.hackathon.healthcare.model.Vaccination;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationRepository extends CrudRepository<Vaccination, Integer> {
    Vaccination[] findByUser(CitizenUser user);
}
