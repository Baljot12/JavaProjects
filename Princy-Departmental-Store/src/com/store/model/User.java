//Pojo class for user
package com.store.model;

public class User {
	private String username;
	private String emailId;
	private String password;

	private int supercoins;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSupercoins() {
		return supercoins;
	}

	public void setSupercoins(int supercoins) {
		this.supercoins = supercoins;
	}

	// default constructor to initialize the object of the class
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String emailId, String password, int supercoins) {
		super();
		this.username = username;
		this.emailId = emailId;
		this.password = password;
		this.supercoins = supercoins;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", emailId=" + emailId + ", password=" + password + ", supercoins="
				+ supercoins + "]";
	}

}
