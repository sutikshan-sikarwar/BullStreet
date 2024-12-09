package com.sutikshan.bullstreet.repositories;

import com.sutikshan.bullstreet.models.VerificationCode;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VerificationCodeRepository extends MongoRepository<VerificationCode, String> {

    public VerificationCode findByUserId(String id);
}
