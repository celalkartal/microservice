package com.ahtacode.playermarkt.servicea.service;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ResponseService {

	@HystrixCommand(fallbackMethod = "getDefaultData")
	public String getData() {
		int k=1/0;
		
		return "getData"+k;
	}

	public String getDefaultData() {
		return "getDefaultData";
	}
}
