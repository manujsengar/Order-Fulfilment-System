package com.orderfulfilmentapplication.model;

import java.math.BigInteger;

import com.orderfulfilmentapplication.enums.Status;

import lombok.Data;
@Data
public class Usera {

	
	BigInteger userId;
	Status status;
	String name;
	String email;
	String contactNo;
	String Address;
	String pincode;
	String city;
	String coutry;
	

}
