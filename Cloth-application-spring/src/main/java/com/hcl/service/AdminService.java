package com.hcl.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.model.Admin;
import com.hcl.repo.AdminRepo;

@Service
public class AdminService {
@Autowired
private AdminRepo adminrepo;

public Admin login(String email,String password)
{
	Optional<Admin> opadmin = adminrepo.findById(email);
	Admin admin = opadmin.get();//if email is wrong it throws the exception
	if(admin.getPassword().equals(password)==true)
	{
		return admin;
	}
	else
	return null; //user exception case 1
}
}
