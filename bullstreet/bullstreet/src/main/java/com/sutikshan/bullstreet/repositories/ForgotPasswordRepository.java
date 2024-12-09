package com.sutikshan.bullstreet.repositories;

import com.sutikshan.bullstreet.models.ForgotPasswordToken;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ForgotPasswordRepository extends MongoRepository<ForgotPasswordToken, String> {

    ForgotPasswordToken findByUserId(String userId);

}
