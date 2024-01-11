package com.wongweiye.repository;

import com.wongweiye.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("Select p from PaymentTransaction p join Fund f on p.payment.id = f.transactionPaymentId" +
           "where p.channelId = :channelId ")
    List<Payment> findByPaymentAndPaymentTransactionFund(@Param("channelId") Long channelId);

}
