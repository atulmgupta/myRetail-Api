package com.target.retail.entity.product;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;
/**
 * 
 * @author atulgupta
 *
 */
@Document(collection = "productDetail")
public class ProductDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotNull
	private String name;

	private PriceDetail current_price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PriceDetail getCurrent_price() {
		return current_price;
	}

	public void setCurrent_price(PriceDetail current_price) {
		this.current_price = current_price;
	}

}
