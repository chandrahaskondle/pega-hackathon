package com.pega.hackathon.healthcare.repositories;

import com.pega.hackathon.healthcare.model.CitizenUser;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenUserRepository extends UserRepository<CitizenUser> {
}
