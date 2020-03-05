package com.target.retail.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.target.retail.entity.product.ProductDetail;

import java.util.Optional;

public interface PriceRepository extends PagingAndSortingRepository<ProductDetail, Integer> {
    Optional<ProductDetail> findById(Integer id);
}
