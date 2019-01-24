package com.sunld.producer.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sunld.producer.client.ProducerControllerApi;

@RestController
public class ProducerController implements ProducerControllerApi{

	@Override
//	@RequestMapping(value = "/producer/getProducerList", method = RequestMethod.GET)
	public String getProducerList() {
		return ProducerController.class.getName() + " getProducerList ";
	}
	
	
}
