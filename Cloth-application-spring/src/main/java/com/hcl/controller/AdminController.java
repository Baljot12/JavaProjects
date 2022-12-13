package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.Admin;
import com.hcl.model.Cloth;
import com.hcl.service.AdminService;
import com.hcl.service.ClothService;

@RestController
//@RequestMapping("/admin")
public class AdminController {
private Admin admin;

	@Autowired
	AdminService adService;
	//@Autowired
	
	
	@PostMapping("/admin/login")
	public Admin login(@RequestBody Admin ad)
	{
	admin =	adService.login(ad.getEmail(),ad.getPassword());
	return admin;
	}
	
	
	//@PostMapping("/deletecloth/{id}")
	//bal423@gmail.com
}
