package com.sunld.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "producerApi", url = "http://localhost:10012")
public interface ProducerApi {
	@RequestMapping(value = "/producer/getProducerList")
	public String getProducerList();
}
