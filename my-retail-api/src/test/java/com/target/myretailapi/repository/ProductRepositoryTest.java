package com.target.myretailapi.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.target.retail.entity.product.CurrencyCode;
import com.target.retail.entity.product.PriceDetail;
import com.target.retail.entity.product.ProductDetail;
import com.target.retail.repository.ProductRepository;

@RunWith(SpringRunner.class)
public class ProductRepositoryTest {
	private static final ObjectMapper om = new ObjectMapper();
	@MockBean
	private RestTemplate restTemplate;

	@MockBean
	private ProductRepository mockRepository;

	@Before
	public void init() {
		PriceDetail priceDetail = new PriceDetail(new BigDecimal(1268.58), CurrencyCode.USD);
		ProductDetail productDetail = new ProductDetail(13860428, "The Big Lebowski (Blu-ray)", priceDetail);
		when(mockRepository.findById(13860428)).thenReturn(Optional.of(productDetail));
	}

	@Test
	public void findProductByIdFoundTest() throws JSONException {

		Optional<ProductDetail> result = mockRepository.findById(13860428);
		assertTrue(result.isPresent());

	}

	@Test
	public void findProductByIdNotFoundTest() throws JSONException {

		Optional<ProductDetail> result = mockRepository.findById(138604281);
		assertFalse(result.isPresent());

	}

	@Test
	public void findProductByIdMatchIdTest() throws JSONException {

		Optional<ProductDetail> result = mockRepository.findById(13860428);
		assertEquals(13860428, result.get().getId());

	}
	
	
	@Test
	public void findProductByIdNotMatchIdTest() throws JSONException {

		Optional<ProductDetail> result = mockRepository.findById(13860428);
		assertNotEquals(138604281, result.get().getId());

	}
}
