package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.User;
import com.hcl.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService uservice;
	@PostMapping("/user/register")
	public User regUser(@RequestBody User u)
	{
		User saved = uservice.saveUser(u);
		return saved;
		
	}
	
	
	@PostMapping("/user/login")
	public User loginUser(@RequestBody User u)
	{
		User login = uservice.login(u.getEmail(), u.getPassword());
		return login;
	}

}
