package com.orderfulfilmentapplication.model;

import java.math.BigInteger;

import lombok.Data;

@Data
public class WareHousea {

	
	BigInteger wareHouseId;
	String address;
	String city;
	String country;
	String pinCode;
	String contactNo;
	String email;
}
