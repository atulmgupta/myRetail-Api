package com.target.myretailapi.integration;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.target.retail.entity.product.CurrencyCode;
import com.target.retail.entity.product.PriceDetail;
import com.target.retail.entity.product.ProductDetail;
import com.target.retail.exception.ProductNotFoundException;
import com.target.retail.exception.RetailException;
import com.target.retail.service.product.RemoteProductService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { RemoteProductService.class })
public class RemoteProductServiceTest {
	@MockBean
	ObjectMapper mapper;

	@MockBean
	RemoteProductService remoteProductService;

	@Before
	public void setup() throws RetailException, ProductNotFoundException, Exception {
		PriceDetail priceDetail = new PriceDetail(new BigDecimal(1268.58), CurrencyCode.USD);
		ProductDetail productDetail = new ProductDetail(13860428, "The Big Lebowski (Blu-ray)", priceDetail);
		when(remoteProductService.getProductNameById(13860428)).thenReturn("The Big Lebowski (Blu-ray)");
	}

	@Test
	public void productNameTestFound() throws RetailException, ProductNotFoundException {
		String productName = remoteProductService.getProductNameById(13860428);
		assertTrue(productName.equals("The Big Lebowski (Blu-ray)"));
	}

	@Test
	public void productNameTestNotFound() throws RetailException, ProductNotFoundException {

		String productName = remoteProductService.getProductNameById(138604218);
		assertNull(productName);

	}
}
