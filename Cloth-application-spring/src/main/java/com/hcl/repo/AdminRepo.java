package com.hcl.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, String> {
	/*
	 * insert admin ,delete admin ,list of all the admin ,search the admin, update the
	 * admin 
	 */
}
