package com.sutikshan.bullstreet.services;

import com.sutikshan.bullstreet.models.TwoFactorOTP;
import com.sutikshan.bullstreet.models.User;
import com.sutikshan.bullstreet.repositories.TwoFactorOTPRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TwoFactorServiceImplementation implements TwoFactorOTPService{

    private TwoFactorOTPRepository twoFactorOTPRepository;
    @Override
    public TwoFactorOTP createTwoFactorOtp(User user, String otp, String jwt) {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        TwoFactorOTP twoFactorOTP = new TwoFactorOTP();
        twoFactorOTP.setOtp(otp);
        twoFactorOTP.setJwt(jwt);
        twoFactorOTP.setUserId(id);
        return twoFactorOTPRepository.save(twoFactorOTP);
    }

    @Override
    public TwoFactorOTP findByUserId(String userId) {
        return twoFactorOTPRepository.findByUserId(userId);
    }

    @Override
    public TwoFactorOTP findById(String id) {
        Optional<TwoFactorOTP> opt = twoFactorOTPRepository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public boolean verifyTwoFactorOTP(TwoFactorOTP twoFactorOTP, String otp) {
        return twoFactorOTP.getOtp().equals(otp);
    }

    @Override
    public void deleteTwoFactorOTP(TwoFactorOTP twoFactorOTP) {

        twoFactorOTPRepository.delete(twoFactorOTP);
    }
}
