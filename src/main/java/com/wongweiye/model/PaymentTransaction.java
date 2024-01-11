package com.wongweiye.model;

import javax.persistence.*;

@Entity
@Table(name = "paymenttransaction")
public class PaymentTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paymentid")
    private Payment payment;

    @Column(name = "channelid")
    private long channelId;

}
