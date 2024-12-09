package com.sutikshan.bullstreet.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Data
public class Watchlist {

    @Id
    private String id;

    @DBRef
    private User user;

    @DBRef
    private List<Coin> coins = new ArrayList<>();
}
