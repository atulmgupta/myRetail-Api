package com.target.retail.repository;

import com.target.retail.entity.ProductDetail;

public interface PriceCustomRepository {
    ProductDetail findById(Integer id);
    ProductDetail update(Integer id,ProductDetail productDetail);
}
