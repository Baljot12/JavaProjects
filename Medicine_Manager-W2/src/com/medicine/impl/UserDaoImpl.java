package com.medicine.impl;

import java.util.ArrayList;

import com.medicine.dao.UserDao;
import com.medicine.model.User;

//Implementation of userdao abstract methods
public class UserDaoImpl implements UserDao {
	// Define Generic Arraylist of type User
	ArrayList<User> userList = new ArrayList<User>();

	@Override
	// User registration
	public User userRegister(User user) {

		// return type of add() method is boolean
		boolean flag = userList.add(user);

		System.out.println(userList);
		if (flag == true)

			return user;
		else
			return null;
	}

	@Override
	// User Login Method Of type boolean
	public boolean userLogin(String loginId, String loginPassword) {
		boolean status = false;
		// int i is used as index of the arrayList
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getLoginId().compareTo(loginId) == 0
					&& userList.get(i).getLoginPassword().compareTo(loginPassword) == 0) {
				status = true;
			} else
				return false;

		}
		return status;

	}
}
