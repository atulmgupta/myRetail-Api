package com.target.myretailapi.service.retail;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.target.retail.entity.product.PriceDetail;
import com.target.retail.entity.product.ProductDetail;
import com.target.retail.service.retail.RetailService;

@RunWith(SpringRunner.class)
@TestPropertySource(properties = { "product-api=http://redsky.target.com" })
public class RetaiServiceTest {
	@Mock
	RetailService retailService;

	@Value("${product-api}")
	String product_api_url;

	@Test
	public void testValueSetup() {
		assertEquals("http://redsky.target.com", product_api_url);
	}

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getProductByIdTest() throws Exception{

		//Objects created for the actual Mock
		PriceDetail currentPriceMock = new PriceDetail(13.49,"USD");
		ProductDetail productMock = new ProductDetail("13860428",currentPriceMock) ;
		Mockito.when(productRepository.findProductByproductId(Mockito.anyString())).thenReturn(productMock);
		assertEquals("13860428",productMock.getProductId());
	}
}
