package com.orderfulfilmentapplication.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.orderfulfilmentapplication.entity.TInventory;

@Repository
public interface InventoryRepository extends JpaRepository<TInventory, BigInteger> {
	@Query(value = "Select * from Inventory t ORDER BY UNIT_SOLD limit 50", nativeQuery = true)
	List<TInventory> findTopProducts();
}
