package com.target.myretailapi.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.target.retail.utils.JsonUtils;

/**
 * 
 * @author atulgupta
 *
 */
@RunWith(SpringRunner.class)
public class JsonUtilsTest {

	@Test
	public void propertyFoundTest() {
		String jsonPayload = "{\"id\":13860428,\"name\":\"The Big Lebowski (Blu-ray)\",\"current_price\":{\"value\":154.25,\"currency_code\":\"USD\"}}";
		String result = JsonUtils.getPropertyValue(jsonPayload, "current_price.value");
		assertEquals("154.25", result);
	}

	@Test(expected = NoSuchElementException.class)
	public void propertyNotFoundTest() {
		String jsonPayload = "{\"id\":13860428,\"name\":\"The Big Lebowski (Blu-ray)\",\"current_price\":{\"value\":154.25,\"currency_code\":\"USD\"}}";
		JsonUtils.getPropertyValue(jsonPayload, "current_price.id");

	}
}
