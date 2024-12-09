package com.sutikshan.bullstreet.utils;

import java.util.Random;

public class OTPUtils {
    public static String generateOTP(){
        int otpLeangth = 6;
        Random random = new Random();
        StringBuilder otp = new StringBuilder(otpLeangth);

        for (int i = 0; i<otpLeangth; i++){
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }
}
