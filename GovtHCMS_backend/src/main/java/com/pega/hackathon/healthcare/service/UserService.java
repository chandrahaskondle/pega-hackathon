package com.pega.hackathon.healthcare.service;

import com.pega.hackathon.healthcare.model.CitizenUser;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void registerUser(CitizenUser citizenUser);
}
