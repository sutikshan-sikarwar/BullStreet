package com.sutikshan.bullstreet.services;

import com.sutikshan.bullstreet.models.User;
import com.sutikshan.bullstreet.models.Withdrawal;

import java.util.List;

public interface WithdrawalService {

    Withdrawal requestWithdrawal(Long amount, User user);

    Withdrawal proceedWithWithdrawal(String withdrawalId, boolean accept) throws Exception;

    List<Withdrawal> getUserWithdrawalHistory(User user);

    List<Withdrawal> getAllWithdrawalRequest();
}
