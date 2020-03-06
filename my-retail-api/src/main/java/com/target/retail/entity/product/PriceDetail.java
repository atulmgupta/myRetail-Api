package com.target.retail.entity.product;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author atulgupta
 *
 */
@Document(value = "priceDetail")
public class PriceDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonIgnore
	private Integer id;

	private BigDecimal price;

	private CurrencyCode currency_code = CurrencyCode.USD;

	public PriceDetail(Integer id, BigDecimal price, CurrencyCode currency_code) {
		this.id = id;
		this.price = price;
		this.currency_code = currency_code;
	}

	public PriceDetail() {
		// TODO Auto-generated constructor stub
	}

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

	public CurrencyCode getCurrency_code() {
		return currency_code;
	}

	public void setCurrency_code(CurrencyCode currency_code) {
		this.currency_code = currency_code;
	}

}
