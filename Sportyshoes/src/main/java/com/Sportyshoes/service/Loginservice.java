package com.Sportyshoes.service;

import org.springframework.stereotype.Service;

@Service
public class Loginservice {
public boolean validateuser(String user,String password) {
	
	return user.equalsIgnoreCase("jaya") && password.equalsIgnoreCase("123");
}
}