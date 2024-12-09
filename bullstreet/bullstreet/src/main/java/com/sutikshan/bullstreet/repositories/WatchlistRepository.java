package com.sutikshan.bullstreet.repositories;

import com.sutikshan.bullstreet.models.Watchlist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WatchlistRepository extends MongoRepository<Watchlist, String> {

    Watchlist findByUserId(String userId);

}
