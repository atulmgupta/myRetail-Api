package com.target.retail.service.product;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * 
 * @author atulgupta
 *
 */
public class RemoteProductServiceImpl implements RemoteProductService {

	private static final Logger log = LoggerFactory.getLogger(RemoteProductServiceImpl.class);

	@Autowired
	RestTemplate restTemplate;

	@Value("${product-api}")
	private String product_api_url;

	private String product_URI = "/v2/pdp/tcin/";

	@Override
	public String getProductNameById(Integer productId) {
		String productName = null;
		try {

			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(product_api_url + product_URI + productId)
					.queryParam("excludes",
							"taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics");

			String jsonResponse = restTemplate.getForObject(builder.build().encode().toUri(), String.class);

			if (jsonResponse != null) {
				JSONObject productDescription = JSONObject.get.getJSONObject("product").getJSONObject("item").getJSONObject("product_description");
				productName = productDescription.getString("title");
			}
		} catch (RestClientException e) {
			log.debug("Product API unavailable  :" + product_api_url + product_URI + productId);
//			throw new MyRetailException(HttpStatus.NOT_FOUND.value(), "Product Remote API unavailable");
		}
		return productName;
	}

}
