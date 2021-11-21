package com.practise.loginpage.logindemo.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
	
	//hardcode authentication for "namratha":"namratha"
	public boolean validateUser(String user, String password) {
		return (user.equalsIgnoreCase("namratha") && password.equals("namratha"));
	}

}
