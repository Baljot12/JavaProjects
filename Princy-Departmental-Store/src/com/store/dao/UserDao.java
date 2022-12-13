package com.store.dao;

import java.sql.SQLException;

import com.store.model.User;

public interface UserDao {
	int regUser(User u) throws SQLException;// register user

	User loginUser(String username, String password) throws SQLException;// login user

}
