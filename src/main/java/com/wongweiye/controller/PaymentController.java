package com.wongweiye.controller;

import com.wongweiye.dto.ShipInformationDTO;
import com.wongweiye.model.Payment;
import com.wongweiye.serviceImpl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RequestMapping(path = "/v2", produces = "application/json")
@RestController
public class PaymentController {

    @Autowired
    PaymentServiceImpl paymentServiceImpl;

    @GetMapping("/payment/fund")
    public ResponseEntity<Payment> getPaymentAndFund(@RequestParam("channelId") long channelId){


        List<Payment> paymentAndFund = paymentServiceImpl.getPaymentAndFund(channelId);

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
