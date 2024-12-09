package com.sutikshan.bullstreet.models;

import com.sutikshan.bullstreet.domain.VerificationType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class VerificationCode {

    private String id;

    private String otp;

    @DBRef
    private User user;

    private String email;

    private String mobile;

    private VerificationType verificationType;

}
