package com.sutikshan.bullstreet.controllers;

import com.sutikshan.bullstreet.models.User;
import com.sutikshan.bullstreet.models.Wallet;
import com.sutikshan.bullstreet.models.Withdrawal;
import com.sutikshan.bullstreet.services.UserService;
import com.sutikshan.bullstreet.services.WalletService;
import com.sutikshan.bullstreet.services.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WithdrawalController {

    @Autowired
    private WithdrawalService withdrawalService;

    @Autowired
    private UserService userService;

    @Autowired
    private WalletService walletService;

    @PostMapping("/api/withdrawal/{amount}")
    public ResponseEntity<?> withdrawalRequest(
            @PathVariable Long amount,
            @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwt(jwt);
        Wallet userWallet = walletService.getUserWallet(user);

        Withdrawal withdrawal = withdrawalService.requestWithdrawal(amount, user);
        walletService.addBalance(userWallet, -withdrawal.getAmount());

        //Transaction

        return new ResponseEntity<>(withdrawal, HttpStatus.OK);

    }

    @PatchMapping("/api/admin/withdrawal/{id}/proceed/{accept}")
    public ResponseEntity<?> proceedWithdrawal(
            @PathVariable String id,
            @PathVariable boolean accept,
            @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwt(jwt);
        Withdrawal withdrawal = withdrawalService.proceedWithWithdrawal(id,accept);
        Wallet userWallet = walletService.getUserWallet(user);

        if(!accept){
            walletService.addBalance(userWallet, withdrawal.getAmount());
        }
        return new ResponseEntity<>(withdrawal,HttpStatus.OK);
    }

    @GetMapping("/api/withdrawal")
    public ResponseEntity<List<Withdrawal>> getWithdrawalHistory(
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwt(jwt);
        List<Withdrawal> withdrawals = withdrawalService.getUserWithdrawalHistory(user);
        return new ResponseEntity<>(withdrawals, HttpStatus.OK);
    }

    @GetMapping("/api/admin/withdrawal")
    public  ResponseEntity<List<Withdrawal>> getAllWithdrawalRequests(
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwt(jwt);
        List<Withdrawal> withdrawals = withdrawalService.getAllWithdrawalRequest();
        return new ResponseEntity<>(withdrawals, HttpStatus.OK);
    }
}
