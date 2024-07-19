package com.orderfulfilmentapplication.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.orderfulfilmentapplication.entity.TOrders;
import com.orderfulfilmentapplication.entity.TUser;
import com.orderfulfilmentapplication.model.Response;

@RequestMapping("/user")
public interface OrderController {

//	@GetMapping(value = "/getOrders/{user-id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	Flux<List<TOrders>> getAllOrders(@PathVariable BigInteger userId);
//
//	@PostMapping(value = "/addUser", produces = MediaType.APPLICATION_JSON_VALUE)
//	Mono<TUser> addUser(@RequestBody TUser user);
//
//	@GetMapping(value = "/order/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	Mono<TOrders> getOrderById(@PathVariable BigInteger id);
//
//	@PostMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//	Mono<Response> newOrder(@RequestBody TOrders order);
//
//	@DeleteMapping("/orders/{id}/cancel")
//	Mono<?> cancel(@PathVariable BigInteger id);
//
//	@PutMapping(value = "/orders/{id}/complete", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//	Mono<?> complete(@PathVariable BigInteger id);
//
//	@PutMapping(value = "/orders/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//	Mono<?> updateOrderStatus(@PathVariable BigInteger id, @RequestBody TOrders order);
	
	@GetMapping(value = "/getOrders/{user-id}", produces = MediaType.APPLICATION_JSON_VALUE)
	List<TOrders> getAllOrders(@PathVariable BigInteger userId);

	@PostMapping(value = "/addUser", produces = MediaType.APPLICATION_JSON_VALUE)
	TUser addUser(@RequestBody TUser user);

	@GetMapping(value = "/order/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	Response getOrderById(@PathVariable BigInteger id);

	@PostMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	Response newOrder(@RequestBody TOrders order);

	@DeleteMapping("/orders/{id}/cancel")
	Object cancel(@PathVariable BigInteger id);

	@PutMapping(value = "/orders/{id}/complete", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	Object complete(@PathVariable BigInteger id);

	@PutMapping(value = "/orders/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	Object updateOrderStatus(@PathVariable BigInteger id, @RequestBody TOrders order);

}
