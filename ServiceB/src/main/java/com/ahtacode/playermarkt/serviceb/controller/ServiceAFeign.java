package com.ahtacode.playermarkt.serviceb.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("playermarkt-service-a")
public interface ServiceAFeign {

	@RequestMapping("/service/A")
	String getServiceAData();
	@RequestMapping("/service/A2")
	String getServiceAData2();
}
