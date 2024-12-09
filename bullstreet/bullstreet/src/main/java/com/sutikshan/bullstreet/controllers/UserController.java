package com.sutikshan.bullstreet.controllers;

import com.sutikshan.bullstreet.domain.VerificationType;
import com.sutikshan.bullstreet.models.ForgotPasswordToken;
import com.sutikshan.bullstreet.models.User;
import com.sutikshan.bullstreet.models.VerificationCode;
import com.sutikshan.bullstreet.requests.ForgotPasswordTokenRequest;
import com.sutikshan.bullstreet.requests.ResetPasswordRequest;
import com.sutikshan.bullstreet.response.ApiResponse;
import com.sutikshan.bullstreet.response.AuthResponse;
import com.sutikshan.bullstreet.services.EmailService;
import com.sutikshan.bullstreet.services.ForgotPasswordService;
import com.sutikshan.bullstreet.services.UserService;
import com.sutikshan.bullstreet.services.VerificationCodeService;
import com.sutikshan.bullstreet.utils.OTPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private VerificationCodeService verificationCodeService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ForgotPasswordService forgotPasswordService;

    @GetMapping("/api/users/profile")
    public ResponseEntity<User> getUserProfile(@RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwt(jwt);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/api/users/verification/{verificationType}/send-otp")
    public ResponseEntity<String> sendVerificationOTP(
            @RequestHeader("Authorization") String jwt,
            @PathVariable VerificationType verificationType) throws Exception {
        User user = userService.findUserByJwt(jwt);

        VerificationCode verificationCode = verificationCodeService.getVerificationCodeByUserId(user.getId());
        if (verificationCode==null){
            verificationCode = verificationCodeService.sendVerificationCode(user, verificationType);
        }

        if(verificationType.equals(VerificationType.EMAIL)){
            emailService.sendVerificationOTPEmail(user.getEmail(), verificationCode.getOtp());
        }

        return new ResponseEntity<>("Verification code sent successfully", HttpStatus.OK);
    }

    @PatchMapping("/api/users/enable-two-factor/verify-otp/{otp}")
    public ResponseEntity<User> enableTwoFactorAuthentication(
            @PathVariable String otp,
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwt(jwt);
        VerificationCode verificationCode = verificationCodeService.getVerificationCodeByUserId(user.getId());
        String sendTo = verificationCode.getVerificationType().equals(VerificationType.EMAIL)?
                verificationCode.getEmail():verificationCode.getMobile();
        boolean isVerified = verificationCode.getOtp().equals(otp);
        if (isVerified){
            User updatedUser = userService.enableTwoFactorAuthentication(verificationCode.getVerificationType(),sendTo,user);

            verificationCodeService.deleteVerificationCode(verificationCode);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }
        throw new Exception("Wrong OTP");
    }

    @PostMapping("/auth/users/reset-password/send-otp")
    public ResponseEntity<AuthResponse> sendForgotPasswordOTP(
            @RequestBody ForgotPasswordTokenRequest req) throws Exception {

        User user = userService.findUserByEmail(req.getSendTo());
        String otp = OTPUtils.generateOTP();
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();

        ForgotPasswordToken token = forgotPasswordService.findByUser(user.getId());
        if (token == null){
            token = forgotPasswordService.createToken(user, id, otp, req.getVerificationType(), req.getSendTo());
        }
        if (req.getVerificationType().equals(VerificationType.EMAIL)){
            emailService.sendVerificationOTPEmail(user.getEmail(), token.getOtp());
        }

        AuthResponse response = new AuthResponse();
        response.setSession(token.getId());
        response.setMessage("Reset password otp sent successfully");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/auth/users/reset-password/verify-otp")
    public ResponseEntity<ApiResponse> verifyForgotPasswordOtp(
            @RequestParam String id,
            @RequestBody ResetPasswordRequest req,
            @RequestHeader("Authorization") String jwt) throws Exception {

        ForgotPasswordToken forgotPasswordToken = forgotPasswordService.findById(id);

        boolean isVerified = forgotPasswordToken.getOtp().equals(req.getOtp());

        if(isVerified){
            userService.updatePassword(forgotPasswordToken.getUser(), req.getPassword());
            ApiResponse response = new ApiResponse();
            response.setMessage("Password updated Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
    }
        throw new Exception("Wrong OTP");
    }

}
