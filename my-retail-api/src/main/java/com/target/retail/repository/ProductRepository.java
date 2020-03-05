package com.target.retail.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.target.retail.entity.product.ProductDetail;

public interface ProductRepository  extends PagingAndSortingRepository<ProductDetail,Integer> {
}
