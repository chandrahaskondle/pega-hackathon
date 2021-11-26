package com.pega.hackathon.healthcare.repositories;

import com.pega.hackathon.healthcare.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository<T extends User> extends CrudRepository<T, Integer> {
    User findByUserName(String userName);
}
