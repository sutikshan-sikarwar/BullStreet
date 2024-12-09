package com.sutikshan.bullstreet.repositories;

import com.sutikshan.bullstreet.models.Withdrawal;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WithdrawalRepository extends MongoRepository<Withdrawal, String> {
    List<Withdrawal> findByUserId(String userId);
}
