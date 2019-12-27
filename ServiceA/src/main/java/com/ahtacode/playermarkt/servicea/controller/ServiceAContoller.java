package com.ahtacode.playermarkt.servicea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class ServiceAContoller {
	
	@Autowired
	private Environment env;
	
	@Autowired 
	ServiceBFeign serviceBFeign;
	
	@GetMapping("/A")
	public String getServicea() {
		return "ServiceA Data " +  env.getProperty("server.port");
	}
	
	@GetMapping("/A2")
	public String getServicea2() {
		return "ServiceA2 Data";
	}

	@GetMapping("/A3")
	public String getServicea3() {
		String serviceB2Data=serviceBFeign.getServiceb2();
		serviceB2Data+=" was used in ServiceA3 Data";
		return serviceB2Data;
	}
}
