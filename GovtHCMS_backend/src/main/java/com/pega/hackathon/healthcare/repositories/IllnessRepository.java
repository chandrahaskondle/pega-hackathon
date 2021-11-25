package com.pega.hackathon.healthcare.repositories;

import com.pega.hackathon.healthcare.model.Illness;
import org.springframework.data.repository.CrudRepository;

public interface IllnessRepository extends CrudRepository<Illness, String> {
}
