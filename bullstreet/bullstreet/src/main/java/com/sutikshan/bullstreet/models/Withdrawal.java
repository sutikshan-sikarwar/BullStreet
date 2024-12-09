package com.sutikshan.bullstreet.models;

import com.sutikshan.bullstreet.domain.WithdrawalStatus;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class Withdrawal {

    @Id
    private String id;

    private WithdrawalStatus status;

    private Long amount;

    @DBRef
    private User user;

    private LocalDateTime date = LocalDateTime.now();
}
