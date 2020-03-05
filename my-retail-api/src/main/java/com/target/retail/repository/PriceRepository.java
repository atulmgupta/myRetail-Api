package com.target.retail.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.target.retail.entity.product.PriceDetail;

public interface PriceRepository extends CrudRepository<PriceDetail, Integer> {
    Optional<PriceDetail> findById(Integer id);

}
