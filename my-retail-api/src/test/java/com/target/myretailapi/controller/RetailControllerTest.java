package com.target.myretailapi.controller;

import org.aspectj.lang.annotation.Before;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.target.retail.controller.RetailController;

@WebMvcTest(value = RetailController.class)
public class RetailControllerTest {

	private static final Logger log = LoggerFactory.getLogger(RetailControllerTest.class);

	@Autowired
	MockMvc mockMvc;


	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

}
