package com.certiorem.librarymicroservicesproject.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.certiorem.librarymicroservicesproject")
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
public class BookMicroServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookMicroServiceApplication.class, args);
	}
}
