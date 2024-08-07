package com.orderfulfilmentapplication.orderfulfilment;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.orderfulfilmentapplication.controller.OrderController;

import com.orderfulfilmentapplication.enums.Status;

@Component
public class OrderModelAssembler // implements RepresentationModelAssembler<Order, EntityModel<Order>>
{

//	@Override
//	public EntityModel<Order> toModel(Order order) {
//		EntityModel<Order> orderModel = EntityModel.of(order,
//				linkTo(methodOn(OrderController.class).one(order.getId())).withSelfRel(),
//				linkTo(methodOn(OrderController.class).all(null)).withRel("orders"));
//		
//		if (order.getStatus() == Status.IN_PROGRESS) {
//			orderModel.add(linkTo(methodOn(OrderController.class).cancel(order.getId())).withRel("cancel"));
//			orderModel.add(linkTo(methodOn(OrderController.class).complete(order.getId())).withRel("complete"));
//		}
//		return orderModel;
//	}
//
//	@Override
//	public EntityModel<com.orderfulfilmentapplication.orderfulfilment.Order> toModel(
//			com.orderfulfilmentapplication.orderfulfilment.Order entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
