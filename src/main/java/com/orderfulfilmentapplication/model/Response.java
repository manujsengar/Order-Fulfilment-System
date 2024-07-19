package com.orderfulfilmentapplication.model;

import com.orderfulfilmentapplication.entity.TInventory;
import com.orderfulfilmentapplication.entity.TOrders;
import com.orderfulfilmentapplication.entity.TPayment;
import com.orderfulfilmentapplication.entity.TUser;
import com.orderfulfilmentapplication.entity.TWareHouse;
import com.orderfulfilmentapplication.enums.Status;

import lombok.Data;

@Data
public class Response {

	String message;
	String exception;
	Status status;
	TOrders orders;
	TInventory inventory;
	TPayment payment;
	TUser user;
	TWareHouse wareHouse;

}
