package com.sutikshan.bullstreet.requests;

import com.sutikshan.bullstreet.domain.VerificationType;
import lombok.Data;

@Data
public class ForgotPasswordTokenRequest {

    private String sendTo;
    private VerificationType verificationType;
}
