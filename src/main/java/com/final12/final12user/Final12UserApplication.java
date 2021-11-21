package com.final12.final12user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Final12UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(Final12UserApplication.class, args);
	}
}
