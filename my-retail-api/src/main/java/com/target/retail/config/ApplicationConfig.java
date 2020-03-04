package com.target.retail.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@ComponentScan(basePackages = "com.target.*")
@Configuration
public class ApplicationConfig {
    private static final Logger log = LoggerFactory.getLogger( ApplicationConfig.class );

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
