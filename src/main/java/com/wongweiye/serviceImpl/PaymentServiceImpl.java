package com.wongweiye.serviceImpl;

import com.wongweiye.dto.PaymentAndPaymentTransactionDTO;
import com.wongweiye.model.Payment;
import com.wongweiye.model.PaymentAndPaymentTransaction;
import com.wongweiye.model.PaymentTransactionAndFund;
import com.wongweiye.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaymentServiceImpl {

    @Autowired
    PaymentRepository paymentRepository;

    public List<PaymentTransactionAndFund> getPaymentAndFund(long channelId){

        List<PaymentTransactionAndFund> list = paymentRepository.findByPaymentAndPaymentTransactionFund(channelId);

        return list;

    }

    public List<PaymentAndPaymentTransaction> getPaymentAndPaymentTransaction(long paymentId){

        List<PaymentAndPaymentTransaction> list = paymentRepository.GetPaymentAndPaymentTransaction(paymentId);

        return list;

    }

    public List<PaymentAndPaymentTransactionDTO> getPaymentAndPaymentTransaction2(long paymentId){

        List<PaymentAndPaymentTransactionDTO> list = paymentRepository.findPaymentAndPaymentTransactionByDTO(paymentId);

        return list;

    }
}
