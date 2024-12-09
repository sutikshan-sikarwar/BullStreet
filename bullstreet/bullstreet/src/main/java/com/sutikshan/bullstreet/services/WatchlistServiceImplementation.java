package com.sutikshan.bullstreet.services;

import com.sutikshan.bullstreet.models.Coin;
import com.sutikshan.bullstreet.models.User;
import com.sutikshan.bullstreet.models.Watchlist;
import com.sutikshan.bullstreet.repositories.WatchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WatchlistServiceImplementation implements WatchlistService {

    @Autowired
    private WatchlistRepository watchlistRepository;

    @Override
    public Watchlist findUserWatchList(String userId) {
        Watchlist watchlist =
        return null;
    }

    @Override
    public Watchlist createWatchlist(User user) {
        return null;
    }

    @Override
    public Watchlist findById(Long id) {
        return null;
    }

    @Override
    public Coin addItemToWatchlist(Coin coin, User user) {
        return null;
    }
}
