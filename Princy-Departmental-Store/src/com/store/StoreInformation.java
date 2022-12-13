package com.store;

import java.util.Scanner;

import com.store.ui.AdminInterface;
import com.store.ui.UserEnterInterface;

public class StoreInformation {

	public static void main(String[] args) {
		int choice = 0;
		Scanner sc = new Scanner(System.in);

		UserEnterInterface userInterface = new UserEnterInterface();
		AdminInterface adminInterface = new AdminInterface();

		do {
			System.out.println("1. Admin");// option one for admin
			System.out.println("2. User");// option 2 for user
			System.out.println("0. Exit");// to exit
			System.out.println("Enter your choice :");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("***Welcome Admin....");
				adminInterface.adminScreen();
				break;
			case 2:
				System.out.println("***Welcome User.....");
				userInterface.userScreen();
				break;
			case 0:
				System.out.println("Exit");
				break;
			default:
				System.out.println("Int value from 0,1,2 are allowed");
				break;
			}

		} while (choice != 0);

	}
}
//prin123@gmail.com-->admin email
//pr12#@123 -->admin password

// gur123@gmail.com
// gur123
