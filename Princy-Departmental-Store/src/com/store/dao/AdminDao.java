//To define the function for admin login.
package com.store.dao;

public class AdminDao {
	// Array to store the credentials of admin Princy
	private String admin[] = { "Princy", "prin123@gmail.com", "pr12#@123" };

//login method to validate the credentials of admin
	public boolean adminLogin(String emailId, String password)

	{
		if (emailId.equals(admin[1]) && password.equals(admin[2]))
			return true;
		else
			return false;

	}

}
