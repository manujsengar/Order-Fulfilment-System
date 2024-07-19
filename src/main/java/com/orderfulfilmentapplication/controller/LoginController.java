package com.orderfulfilmentapplication.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.orderfulfilmentapplication.security.LoginRequest;

@RequestMapping("/user")
public interface LoginController {
	@PostMapping(value = "/loginn", produces = MediaType.APPLICATION_JSON_VALUE)
	public String login(@RequestBody LoginRequest request);

	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public LoginRequest login(@RequestParam("user") String username, @RequestParam("password") String pwd);

}
