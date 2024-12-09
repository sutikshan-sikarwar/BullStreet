package com.sutikshan.bullstreet.requests;

import com.sutikshan.bullstreet.domain.OrderType;
import lombok.Data;

@Data
public class CreateOrderRequest {

    private String coinId;
    private double quantity;
    private OrderType orderType;
}
