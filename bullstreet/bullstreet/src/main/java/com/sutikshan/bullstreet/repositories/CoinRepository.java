package com.sutikshan.bullstreet.repositories;

import com.sutikshan.bullstreet.models.Coin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CoinRepository extends MongoRepository<Coin, String> {

}
