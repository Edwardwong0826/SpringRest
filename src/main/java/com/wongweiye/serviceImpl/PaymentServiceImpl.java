package com.wongweiye.serviceImpl;

import com.wongweiye.model.Payment;
import com.wongweiye.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaymentServiceImpl {

    @Autowired
    PaymentRepository paymentRepository;

    public List<Payment> getPaymentAndFund(long channelId){

        List<Payment> list = paymentRepository.findByPaymentAndPaymentTransactionFund2(channelId);

        return list;

    }
}
