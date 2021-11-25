package com.pega.hackathon.aadharservice.repo;

import com.pega.hackathon.aadharservice.model.Aadhar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AadharRepo extends CrudRepository<Aadhar, Integer> {

    @Query("select a from Aadhar a where a.aadharNumber=:aadharNumber")
    Aadhar findByAadharNumber(@Param("aadharNumber") String aadharNumber);
}
