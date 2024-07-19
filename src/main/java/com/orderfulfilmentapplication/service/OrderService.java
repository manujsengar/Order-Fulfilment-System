package com.orderfulfilmentapplication.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderfulfilmentapplication.entity.TOrders;
import com.orderfulfilmentapplication.entity.TUser;
import com.orderfulfilmentapplication.enums.Status;
import com.orderfulfilmentapplication.model.Response;
import com.orderfulfilmentapplication.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	NotificationService notificationService;

	public List<TOrders> getAllOrders(BigInteger userId) {
		TUser tUser = new TUser();
		tUser.setUserId(userId);
		List<TOrders> findByUser = orderRepository.findByUser(tUser);
		return findByUser;
	}

	public Response getOrderById(BigInteger id) {

		Response response = new Response();
		Optional<TOrders> findById = orderRepository.findById(id);
		if (findById.isPresent()) {
			response.setOrders(findById.get());
			return response;
		}
		response.setMessage("Order Not Found");
		return response;
	}

	public Response newOrder(TOrders order) {

		return null;
	}

	@Transactional
	public Response cancel(BigInteger id) {
		Response response = new Response();
		Optional<TOrders> findById = orderRepository.findById(id);
		if (findById.isPresent()) {
			if (!findById.get().getStatus().equals(Status.COMPLETED)) {
				TOrders tOrders = findById.get();
				tOrders.setStatus(Status.CANCELLED);
				TOrders save = orderRepository.save(tOrders);
				response.setOrders(save);
			} else {
				response.setOrders(findById.get());
				response.setMessage("Order already delivered");
			}

		} else {
			response.setMessage("Order Not Found");
		}

		return response;
	}

	@Transactional
	public Response complete(BigInteger id) {
		Response response = new Response();
		Optional<TOrders> findById = orderRepository.findById(id);
		if (findById.isPresent()) {
			if (!findById.get().getStatus().equals(Status.COMPLETED)) {
				TOrders tOrders = findById.get();
				tOrders.setStatus(Status.COMPLETED);
				TOrders save = orderRepository.save(tOrders);
				response.setOrders(save);
			} else {
				response.setOrders(findById.get());
				response.setMessage("Order already completed");
			}
		} else {
			response.setMessage("Order Not Found");
		}

		return response;
	}

	@Transactional
	public Response updateOrderStatus(BigInteger id, TOrders order) {
		Response response = new Response();
		Optional<TOrders> findById = orderRepository.findById(id);
		if (findById.isPresent()) {
			if (!findById.get().getStatus().equals(Status.COMPLETED)) {
				TOrders tOrders = findById.get();
				tOrders.setStatus(order.getStatus());
				TOrders save = orderRepository.save(tOrders);
				response.setOrders(save);
			} else {
				response.setOrders(findById.get());
				response.setMessage("Order already completed");
			}
		} else {
			response.setMessage("Order Not Found");
		}
		// Rabbit mq notification serive
		notificationService.publish(response);

		return response;
	}
}
