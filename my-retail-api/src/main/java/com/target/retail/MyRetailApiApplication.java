package com.target.retail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class MyRetailApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRetailApiApplication.class, args);
	}

}
