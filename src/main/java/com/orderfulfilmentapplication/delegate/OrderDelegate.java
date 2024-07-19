package com.orderfulfilmentapplication.delegate;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.orderfulfilmentapplication.entity.TOrders;
import com.orderfulfilmentapplication.entity.TUser;
import com.orderfulfilmentapplication.model.Response;
import com.orderfulfilmentapplication.service.OrderService;
import com.orderfulfilmentapplication.service.UserService;

@Component
public class OrderDelegate {

	
	@Autowired
	OrderService orderService;
	@Autowired
	UserService userService;

	public TUser addUser(TUser user) {

		return userService.addUser(user);
	}
	
	public List<TOrders> getAllOrders(BigInteger userId) {

		return orderService.getAllOrders(userId);
	}

	public Response getOrderById(BigInteger id) {

		return orderService.getOrderById(id);
	}

	public Response newOrder(TOrders order) {

		return null;
	}

	public Response cancel(BigInteger id) {
		return orderService.cancel(id);
	}

	public Response complete(BigInteger id) {
		return orderService.complete(id);
	}

	public Response updateOrderStatus(BigInteger id, TOrders order) {
		Response updateOrderStatus = orderService.updateOrderStatus(id, order);
	///
		try {
			Thread.sleep(1000L);// this represents some business logic to or external call
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateOrderStatus;
	}

	public CompletableFuture<List<TOrders>> findAll(List<Integer> id) {
		// TODO Auto-generated method stub
		return null;
	}

}
