package com.sunld.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunld.producer.client.ProducerControllerApi;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
	
//	@Autowired
//	public ProducerApi producerApi;
	
	@Autowired
	public ProducerControllerApi producerControllerApi;
	
	@RequestMapping("/getConsumerList")
	public String getConsumerList() {
		return producerControllerApi.getProducerList() + "getConsumerList";
	}

}
