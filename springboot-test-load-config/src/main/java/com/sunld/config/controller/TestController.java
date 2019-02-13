package com.sunld.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
public class TestController {
	
	@Value("${spring.application.name: defaultname}")
	private String value;

	@RequestMapping("/index")
	public String getIndex() {
		return "getIndex" + value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
