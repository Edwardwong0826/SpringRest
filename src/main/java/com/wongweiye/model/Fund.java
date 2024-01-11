package com.wongweiye.model;

import javax.persistence.*;

@Entity
@Table(name = "fund")
public class Fund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long Id;

    @Column(name = "fund")
    private int fund;

    @Column(name = "transactionpaymentid")
    private long transactionPaymentId;
}
