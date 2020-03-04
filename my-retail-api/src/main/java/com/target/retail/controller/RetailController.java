package com.target.retail.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.target.retail.entity.ProductDetail;
import com.target.retail.service.RetailService;

import io.swagger.annotations.Api;

@Api(value = "Retail", produces = MediaType.APPLICATION_JSON_VALUE, tags = { "retail" }, description = "Retail Api")
@RestController
@RequestMapping(value = "/products/")
public class RetailController {
	private static final Logger log = LoggerFactory.getLogger(RetailController.class);

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	RetailService retailService;

	public RetailController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@GetMapping(value = "/{id}")
	public ProductDetail getProductDetails(@PathVariable("id") Integer id) {
		log.info("Retail Service is up and running");
		return null;
	}

	@PutMapping(value = "/{id}")
	public ProductDetail putProductDetails(@PathVariable("id") Integer id, @RequestBody ProductDetail productDetail) {
		log.info("Retail Service is up and running");
		return null;
	}

}
