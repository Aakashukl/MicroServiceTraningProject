package com.microservices.bookService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BookService {

	public static void main(String[] args) {
		SpringApplication.run(BookService.class, args);
	}

}
