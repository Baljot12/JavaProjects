//To perform the user operations
package com.store.ui;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.store.dao.UserDaoImpl;
import com.store.exception.UserException;
import com.store.model.User;

public class UserEnterInterface {
	Scanner sc = new Scanner(System.in);// Define the scanner object to get the input from console
	private int choice;
	String name, email, pass;
	User u = null;

	public void userScreen() {
		UserDaoImpl userdao = null;
		try {
			userdao = new UserDaoImpl();
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not loaded" + e);
			System.exit(0);
		} catch (SQLException e1) {
			System.out.println("DB Connectivity error :" + e1);
			System.exit(0);
		}
		do {

			System.out.println("1. New customer, then register ");// 1.existing customer
			System.out.println("2. Existing customer, then login ");// 2. new customer
			System.out.println("0. logout");
			System.out.println("Enter the choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				try {
					System.out.println("Enter name :");
					name = sc.next();
					System.out.println("Enter email :");
					email = sc.next();
					System.out.println("Enter password :");
					pass = sc.next();
					// throw user exception for password length
					if (pass.length() < 6)
						throw new UserException("Your password must contains 7 characters atleast");
					u = new User();
					u.setUsername(name);
					u.setEmailId(email);
					u.setPassword(pass);
					int n = userdao.regUser(u);
					if (n == 0) {
						System.out.println("user not inserted");
					} else
						System.out.println(n + " user saved successfully");
				} catch (SQLException e) {
					System.out.println("DB issues" + e);
				} catch (UserException e) {
					System.out.println(e);
				} catch (InputMismatchException e) {
					System.out.println(e);
				}
				break;
			case 2:
				System.out.println("Enter email :");
				email = sc.next();
				System.out.println("Enter password :");
				pass = sc.next();
				try {
					User dbuser = userdao.loginUser(email, pass);
					if (dbuser == null) {
						System.out.println("no user found for emailId :" + email);
						System.out.println("your email id and password is not correct");

					} else {
						System.out.println("Welcome To The Store : " + dbuser.getUsername());
						System.out.println("************************************");
						UserStoreInterface userinterface = new UserStoreInterface();
						userinterface.userMenu();
					}
				} catch (SQLException e) {
					System.out.println("DB issues" + e);
				}
				break;
			case 0:
				System.out.println("*** Bye User ***");
				break;
			default:
				System.out.println("Invalid choice");
				break;

			}

		} while (choice != 0);
	}

}
