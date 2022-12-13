package com.medicine.model;

//user class
public class User {
	private int userId;
	private String userName;
	private String loginId;
	private String loginPassword;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	// to construct an object of a class
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	// use param constructor for registration purpose
	public User(int userId, String userName, String loginId, String loginPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.loginId = loginId;
		this.loginPassword = loginPassword;
	}

	//// use param constructor for login purpose
	public User(String loginId, String loginPassword) {
		super();
		this.loginId = loginId;
		this.loginPassword = loginPassword;

	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", loginId=" + loginId + ", loginPassword="
				+ loginPassword + "]";
	}

}
