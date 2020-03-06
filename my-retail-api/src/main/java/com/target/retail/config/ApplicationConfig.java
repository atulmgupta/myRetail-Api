package com.target.retail.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.web.client.RestTemplate;

import com.target.retail.redis.CustomKeyGenerator;

@EnableCaching
@ComponentScan(basePackages = "com.target.*")
@Configuration
public class ApplicationConfig {
	private static final Logger log = LoggerFactory.getLogger(ApplicationConfig.class);

	@Value("${spring.redis.host:localhost}")
	private String host;
	@Value("${spring.redis.port:6379}")
	private String port;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
		log.info("Creating redis connection with server {} on port {}  ", host, port);
		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(host, Integer.valueOf(port));
		return new JedisConnectionFactory(config);
	}

	@Bean
	public RedisConnectionFactory jedisConnectionFactory() {
		return redisConnectionFactory();
	}

	@Bean("customKeyGenerator")
	public KeyGenerator keyGenerator() {
		return new CustomKeyGenerator();
	}
}
