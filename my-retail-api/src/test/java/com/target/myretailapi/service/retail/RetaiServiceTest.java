package com.target.myretailapi.service.retail;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.target.retail.entity.product.CurrencyCode;
import com.target.retail.entity.product.PriceDetail;
import com.target.retail.entity.product.ProductDetail;
import com.target.retail.repository.ProductRepository;
import com.target.retail.service.retail.RetailService;

@RunWith(SpringRunner.class)
@TestPropertySource(properties = { "product-api=http://redsky.target.com" })
public class RetaiServiceTest {
	@Mock
	RetailService retailService;
	@Mock
	ProductRepository productRepository;
	@Value("${product-api}")
	String product_api_url;

	@Test
	public void testValueSetup() {
		
		assertTrue("http://redsky.target.com".equals(product_api_url));
	}

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getProductByIdTest() throws Exception {

		PriceDetail priceDetail = new PriceDetail(new BigDecimal(15.74), CurrencyCode.USD);
		ProductDetail prodcutDetail = new ProductDetail(13860428, "test Product", priceDetail);
		Mockito.when(productRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(prodcutDetail));
		assertEquals(13860428, prodcutDetail.getId());

	}
}
