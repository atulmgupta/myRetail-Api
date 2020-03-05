package com.target.retail.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.target.retail.service.retail.RetailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

	@SpanName("getProductDetails")
	@ApiOperation("Get product by id")
	@GetMapping(value = "/{id}")
	public ProductDetail getProductDetails(@PathVariable("id") Integer id) throws JsonProcessingException {
		ProductDetail productDetail = new ProductDetail();
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(productDetail));
		log.info("Retail Service is up and running");
		log.info(mapper.writeValueAsString(new PriceDetail()));
		
		ProductDetail detail = new ProductDetail();
		detail.setId(150);
		detail.setName("Demo");
	
		return detail;
	}

	@SpanName("putProductDetails")
	@ApiOperation("Update Product Details")
	@PutMapping(value = "/{id}")
	public ProductDetail putProductDetails(@PathVariable("id") Integer id, @RequestBody ProductDetail productDetail) {
		log.info("Retail Service is up and running");
		
		return null;
	}

	@SpanName("addProductDetails")
	@ApiOperation("Add Product")
	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public boolean addProductDetails(@RequestBody ProductDetail productDetail) {
		log.info("Retail Service is up and running");
		return retailService.addProduct(productDetail);
	}

	@SpanName("addPriceDetails")
	@PostMapping(value = "/addprice", consumes = "application/json", produces = "application/json")
	public PriceDetail addPriceDetails(@RequestBody PriceDetail priceDetail) {
		log.info("Retail Service is up and running");
		return retailService.addPrice(priceDetail);
	}
}
