package com.target.retail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Component
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("My Retail API")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.target.retail.controller"))
                .paths(PathSelectors.ant("/products/*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "My Retail API",
                "My Retail",
                "1.0.0-Release",
                "http://myretail.com/documents/UserAgreement/UserAgreement.html",
                new Contact("support@myretail.com", "www.myretail.com", "support@myretail.com"),
                "MyRetail License", "http://myretail.com/documents/CopyrightPolicy/CopyrightPolicy.html", Collections.emptyList());
    }
}
