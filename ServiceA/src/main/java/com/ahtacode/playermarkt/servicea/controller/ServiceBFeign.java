package com.ahtacode.playermarkt.servicea.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("playermarkt-service-b")
public interface ServiceBFeign {

	@RequestMapping("/service/B2")
	String getServiceb2();//dikkat public kullanma!
}
