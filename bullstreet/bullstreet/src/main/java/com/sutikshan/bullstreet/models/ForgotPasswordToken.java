package com.sutikshan.bullstreet.models;

import com.sutikshan.bullstreet.domain.VerificationType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class ForgotPasswordToken {

    private String id;

    @DBRef
    private User user;

    private String otp;

    private VerificationType verificationType;

    private  String sendTo;

}
