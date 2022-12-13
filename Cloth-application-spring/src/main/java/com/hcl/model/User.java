package com.hcl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(unique = true,nullable=false)
	private String email;
	@Column(nullable = false)
	private String password;
	private String city;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", city=" + city
				+ "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, String email, String password, String city) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
	}
	public User(int id) {
		super();
		this.id = id;
	}
	

}
