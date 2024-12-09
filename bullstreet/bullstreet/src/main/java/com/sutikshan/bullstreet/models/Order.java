package com.sutikshan.bullstreet.models;

import com.sutikshan.bullstreet.domain.OrderStatus;
import com.sutikshan.bullstreet.domain.OrderType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document
@Data
public class Order {

    @Id
    private String id;

    @DBRef
    private User user;

    private OrderType orderType;

    private BigDecimal price;

    private LocalDateTime timestamp=LocalDateTime.now();

    private OrderStatus status;

    private OrderItem orderItem;
}
