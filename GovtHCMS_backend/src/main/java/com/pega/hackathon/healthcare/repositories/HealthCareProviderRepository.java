package com.pega.hackathon.healthcare.repositories;

import com.pega.hackathon.healthcare.model.HealthCareProvider;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthCareProviderRepository extends UserRepository<HealthCareProvider> {
}
