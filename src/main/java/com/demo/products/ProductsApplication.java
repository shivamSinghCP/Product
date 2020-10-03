package com.demo.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableAutoConfiguration
@SpringBootApplication
@EnableEurekaClient
public class ProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);
	}

}
