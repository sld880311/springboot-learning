package com.sunld.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@ServletComponentScan
public class SpringbootProducerWithEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootProducerWithEurekaApplication.class, args);
	}

}

