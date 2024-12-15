package com.sutikshan.bullstreet.repositories;

import com.sutikshan.bullstreet.models.PaymentOrder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentOrderRepository extends MongoRepository<PaymentOrder, String> {
}
