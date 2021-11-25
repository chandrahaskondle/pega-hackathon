package com.pega.hackathon.healthcare.repositories;

import com.pega.hackathon.healthcare.model.VaccinationDrive;
import org.springframework.data.repository.CrudRepository;

public interface VaccinationDriveRepository extends CrudRepository<VaccinationDrive, Integer> {
    VaccinationDrive findByIllness(String illness);

    VaccinationDrive findByLocation(String location);
}
