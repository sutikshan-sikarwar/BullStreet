package com.sutikshan.bullstreet.services;

import com.sutikshan.bullstreet.domain.VerificationType;
import com.sutikshan.bullstreet.models.User;
import com.sutikshan.bullstreet.models.VerificationCode;
import com.sutikshan.bullstreet.repositories.VerificationCodeRepository;
import com.sutikshan.bullstreet.utils.OTPUtils;

import java.util.Optional;

public class VerificationCodeServiceImplementation implements VerificationCodeService {

    private VerificationCodeRepository verificationCodeRepository;

    @Override
    public VerificationCode sendVerificationCode(User user, VerificationType verificationType) {
        VerificationCode verificationCode1 = new VerificationCode();
        verificationCode1.setOtp(OTPUtils.generateOTP());
        verificationCode1.setVerificationType(verificationType);
        verificationCode1.setUser(user);
        return verificationCodeRepository.save(verificationCode1);
    }

    @Override
    public VerificationCode getVerificationCodeById(String id) throws Exception {
        Optional<VerificationCode> verificationCode = verificationCodeRepository.findById(id);
        if(verificationCode.isPresent()){
            return verificationCode.get();
        }
        throw new Exception("Verification code not found");
    }

    @Override
    public VerificationCode getVerificationCodeByUserId(String userId) {
        return verificationCodeRepository.findByUserId(userId);
    }

    @Override
    public void deleteVerificationCode(VerificationCode verificationCode) {
        verificationCodeRepository.delete(verificationCode);
    }
}
