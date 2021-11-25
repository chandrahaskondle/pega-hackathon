package com.pega.hackathon.healthcare.repositories;

import com.pega.hackathon.healthcare.model.Certificate;
import org.springframework.data.repository.CrudRepository;

public interface CertificateRepository extends CrudRepository<Certificate, Integer> {
    Certificate findByUserName(String userName);
}
