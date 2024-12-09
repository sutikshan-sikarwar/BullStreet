package com.sutikshan.bullstreet.services;

import com.sutikshan.bullstreet.models.TwoFactorOTP;
import com.sutikshan.bullstreet.models.User;

public interface TwoFactorOTPService {

    TwoFactorOTP createTwoFactorOtp(User user, String otp, String jwt);

    TwoFactorOTP findByUserId(String userId);  // Renamed method to be more precise

    TwoFactorOTP findById(String id);

    boolean verifyTwoFactorOTP(TwoFactorOTP twoFactorOTP, String otp);

    void deleteTwoFactorOTP(TwoFactorOTP twoFactorOTP);
}
