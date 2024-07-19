package com.orderfulfilmentapplication.model;

import java.math.BigInteger;

import com.orderfulfilmentapplication.enums.Status;

import lombok.Data;

@Data
public class Paymenta {

	Long paymentId;
	private String description;
	private Status status;
	BigInteger orderId;
	
	//Order order;

}
