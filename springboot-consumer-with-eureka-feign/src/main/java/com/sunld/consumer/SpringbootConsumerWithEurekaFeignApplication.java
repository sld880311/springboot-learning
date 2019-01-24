package com.sunld.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@ServletComponentScan
@ComponentScan(value = "com.sunld")
public class SpringbootConsumerWithEurekaFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootConsumerWithEurekaFeignApplication.class, args);
	}

}

