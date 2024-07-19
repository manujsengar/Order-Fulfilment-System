package com.orderfulfilmentapplication.entity;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.orderfulfilmentapplication.enums.Status;

import lombok.Data;

@Entity
@Table(name = "ORDERS")
@Data
public class TOrders {
	
	@Id  @GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger orderId;
	@Column
	private String description;
	@Column
	private Status status;
	@Column
    private String currentWareHouse;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	TUser user;

}
