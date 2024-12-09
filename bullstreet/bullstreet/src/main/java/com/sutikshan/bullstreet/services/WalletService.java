package com.sutikshan.bullstreet.services;

import com.sutikshan.bullstreet.models.Order;
import com.sutikshan.bullstreet.models.User;
import com.sutikshan.bullstreet.models.Wallet;

public interface WalletService {

    Wallet getUserWallet(User user);

    Wallet addBalance(Wallet wallet, Long money);

    Wallet findWalletById(String id) throws Exception;

    Wallet walletToWalletTransfer(User sender, Wallet receiverWallet, Long amount) throws Exception;

    Wallet payOrderPayment(Order order, User user) throws Exception;
}
