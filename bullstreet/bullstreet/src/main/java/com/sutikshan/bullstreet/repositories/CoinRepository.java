package com.sutikshan.bullstreet.repositories;

import com.sutikshan.bullstreet.models.Coin;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CoinRepository extends MongoRepository<Coin, String> {
}
