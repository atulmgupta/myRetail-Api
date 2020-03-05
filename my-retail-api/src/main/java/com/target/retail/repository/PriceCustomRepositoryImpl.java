package com.target.retail.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.target.retail.entity.product.ProductDetail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

public class PriceCustomRepositoryImpl implements PriceCustomRepository {
	@Autowired
	MongoOperations mongoOperations;
	@Autowired
	ObjectMapper mapper;
	private static final Logger log = LoggerFactory.getLogger(PriceCustomRepositoryImpl.class);

	@Override
	public ProductDetail findById(Integer id) {
		return null;
	}

	@Override
	public ProductDetail update(Integer id, ProductDetail productDetail) {
		return null;
	}
}
