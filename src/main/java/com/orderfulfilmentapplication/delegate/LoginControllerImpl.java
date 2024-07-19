package com.orderfulfilmentapplication.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orderfulfilmentapplication.controller.LoginController;
import com.orderfulfilmentapplication.security.JwtUtil;
import com.orderfulfilmentapplication.security.LoginRequest;

@RestController
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LoginControllerImpl implements LoginController {
	@Autowired
	OrderDelegate orderDelegate;
	@Autowired
	JwtUtil jwtUtil;

	public LoginRequest login(String username, String pwd) {
		String token = jwtUtil.getJWTToken(username);
		LoginRequest user = new LoginRequest();
		user.setUser(username);
		user.setToken(token);
		return user;

	}

	@Override
	public String login(@RequestBody LoginRequest request) {
		// String token = JwtUtil.generateToken(request.getUserName());
		return "";
	}

}
