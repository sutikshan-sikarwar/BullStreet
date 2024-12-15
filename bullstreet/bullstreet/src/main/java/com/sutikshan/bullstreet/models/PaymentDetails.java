package com.sutikshan.bullstreet.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class PaymentDetails {

    @Id
    private String id;

    private String accountNumber;

    private String accountHolderName;

    private String ifsc;

    private String bankName;

    @DBRef
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;
}
