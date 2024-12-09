package com.sutikshan.bullstreet.services;

import com.sutikshan.bullstreet.models.Coin;
import com.sutikshan.bullstreet.models.User;
import com.sutikshan.bullstreet.models.Watchlist;

public interface WatchlistService {

    Watchlist findUserWatchList(String userId);

    Watchlist createWatchlist(User user);

    Watchlist findById(Long id);

    Coin addItemToWatchlist(Coin coin, User user);
}
