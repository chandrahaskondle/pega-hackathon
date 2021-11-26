package com.pega.hackathon.healthcare.service.impl;

import com.pega.hackathon.healthcare.model.CitizenUser;
import com.pega.hackathon.healthcare.repositories.CitizenUserRepository;
import com.pega.hackathon.healthcare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private CitizenUserRepository citizenUserRepository;

    public void registerUser(CitizenUser citizenUser) {
        citizenUser.setPassword(bCryptPasswordEncoder.encode(citizenUser.getPassword()));
        citizenUserRepository.save(citizenUser);
    }
}
