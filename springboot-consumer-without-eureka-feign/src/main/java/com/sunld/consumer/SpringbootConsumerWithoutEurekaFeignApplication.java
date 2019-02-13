package com.sunld.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringbootConsumerWithoutEurekaFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootConsumerWithoutEurekaFeignApplication.class, args);
	}

}

