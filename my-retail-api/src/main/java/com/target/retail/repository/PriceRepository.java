package com.target.retail.repository;

import com.target.retail.entity.ProductDetail;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface PriceRepository extends PagingAndSortingRepository<ProductDetail, Integer> {
    Optional<ProductDetail> findById(Integer id);
}
