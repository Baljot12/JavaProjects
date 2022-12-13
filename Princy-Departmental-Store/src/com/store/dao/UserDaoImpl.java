package com.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.store.model.User;

public class UserDaoImpl implements UserDao {
	private Connection conn;
	private User user = null;
	private PreparedStatement ps = null;
	ResultSet result = null;

	public UserDaoImpl() throws ClassNotFoundException, SQLException {
		conn = DBConnection.getConnection();
	}

	@Override
	public int regUser(User u) throws SQLException {
		String query = "insert into user (userName,emailId,password) values (?,?,?)";
		int n = 0;
		ps = conn.prepareStatement(query);
		// ps.setInt(1,c.getId());
		ps.setString(1, u.getUsername());
		ps.setString(2, u.getEmailId());
		ps.setString(3, u.getPassword());
		n = ps.executeUpdate();
		if (n > 0) {
			String name = u.getUsername();
			String query1 = "select user.supercoins from user where userName ='" + name + "'";
			ps = conn.prepareStatement(query1);
			result = ps.executeQuery();
			while (result.next()) {
				int coins = 0;
				coins = result.getInt(1);
				System.out.println("You will get " + coins + " supercoins as a welcome bonus");
			}
		}
		return n;
	}

	@Override
	public User loginUser(String email, String password) throws SQLException {
		String query = "select * from user where emailId=? and password=?";
		ps = conn.prepareStatement(query);
		ps.setString(1, email);
		ps.setString(2, password);
		result = ps.executeQuery();
		if (result.next()) {
			User dbuser = new User();
			// dbuser.set(result.getInt(1));
			dbuser.setUsername(result.getString(2));
			dbuser.setEmailId(result.getString(3));
			dbuser.setPassword(result.getString(4));
			return dbuser;
		} else
			return null;

	}

}
