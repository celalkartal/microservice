package com.ahtacode.playermarkt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = { "com.ahtacode.playermarkt" })
@EnableSwagger2
@EnableOAuth2Sso
public class PlayermarktApplication{

	public static void main(String[] args) {
		SpringApplication.run(PlayermarktApplication.class, args);
	}

}
