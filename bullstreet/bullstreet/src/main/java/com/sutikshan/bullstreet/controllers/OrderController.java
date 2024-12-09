package com.sutikshan.bullstreet.controllers;

import com.sutikshan.bullstreet.domain.OrderType;
import com.sutikshan.bullstreet.models.Coin;
import com.sutikshan.bullstreet.models.Order;
import com.sutikshan.bullstreet.models.User;
import com.sutikshan.bullstreet.models.WalletTransaction;
import com.sutikshan.bullstreet.requests.CreateOrderRequest;
import com.sutikshan.bullstreet.services.CoinService;
import com.sutikshan.bullstreet.services.OrderService;
import com.sutikshan.bullstreet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private CoinService coinService;

    //@Autowired
    // private WalletTransactionService walletTransactionService;

    @PostMapping("/pay")
    public ResponseEntity<Order> payOrderPayment(
            @RequestHeader("Authorization") String jwt,
            @RequestBody CreateOrderRequest req) throws Exception{

        User user = userService.findUserByJwt(jwt);
        Coin coin = coinService.findById(req.getCoinId());
        Order order = orderService.processOrder(coin, req.getQuantity(), req.getOrderType(), user);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(
            @RequestHeader("Authorization") String jwt,
            @PathVariable String orderId) throws Exception{
        if (jwt==null){
            throw new Exception("token missing...");
        }

        User user = userService.findUserByJwt(jwt);

        Order order = orderService.getOrderById(orderId);
        if (order.getUser().getId().equals(user.getId())){
            return ResponseEntity.ok(order);
        }
        else{
            throw new Exception("you don't have access");

        }
    }
    @GetMapping()
    public ResponseEntity<List<Order>> getAllOrdersForUser(
            @RequestHeader("Authorization") String jwt,
            @RequestParam(required = false) OrderType order_type,
            @RequestParam(required = false) String asset_symbol
    ) throws Exception{
        String userId = userService.findUserByJwt(jwt).getId();
        List<Order> userOrders = orderService.getAllOrdersOfUsers(userId, order_type, asset_symbol);
        return ResponseEntity.ok(userOrders);
    }

}
