package com.wongweiye.controller;

import com.wongweiye.model.PaymentAndPaymentTransaction;
import com.wongweiye.model.PaymentTransactionAndFund;
import com.wongweiye.serviceImpl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path = "/v2", produces = "application/json")
@RestController
public class PaymentController {

    @Autowired
    PaymentServiceImpl paymentServiceImpl;

    @GetMapping("/payment/fund")
    public ResponseEntity<PaymentTransactionAndFund> getPaymentAndFund(@RequestParam("channelId") long channelId){


        List<PaymentTransactionAndFund> paymentAndFund = paymentServiceImpl.getPaymentAndFund(channelId);

        if(paymentAndFund != null)
        {
            return ResponseEntity.ok().body(paymentAndFund.get(0));

        }
        else
        {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/payment/transaction")
    public ResponseEntity<PaymentAndPaymentTransaction> getPaymentAndTransaction(@RequestParam("paymentId") long paymentId){


        List<PaymentAndPaymentTransaction> paymentAndFund = paymentServiceImpl.getPaymentAndPaymentTransaction(paymentId);

        if(paymentAndFund != null)
        {
            return ResponseEntity.ok().body(paymentAndFund.get(0));

        }
        else
        {
            return ResponseEntity.notFound().build();
        }

    }
}
