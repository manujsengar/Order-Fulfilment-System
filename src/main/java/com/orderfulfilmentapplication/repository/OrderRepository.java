package com.orderfulfilmentapplication.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.orderfulfilmentapplication.entity.TOrders;
import com.orderfulfilmentapplication.entity.TUser;
@Repository
public interface OrderRepository extends JpaRepository<TOrders, BigInteger> {
List<TOrders> findByUser(TUser user);
}
