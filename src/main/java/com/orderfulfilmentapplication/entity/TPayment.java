package com.orderfulfilmentapplication.entity;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.orderfulfilmentapplication.enums.Status;

import lombok.Data;

@Entity
@Table(name = "PAYMENT")
@Data
public class TPayment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger paymentId;
	@Column
	private String description;
	@Column
	private Status status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name = "orderId", referencedColumnName = "orderId")
	TOrders order;

}
