package com.target.retail.service.data;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.target.retail.repository.ProductRepository;

public class DataService {
	@Autowired
	ProductRepository productRepository;

	@PostConstruct
	public void init() {
		loadProductPriceInDB();
	}

	// Load the products in DB
	private void loadProductPriceInDB() {
//
//		if (priceRepo != null) {
//
//			List<PriceDetail> pricelist = new ArrayList<PriceDetail>();
//			pricelist.add(new PriceDetail(13860428, new BigDecimal(17.89), CurrencyCode.USD));
//			pricelist.add(new PriceDetail(16752456, new BigDecimal(17.89), CurrencyCode.USD));
//			pricelist.add(new PriceDetail(16752457, new BigDecimal(17.89), CurrencyCode.USD));
//			// Deleting any data before load
//			priceRepo.deleteAll();
//			priceRepo.saveAll(pricelist);
//		}
	}
}
