package com.ahtacode.playermarkt.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/user")
public class UserContoller {
	@GetMapping("/me")
	public Principal user(Principal principal) {
		return principal;
	}

}