package com.target.retail.service.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.target.retail.entity.product.CurrencyCode;
import com.target.retail.entity.product.PriceDetail;
import com.target.retail.repository.PriceRepository;

public class DataService {
	@Autowired
	PriceRepository priceRepo;

	@PostConstruct
	public void init() {
		loadProductPriceInDB();
	}

	// Load the products in DB
	private void loadProductPriceInDB() {

		if (priceRepo != null) {

			List<PriceDetail> pricelist = new ArrayList<PriceDetail>();
			pricelist.add(new PriceDetail(13860428, new BigDecimal(17.89), CurrencyCode.USD));
			pricelist.add(new PriceDetail(16752456, new BigDecimal(17.89), CurrencyCode.USD));
			pricelist.add(new PriceDetail(16752457, new BigDecimal(17.89), CurrencyCode.USD));
			// Deleting any data before load
			priceRepo.deleteAll();
			priceRepo.saveAll(pricelist);
		}
	}
}
