package com.pega.hackathon.aadharservice.repo;

import com.pega.hackathon.aadharservice.model.OtpDetails;
import org.springframework.data.repository.CrudRepository;

public interface OtpDetailsRepo extends CrudRepository<OtpDetails, Integer> {

    OtpDetails findByAadhar_AadharNumberAndOtp(String aadhar, String otp);
}
