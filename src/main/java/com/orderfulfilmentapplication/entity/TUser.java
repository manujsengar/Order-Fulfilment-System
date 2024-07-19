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
@Table(name = "Users")
@Data
public class TUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger userId;
	@Column
	private String status;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String contactNo;
	@Column
	private String address;
	@Column
	private String pincode;
	@Column
	private String city;
	@Column
	private String country;

	

}
