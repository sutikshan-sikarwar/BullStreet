package com.sutikshan.bullstreet.services;

import com.sutikshan.bullstreet.domain.OrderType;
import com.sutikshan.bullstreet.models.Coin;
import com.sutikshan.bullstreet.models.Order;
import com.sutikshan.bullstreet.models.OrderItem;
import com.sutikshan.bullstreet.models.User;

import java.util.List;

public interface OrderService {

    Order createOrder(User user, OrderItem orderItem, OrderType orderType);

    Order getOrderById(String orderId) throws Exception;

    List<Order> getAllOrdersOfUsers(String userId, OrderType orderType, String assetSymbol);

    Order processOrder(Coin coin, double quantity, OrderType orderType, User user) throws Exception;



}
