package com.sutikshan.bullstreet.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class TwoFactorOTP {

    @Id
    private String id;

    private String otp;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String userId;  // Add this field to store the User's ID

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String jwt;
}
