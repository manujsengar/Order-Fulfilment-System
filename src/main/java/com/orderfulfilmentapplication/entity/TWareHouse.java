package com.orderfulfilmentapplication.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "WAREHOUSE")
@Data
public class TWareHouse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	BigInteger wareHouseId;
	@Column
	String address;
	@Column
	String city;
	@Column
	String country;
	@Column
	String pinCode;
	@Column
	String contactNo;
	@Column
	String email;
}
