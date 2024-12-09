package com.sutikshan.bullstreet.models;

import com.sutikshan.bullstreet.domain.WalletTransactionType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Data
public class WalletTransaction {

    @Id
    private String id;

    @DBRef
    private Wallet wallet;

    private WalletTransactionType type;

    private LocalDate date;

    private String transferId;

    private String purpose;

    private Long amount;
}
