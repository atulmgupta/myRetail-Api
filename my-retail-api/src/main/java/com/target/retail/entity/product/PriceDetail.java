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

	private BigDecimal value;

	private CurrencyCode currency_code = CurrencyCode.USD;

	public PriceDetail(BigDecimal value, CurrencyCode currency_code) {
		this.value = value;
		this.currency_code = currency_code;
	}

	public PriceDetail() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public CurrencyCode getCurrency_code() {
		return currency_code;
	}

	public void setCurrency_code(CurrencyCode currency_code) {
		this.currency_code = currency_code;
	}

}
