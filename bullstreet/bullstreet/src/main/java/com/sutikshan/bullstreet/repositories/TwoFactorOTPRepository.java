package com.sutikshan.bullstreet.repositories;

import com.sutikshan.bullstreet.models.TwoFactorOTP;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TwoFactorOTPRepository extends MongoRepository<TwoFactorOTP, String> {
    TwoFactorOTP findByUserId(String userId);  // Works since 'userId' is a separate field now
}

