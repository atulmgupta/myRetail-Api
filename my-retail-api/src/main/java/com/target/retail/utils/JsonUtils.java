package com.target.retail.utils;

import java.util.Map;
import java.util.NoSuchElementException;

import com.github.wnameless.json.flattener.JsonFlattener;

/**
 * 
 * @author atulgupta
 *
 */
public class JsonUtils {
	@SuppressWarnings("unused")
	public static String getPropertyValue(String jsonPayload, String property) throws NoSuchElementException {
		try {
			String flattenResponse = JsonFlattener.flatten(jsonPayload);
			Map<String, Object> flatMap = JsonFlattener.flattenAsMap(jsonPayload);
			if (flatMap.containsKey(property)) {
				return String.valueOf(flatMap.get(property));
			}
			throw new NoSuchElementException(property + " is not found in payload");
		} catch (Exception e) {
			throw new NoSuchElementException(property + " is not found in payload");
		}

	}
}
