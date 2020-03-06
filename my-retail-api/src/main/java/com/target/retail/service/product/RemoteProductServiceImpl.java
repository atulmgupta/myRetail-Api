package com.target.retail.service.product;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.target.retail.exception.ProductNotFoundException;
import com.target.retail.exception.RetailException;
import com.target.retail.utils.JsonUtils;

/**
 * 
 * @author atulgupta
 *
 */
@Service
public class RemoteProductServiceImpl implements RemoteProductService {

	private static final Logger log = LoggerFactory.getLogger(RemoteProductServiceImpl.class);

	@Autowired
	RestTemplate restTemplate;

	@Value("${product-api:https://redsky.target.com}")
	private String product_api_url;

	private String product_URI = "/v2/pdp/tcin/";

	@Override
	public String getProductNameById(Integer productId) throws RetailException, ProductNotFoundException {
		String productName = null;
		try {

			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(product_api_url + product_URI + productId)
					.queryParam("excludes",
							"taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics");

			String jsonResponse = restTemplate.getForObject(builder.build().encode().toUri(), String.class);

			if (jsonResponse != null) {
				try {
					productName = JsonUtils.getPropertyValue(jsonResponse, "product.item.product_description.title");	
				} catch (NoSuchElementException e) {
					throw new ProductNotFoundException(HttpStatus.NOT_FOUND.value(), "Product not Found");
				}
								
			}else {
				throw new ProductNotFoundException(HttpStatus.NOT_FOUND.value(), "Product not Found");
			}
		} catch (RestClientException e) {
			log.debug("Product API unavailable  :" + product_api_url + product_URI + productId);
			throw new RetailException(HttpStatus.NOT_FOUND.value(), "Product Remote API unavailable");
		}
		return productName;
	}

}
