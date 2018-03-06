package com.sunld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationdemoApplication {

	public static void main(String[] args) {
		
//		SpringApplication.run(ApplicationdemoApplication.class, args);
		
		/**
		 * 禁用命令行输入参数
		 */
		
		SpringApplication springApplication = new SpringApplication(ApplicationdemoApplication.class);
		springApplication.setAddCommandLineProperties(false);
		springApplication.run(args);
	}
}
