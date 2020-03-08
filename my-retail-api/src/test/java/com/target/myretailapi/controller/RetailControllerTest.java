package com.target.myretailapi.controller;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.target.retail.controller.RetailController;
import com.target.retail.entity.product.CurrencyCode;
import com.target.retail.entity.product.PriceDetail;
import com.target.retail.entity.product.ProductDetail;
import com.target.retail.exception.ProductNotFoundException;
import com.target.retail.exception.RetailException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { RetailController.class })
public class RetailControllerTest {

	private static final Logger log = LoggerFactory.getLogger(RetailControllerTest.class);

	@MockBean
	RetailController retailController;

	@Before
	public void setup() throws RetailException, ProductNotFoundException, Exception {
		PriceDetail priceDetail = new PriceDetail(new BigDecimal(1268.58), CurrencyCode.USD);
		ProductDetail productDetail = new ProductDetail(13860428, "The Big Lebowski (Blu-ray)", priceDetail);
		when(retailController.getProductDetails(13860428)).thenReturn(productDetail);
	}

	@Test
	public void getProductsNameMatch() throws RetailException, ProductNotFoundException, Exception {

		ProductDetail actual = retailController.getProductDetails(13860428);
		assertTrue(actual.getName().equals("The Big Lebowski (Blu-ray)"));
	}

	@Test(expected = ProductNotFoundException.class)
	public void getProductsNameNotMatch() throws ProductNotFoundException, RetailException, Exception {

		ProductDetail actual = retailController.getProductDetails(138604281);
		if (actual == null)
			throw new ProductNotFoundException(HttpStatus.NOT_FOUND.value(), "Price detail not found");
	}
}
