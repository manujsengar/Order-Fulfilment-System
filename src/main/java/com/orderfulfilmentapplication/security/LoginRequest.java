package com.orderfulfilmentapplication.security;

import org.springframework.data.annotation.Transient;

import lombok.Data;

@Data
public class LoginRequest {

	private String user;
	@Transient
	private String pwd;
	private String token;
}
