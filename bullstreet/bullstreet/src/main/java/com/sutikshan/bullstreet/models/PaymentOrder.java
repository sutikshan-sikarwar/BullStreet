package com.sutikshan.bullstreet.models;

import com.sutikshan.bullstreet.domain.PaymentMethod;
import com.sutikshan.bullstreet.domain.PaymentOrderStatus;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class PaymentOrder {

    @Id
    private String id;

    private Long amount;

    private PaymentOrderStatus status;

    private PaymentMethod paymentMethod;

    @DBRef
    private User user;
}
