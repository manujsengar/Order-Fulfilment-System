package com.orderfulfilmentapplication.delegate;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orderfulfilmentapplication.controller.OrderController;
import com.orderfulfilmentapplication.entity.TOrders;
import com.orderfulfilmentapplication.entity.TUser;
import com.orderfulfilmentapplication.model.Response;

@RestController
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class OrderControllerImpl implements OrderController {
	@Autowired
	OrderDelegate orderDelegate;
	private static final Logger log = LoggerFactory.getLogger(OrderControllerImpl.class);
//	@Override
//	public Flux<List<TOrders>> getAllOrders(@PathVariable BigInteger userId) {
//		orderDelegate.getAllOrders(userId);
//		return null;
//	}
//
//	@Override
//	public Mono<TOrders> getOrderById(@PathVariable BigInteger id) {
//		orderDelegate.getOrderById(id);
//		return null;
//	}
//
//	@Override
//	public Mono<Response> newOrder(@RequestBody TOrders order) {
//		Response newOrder = orderDelegate.newOrder(order);
//		return newOrder;
//	}
//
//	@Override
//	public Mono<?> cancel(@PathVariable BigInteger id) {
//		Response cancel = orderDelegate.cancel(id);
//		return orderDelegate.cancel(id);
//	}
//
//	@Override
//	public Mono<?> updateOrderStatus(@PathVariable BigInteger id, @RequestBody TOrders order) {
//		orderDelegate.updateOrderStatus(id, order);
//		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
//				.header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE)
//				.body(Problem.create().withTitle("Method not allowed")
//						.withDetail("You can't complete an order that is in the " + order.getStatus() + " status"));
//	}
//
//	@Override
//	public Mono<?> complete(BigInteger id) {
//		orderDelegate.complete(id);
//		return null;
//	}
//
//	@Override
//	public Mono<TUser> addUser(TUser user) {
//		orderDelegate.addUser(user);
//		return null;
//	}

	@Override
	public List<TOrders> getAllOrders(@PathVariable BigInteger userId) {
		
		return orderDelegate.getAllOrders(userId);
	}

	@Override
	public Response getOrderById(@PathVariable BigInteger id) {
		orderDelegate.getOrderById(id);
		return orderDelegate.getOrderById(id);
	}

	@Override
	public Response newOrder(@RequestBody TOrders order) {
		Response newOrder = orderDelegate.newOrder(order);
		return newOrder;
	}

	@Override
	public Object cancel(@PathVariable BigInteger id) {
		return orderDelegate.cancel(id);
	}

	@Override
	public Object updateOrderStatus(@PathVariable BigInteger id, @RequestBody TOrders order) {
		orderDelegate.updateOrderStatus(id, order);
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
				.header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE)
				.body(Problem.create().withTitle("Method not allowed")
						.withDetail("You can't complete an order that is in the " + order.getStatus() + " status"));
	}

	@Override
	public Object complete(BigInteger id) {
		orderDelegate.complete(id);
		return null;
	}

	@Override
	public TUser addUser(TUser user) {
		orderDelegate.addUser(user);
		return null;
	}

	@Async("asyncTaskExecutor")
	public CompletableFuture<ResponseEntity> getUsers(List<Integer> id) {
		return orderDelegate.findAll(id).<ResponseEntity>thenApply(ResponseEntity::ok)
				.exceptionally(handleGetUsersFailure);
	}

	private static Function<Throwable, ResponseEntity> handleGetUsersFailure = throwable -> {
		log.error("Unable to retrieve users", throwable);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	};

}
