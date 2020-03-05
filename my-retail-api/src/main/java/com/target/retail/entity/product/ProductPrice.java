package com.target.retail.entity.product;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "productPrice")
public class ProductPrice implements Serializable {
	@Id
	private Integer id;

	private BigDecimal price;
	
	private CurrencyCode code = CurrencyCode.USD;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public CurrencyCode getCode() {
		return code;
	}

	public void setCode(CurrencyCode code) {
		this.code = code;
	}
}
