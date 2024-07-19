package com.orderfulfilmentapplication.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


import com.orderfulfilmentapplication.entity.TPayment;
@Repository
public interface PaymentRepository extends JpaRepository<TPayment, BigInteger> {

}
