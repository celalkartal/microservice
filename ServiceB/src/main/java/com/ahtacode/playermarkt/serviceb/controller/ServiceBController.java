package com.ahtacode.playermarkt.serviceb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/service")
@Slf4j // lombok plugin jar should be added to Eclipse IDE .exe location 
public class ServiceBController {

	@Autowired
	ServiceAFeign serviceAFeign;

	@GetMapping("/B")
	public String getServiceBData() {
		String serviceAData = serviceAFeign.getServiceAData();
		serviceAData += " was used in Service B";
		log.info("ServiceB called ServiceA");
		return serviceAData;
	}

	@GetMapping("/B2")
	public String getServiceBData2() {
		log.info("ServiceB2 launched");
		return "ServiceB2 Data";
	}
}
