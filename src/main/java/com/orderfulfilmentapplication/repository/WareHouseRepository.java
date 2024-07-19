package com.orderfulfilmentapplication.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.orderfulfilmentapplication.entity.TWareHouse;
@Repository
public interface WareHouseRepository extends JpaRepository<TWareHouse, BigInteger> {

}
