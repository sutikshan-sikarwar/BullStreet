package com.sutikshan.bullstreet.services;

import com.sutikshan.bullstreet.domain.WithdrawalStatus;
import com.sutikshan.bullstreet.models.User;
import com.sutikshan.bullstreet.models.Withdrawal;
import com.sutikshan.bullstreet.repositories.WithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class WithdrawalServiceImplementation implements WithdrawalService{

    @Autowired
    private WithdrawalRepository withdrawalRepository;

    @Override
    public Withdrawal requestWithdrawal(Long amount, User user) {
        Withdrawal withdrawal = new Withdrawal();
        withdrawal.setAmount(amount);
        withdrawal.setUser(user);
        withdrawal.setStatus(WithdrawalStatus.PENDING);
        return withdrawalRepository.save(withdrawal);
    }

    @Override
    public Withdrawal proceedWithWithdrawal(String withdrawalId, boolean accept) throws Exception {
        Optional<Withdrawal> withdrawal = withdrawalRepository.findById(withdrawalId);
        if (withdrawal.isEmpty()){
            throw new Exception("withdrawal not found.");
        }
        Withdrawal withdrawal1 = withdrawal.get();
        withdrawal1.setDate(LocalDateTime.now());
        if (accept){
            withdrawal1.setStatus(WithdrawalStatus.SUCCESS);
        }
        else {
            withdrawal1.setStatus(WithdrawalStatus.DECLINE);
        }
        return withdrawalRepository.save(withdrawal1);
    }

    @Override
    public List<Withdrawal> getUserWithdrawalHistory(User user) {
        return withdrawalRepository.findByUserId(user.getId());
    }

    @Override
    public List<Withdrawal> getAllWithdrawalRequest() {
        return withdrawalRepository.findAll();
    }
}
