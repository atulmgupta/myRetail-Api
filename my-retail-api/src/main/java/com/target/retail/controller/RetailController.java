package com.target.retail.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.SpanName;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.target.retail.entity.product.ProductDetail;
import com.target.retail.service.retail.RetailService;

import io.swagger.annotations.Api;

@Api(value = "Retail", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"retail"}, description = "Retail Api")
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
    @SpanName("getProductDetails")
    @GetMapping(value = "/{id}")
    public ProductDetail getProductDetails(@PathVariable("id") Integer id) throws JsonProcessingException {
    	ProductDetail productDetail = new ProductDetail();
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(productDetail));
        log.info("Retail Service is up and running");
        return null;
    }
    @SpanName("putProductDetails")
    @PutMapping(value = "/{id}")
    public ProductDetail putProductDetails(@PathVariable("id") Integer id, @RequestBody ProductDetail productDetail) {
        log.info("Retail Service is up and running");
        return null;
    }
    @SpanName("addProductDetails")
    @PostMapping(value = "/add")
    public boolean addProductDetails(@RequestBody ProductDetail productDetail) {
        log.info("Retail Service is up and running");
        return retailService.addProduct(productDetail);
    }

}
