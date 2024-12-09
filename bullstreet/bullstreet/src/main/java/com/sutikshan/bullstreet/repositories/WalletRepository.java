package com.sutikshan.bullstreet.repositories;

import com.sutikshan.bullstreet.models.Wallet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WalletRepository extends MongoRepository<Wallet, String > {
    Wallet findByUserId(String userId);
}
