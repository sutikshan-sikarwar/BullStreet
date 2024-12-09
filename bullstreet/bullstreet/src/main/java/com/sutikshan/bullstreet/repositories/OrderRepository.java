package com.sutikshan.bullstreet.repositories;

import com.sutikshan.bullstreet.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order,String> {

    List<Order> findByUserId(String userId);
}
