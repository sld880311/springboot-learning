package com.sunld.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunld.consumer.client.ProducerApi;


@RestController
@RequestMapping("/consumer")
public class ConsumerController {
	@Autowired
	public ProducerApi producerApi;
	
	
	@RequestMapping("/getConsumerList")
	public String getConsumerList() {
		return producerApi.getProducerList() + "getConsumerList";
	}
}
