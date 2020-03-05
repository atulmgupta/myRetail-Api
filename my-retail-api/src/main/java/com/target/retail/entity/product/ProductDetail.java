package com.target.retail.entity.product;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Document(collection = "productDetail")
public class ProductDetail implements Serializable {
    @Id
    @NotNull
    private Integer id;
    @NotNull
    private String name;

    @Positive
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
