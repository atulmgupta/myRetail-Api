package com.target.retail.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
@Api(value = "Retail",produces = MediaType.APPLICATION_JSON_VALUE,tags = {"retail"},description = "Retail Api")
@RestController
@RequestMapping(value = "/retail/")
public class RetailController {
    private static final Logger log = LoggerFactory.getLogger(RetailController.class);

    @Autowired
    RestTemplate restTemplate;

    public RetailController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String test() {
        log.info("Retail Service is up and running");
        return "Retail Service is up and running" + new Date();
    }

}
