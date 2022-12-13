package com.medicine.dao;

import com.medicine.model.User;

public interface UserDao {
	public User userRegister(User user);

	public boolean userLogin(String loginId, String loginPassword);

}
