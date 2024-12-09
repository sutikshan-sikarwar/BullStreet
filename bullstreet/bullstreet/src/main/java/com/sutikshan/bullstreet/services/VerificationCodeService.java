package com.sutikshan.bullstreet.services;

import com.sutikshan.bullstreet.domain.VerificationType;
import com.sutikshan.bullstreet.models.User;
import com.sutikshan.bullstreet.models.VerificationCode;

public interface VerificationCodeService {

    VerificationCode sendVerificationCode(User user, VerificationType verificationType);

    VerificationCode getVerificationCodeById(String id) throws Exception;

    VerificationCode getVerificationCodeByUserId(String userId);

    void deleteVerificationCode(VerificationCode verificationCode);

}
