package com.sutikshan.bullstreet.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
@Data
public class Wallet {

    @Id
    private String id;

    @DBRef
    private User user;

    private BigDecimal balance;
}
