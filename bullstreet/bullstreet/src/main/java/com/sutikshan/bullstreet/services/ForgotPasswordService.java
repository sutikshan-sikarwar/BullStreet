package com.sutikshan.bullstreet.services;

import com.sutikshan.bullstreet.domain.VerificationType;
import com.sutikshan.bullstreet.models.ForgotPasswordToken;
import com.sutikshan.bullstreet.models.User;

public interface ForgotPasswordService {

    ForgotPasswordToken createToken(User user, String id, String otp, VerificationType  verificationType, String sendTo);

    ForgotPasswordToken findById(String id);

    ForgotPasswordToken findByUser(String userId);

    void deleteToken(ForgotPasswordToken token);

}
