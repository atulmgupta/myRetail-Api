package com.target.retail.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;
import java.util.UUID;

public class CustomKeyGenerator implements KeyGenerator {
	private static final Logger log = LoggerFactory.getLogger(CustomKeyGenerator.class);

	/**
	 * Generate a key for the given method and its parameters.
	 *
	 * @param target the target instance
	 * @param method the method being called
	 * @param params the method parameters (with any var-args expanded)
	 * @return a generated key
	 */
	@Override
	public Object generate(Object target, Method method, Object... params) {
		try {
			for (Object param : params) {
				if (param instanceof Integer) {

					log.info("Redis Key {}", param);
					if (param != null) {
						return param;
					}

				}
			}
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}

		return UUID.randomUUID().toString();
	}
}
