package com.pega.hackathon.healthcare.repositories;

import com.pega.hackathon.healthcare.model.VaccinationDrive;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationDriveRepository extends CrudRepository<VaccinationDrive, Integer> {
    VaccinationDrive findByIllness(String illness);

    VaccinationDrive findVaccinationDriveByAddressCity(String location);
}
