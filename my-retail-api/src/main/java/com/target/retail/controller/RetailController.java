package com.target.retail.controller;

import com.target.retail.exception.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.cloud.sleuth.SpanName;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.target.retail.entity.product.PriceDetail;
import com.target.retail.entity.product.ProductDetail;
import com.target.retail.exception.RetailException;
import com.target.retail.service.retail.RetailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * @author atulgupta
 *
 */
@CrossOrigin
@Api(value = "Retail", produces = MediaType.APPLICATION_JSON_VALUE, tags = { "retail" }, description = "Retail Api")
@RestController
@RequestMapping(value = "/products/")
public class RetailController {
	private static final Logger log = LoggerFactory.getLogger(RetailController.class);

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	RetailService retailService;

	@Autowired
	ObjectMapper mapper;

	public RetailController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Cacheable(value = "product", keyGenerator = "customKeyGenerator")
	@SpanName("getProductDetails")
	@ApiOperation("Get product by id")
	@GetMapping(value = "/{id}")
	public ProductDetail getProductDetails(@PathVariable("id") Integer id)
			throws JsonProcessingException, RetailException, ProductNotFoundException {
		
		log.info("Retail Service is up and running");

		ProductDetail detail = retailService.getProductDetailById(id);
		return detail;
	}

	@Caching(evict = { @CacheEvict(value = "product", keyGenerator = "customKeyGenerator") }, put = {
			@CachePut(value = "product", key = "customKeyGenerator") })
	@SpanName("putProductDetails")
	@ApiOperation("Update Product Details")
	@PutMapping(value = "/{id}")
	public ProductDetail putProductDetails(@PathVariable("id") String id, @RequestBody ProductDetail productDetail) {
		log.info("Retail Service is up and running");

		return null;
	}

	@ApiIgnore
	@SpanName("addProductDetails")
	@ApiOperation("Add Product")
	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public boolean addProductDetails(@RequestBody ProductDetail productDetail) {
		log.info("Retail Service is up and running");
		return retailService.addProduct(productDetail);
	}

//	@ApiIgnore
	@SpanName("addprice")
	@PostMapping(value = "/addprice", consumes = "application/json", produces = "application/json")
	public PriceDetail addPriceDetails(@RequestBody PriceDetail priceDetail) {
		log.info("Retail Service is up and running");
		return retailService.addPrice(priceDetail);
	}
}
