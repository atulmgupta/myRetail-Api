package com.target.retail.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.target.retail.entity.product.ProductDetail;
/**
 * 
 * @author atulgupta
 *
 */
public interface ProductRepository  extends PagingAndSortingRepository<ProductDetail,Integer> {
}
