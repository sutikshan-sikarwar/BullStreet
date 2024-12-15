package com.sutikshan.bullstreet.repositories;

import com.sutikshan.bullstreet.models.PaymentDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentDetailsRepository extends MongoRepository<PaymentDetails, String> {
    PaymentDetails findByUserId(String userId);
}
