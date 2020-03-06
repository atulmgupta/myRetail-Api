package com.target.retail.dao;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.target.retail.entity.product.CurrencyCode;
import com.target.retail.entity.product.PriceDetail;
import com.target.retail.entity.product.ProductDetail;
import com.target.retail.repository.ProductRepository;

/**
 * 
 * @author atulgupta
 *
 */
@Component
public class ProductDao {

	@Autowired
	ProductRepository productRepository;

	@EventListener
	public void appReady(ApplicationReadyEvent event) {
		ProductDetail detail = new ProductDetail();
		detail.setId(13860428);
		detail.setCurrent_price(new PriceDetail(new BigDecimal(154.25), CurrencyCode.USD));
		productRepository.save(detail);
	}

}
