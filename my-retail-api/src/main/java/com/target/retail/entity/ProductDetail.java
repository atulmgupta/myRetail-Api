package com.target.retail.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productDetail")
public class ProductDetail {
	@Id
	private Integer id;
	private String name;
	private ProductPrice current_price;

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

	public ProductPrice getCurrent_price() {
		return current_price;
	}

	public void setCurrent_price(ProductPrice current_price) {
		this.current_price = current_price;
	}

	

}
