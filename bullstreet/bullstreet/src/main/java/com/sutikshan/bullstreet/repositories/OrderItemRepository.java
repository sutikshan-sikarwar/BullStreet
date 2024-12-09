package com.sutikshan.bullstreet.repositories;

import com.sutikshan.bullstreet.models.OrderItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderItemRepository extends MongoRepository<OrderItem, String> {
}
