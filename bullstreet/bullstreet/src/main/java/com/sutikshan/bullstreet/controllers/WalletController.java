package com.sutikshan.bullstreet.controllers;

import com.sutikshan.bullstreet.models.Order;
import com.sutikshan.bullstreet.models.User;
import com.sutikshan.bullstreet.models.Wallet;
import com.sutikshan.bullstreet.models.WalletTransaction;
import com.sutikshan.bullstreet.services.OrderService;
import com.sutikshan.bullstreet.services.UserService;
import com.sutikshan.bullstreet.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @GetMapping()
    public ResponseEntity<Wallet> getUserWallet(@RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwt(jwt);

        Wallet wallet = walletService.getUserWallet(user);
        return new ResponseEntity<>(wallet, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{walletId}/transfer")
    public ResponseEntity<Wallet> walletToWalletTransfer(
            @RequestHeader("Authorization") String jwt,
            @PathVariable String walletId,
            @RequestBody WalletTransaction req) throws Exception{
        User senderUser = userService.findUserByJwt(jwt);
        Wallet receiverWallet = walletService.findWalletById(walletId);
        Wallet wallet = walletService.walletToWalletTransfer(senderUser, receiverWallet, req.getAmount());
        return new ResponseEntity<>(wallet, HttpStatus.ACCEPTED);
    }

    @PutMapping("/order/{orderId}/pay")
    public ResponseEntity<Wallet> payOrderPayment(
            @RequestHeader("Authorization") String jwt,
            @PathVariable String orderId) throws Exception{
        User user = userService.findUserByJwt(jwt);
        Order order = orderService.getOrderById(orderId);
        Wallet wallet = walletService.payOrderPayment(order,user);
        return new ResponseEntity<>(wallet, HttpStatus.ACCEPTED);
    }
}
