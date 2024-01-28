package com.wongweiye.dto;

import com.wongweiye.model.Payment;
import com.wongweiye.model.PaymentTransaction;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PaymentAndPaymentTransactionDTO {

    Payment payment;
    PaymentTransaction paymentTransaction;

}
