package com.target.retail.repository;

import com.target.retail.entity.product.ProductDetail;
/**
 * 
 * @author atulgupta
 *
 */
public interface PriceCustomRepository {
    ProductDetail findById(Integer id);
    ProductDetail update(Integer id,ProductDetail productDetail);
}
