package com.pega.hackathon.healthcare.service;

import com.pega.hackathon.healthcare.model.CitizenUser;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Service
public interface UserService {
    void registerUser(CitizenUser citizenUser);
    ByteArrayInputStream generatePDF(int id) throws IOException;
}
