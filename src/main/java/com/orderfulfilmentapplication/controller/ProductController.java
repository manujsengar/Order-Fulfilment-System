package com.orderfulfilmentapplication.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.orderfulfilmentapplication.entity.TInventory;
import com.orderfulfilmentapplication.entity.TWareHouse;

@RequestMapping("/product")
public interface ProductController {

	@GetMapping(value = "/getProduct/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	TInventory getProduct(@PathVariable BigInteger productId);

	@GetMapping(value = "/getProducts", produces = MediaType.APPLICATION_JSON_VALUE)
	List<TInventory> getTopSellingProducts();

	@GetMapping(value = "/{id}/getWareHouse", produces = MediaType.APPLICATION_JSON_VALUE)
	List<TWareHouse> getWareHouseDetails(@PathVariable BigInteger id);

	@PostMapping(value = "/addProduct", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> addProduct(@RequestBody List<TInventory> inventory);

	@DeleteMapping("/product/{id}")
	ResponseEntity<?> deleteProduct(@PathVariable BigInteger id);

	@PutMapping(value = "/orders/{id}/complete", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> dicontinueProduct(@RequestBody TInventory inventory);

}
