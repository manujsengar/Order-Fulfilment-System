package com.orderfulfilmentapplication.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "INVENTORY")
@Data
public class TInventory {
	@Id  @GeneratedValue(strategy = GenerationType.AUTO)
	private  BigInteger productId;
	@Column
	private BigDecimal price;
	@Column
	private Integer quantity;
	@Column
	private String description;
	@Column
	private Integer unitSold;
//	@Column
//	private Integer wareHouseId;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "wareHouseId")
	private List<TWareHouse> wareHouse;
    
}
