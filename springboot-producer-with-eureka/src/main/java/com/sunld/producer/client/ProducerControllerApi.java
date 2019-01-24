package com.sunld.producer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "springboot-producer-with-eureka")
@Service("producerControllerApi")
public interface ProducerControllerApi {
	
	@RequestMapping(value = "/producer/getProducerList", method = RequestMethod.GET)
	public String getProducerList();
}