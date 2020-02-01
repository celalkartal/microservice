package com.ahtacode.playermarkt.serviceb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@Slf4j
public class ServiceBApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceBApplication.class, args);
		log.info("ServiceBApplication was launched!");
		
	}

}
