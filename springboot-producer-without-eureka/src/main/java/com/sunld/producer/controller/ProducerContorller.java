package com.sunld.producer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerContorller {

	@RequestMapping(value = "/producer/getProducerList", method = RequestMethod.GET)
	public String getProducerList() {
		return ProducerContorller.class.getName() + " getProducerList ";
	}
}
