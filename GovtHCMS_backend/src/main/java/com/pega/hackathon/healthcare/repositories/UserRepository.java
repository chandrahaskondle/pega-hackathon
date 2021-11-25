package com.pega.hackathon.healthcare.repositories;

import com.pega.hackathon.healthcare.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository<T extends User> extends CrudRepository<T, Integer> {
}
