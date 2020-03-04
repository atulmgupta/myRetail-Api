package com.target.retail.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

public class ProductPrice {
	@Id
	private Integer id;

	private BigDecimal price;
	
	private CurrencyCode code;
}
