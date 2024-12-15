package com.sutikshan.bullstreet.services;

import com.sutikshan.bullstreet.models.PaymentDetails;
import com.sutikshan.bullstreet.models.User;

public interface PaymentDetailsService {
    public PaymentDetails addPaymentDetails(String accountNumber,
                                            String accountHolderName,
                                            String ifsc,
                                            String bankName,
                                            User user
    );

    public PaymentDetails getUsersPaymentDetails(User user);
}
