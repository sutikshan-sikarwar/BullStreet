package com.sutikshan.bullstreet.repositories;

import com.sutikshan.bullstreet.models.Asset;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AssetRepository extends MongoRepository<Asset, String> {

    List<Asset> findByUserId(String userId);

    Asset findByUserIdAndCoinId(String userId, String CoinId);
}
