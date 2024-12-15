package com.sutikshan.bullstreet.services;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import com.sutikshan.bullstreet.domain.PaymentMethod;
import com.sutikshan.bullstreet.models.PaymentOrder;
import com.sutikshan.bullstreet.models.User;
import com.sutikshan.bullstreet.response.PaymentResponse;

public interface PaymentService {

    PaymentOrder createOrder(User user, Long amount, PaymentMethod paymentMethod);

    PaymentOrder getPaymentOrderById(String id) throws Exception;

    Boolean ProceedPaymentOrder (PaymentOrder paymentOrder,
                                 String paymentId) throws RazorpayException;

    PaymentResponse createRazorpayPaymentLink(User user,
                                              Long Amount,
                                              String orderId) throws RazorpayException;

    PaymentResponse createStripePaymentLink(User user, Long Amount,
                                            String orderId) throws StripeException;
}
