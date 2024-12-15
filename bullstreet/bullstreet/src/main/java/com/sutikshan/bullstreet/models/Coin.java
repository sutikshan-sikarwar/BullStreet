package com.sutikshan.bullstreet.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Coin {

    @Id
    private String id;
    private String symbol;
    private String name;
    private String image;
    private double currentPrice;
    private long marketCap;
    private int marketCapRank;
    private long fullyDilutedValuation;
    private long totalVolume;
    private double high24h;
    private double low24h;
    private double priceChange24h;
    private double priceChangePercentage24h;
    private long marketCapChange24h; // e.g.,
    private double marketCapChangePercentage24h;
    private double circulatingSupply;
    private double totalSupply;
    private double maxSupply;
    private double ath;
    private double athChangePercentage;
    private LocalDateTime athDate;
    private double atl;
    private double atlChangePercentage;
    private LocalDateTime atlDate;
    @JsonIgnore
    private String roi;
    private LocalDateTime lastUpdated;
}
