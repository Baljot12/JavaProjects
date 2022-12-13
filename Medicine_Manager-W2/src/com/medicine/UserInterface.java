package com.medicine;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.medicine.exception.CustomException;
import com.medicine.impl.MedicineDaoImpl;
import com.medicine.impl.UserDaoImpl;
import com.medicine.model.Medicine;
import com.medicine.model.User;

//Starting point of the application
public class UserInterface {

	public static void main(String[] args) throws ParseException {

		int choice;
		// create an object of userdaoImpl class
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		// scanner obj to get the input from the console
		Scanner scanner = new Scanner(System.in);

		do {
			int userId;
			String userName, loginId, loginPassword;
			User user = new User();
			System.out.println("1. User..Register...");
			System.out.println("2. User..Login...");
			System.out.println("0. Exit..From..The..Application...");
			System.out.println("Please Enter Your Choice");
			choice = scanner.nextInt();
			switch (choice) {

			case 1:
				/////////////////// User.....Registration...Part.........../////////////////////////////////
				try {
					System.out.println("Enter your userId");
					userId = scanner.nextInt();
					if (userId <= 0)
						// error msg for the user
						// custom exception use 1
						throw new CustomException("Value should not be less than 1");
					else
						System.out.println("Enter your name");
					userName = scanner.next();
					System.out.println("Enter your loginId");
					loginId = scanner.next();
					System.out.println("Enter your loginPassword");
					loginPassword = scanner.next();
					if (loginId.equals(loginPassword))// use custom exception 2
						throw new CustomException("login Id and password should not be same");
					else
						user = new User(userId, userName, loginId, loginPassword);
					User regUser = userDaoImpl.userRegister(user);
					if (regUser == null) {
						System.out.println("You are not registered");
					} else
						System.out.println("Successfully registered User" + ":" + regUser.getUserName());
				} catch (CustomException e) {
					System.out.println(e);
				}

				break;

			case 2:
				/////////////////// User.....Login...Part...........////////////////////////////////////////
				System.out.println("Enter your loginId");
				loginId = scanner.next();
				System.out.println("Enter your loginPassword");
				loginPassword = scanner.next();
				// user = new User(loginId,loginPassword);
				boolean loginUser = userDaoImpl.userLogin(loginId, loginPassword);
				if (loginUser == false) {
					System.out.println("User not found,Try Again Please!!!");
					break;
				} else
					System.out.println("Welcome!!");

				///////// medicine operations part/////////////////////////////////////////////
				do {
					int medId;
					String medName, medQuantity, disease;
					Date dateOfManufacturing, dateOfExpiry;
					MedicineDaoImpl medDaoImpl = new MedicineDaoImpl();
					System.out.println("****Medicine Management System***");
					System.out.println("1.Add a medicine");
					System.out.println("2.Search a medicine");
					System.out.println("3.List all the medicine");
					System.out.println("4.Update existing details of the medicine");
					System.out.println("5.Delete a medicine");
					System.out.println("0.Exit");
					System.out.println("Enter your choice");
					choice = scanner.nextInt();

					switch (choice) {

					case 1:
						try {
							System.out.println("Enter the medicineId ");
							medId = scanner.nextInt();
							if (medId < 0)
								// Use Custom Exception
								throw new CustomException("Medicine id < 0 is not allowed..");
							System.out.println("Enter the name of the medicine");
							medName = scanner.next();
							System.out.println("Enter the quantity the medicine");
							medQuantity = scanner.next();
							System.out.println("Enter the date of Manufacturing of medicine");
							String dateOfManufacturing1 = scanner.next();
							// convert String dateOfManufacturing1--> Date dateOfManufacturing .
							dateOfManufacturing = new SimpleDateFormat("dd-mm-yyyy").parse(dateOfManufacturing1);
							System.out.println("Enter the date of Expiry of medicine");
							String dateOfExpiry1 = scanner.next();
							// convert String dateOfExpiry1 --> Date dateOfExpiry.
							dateOfExpiry = new SimpleDateFormat("dd-mm-yyyy").parse(dateOfExpiry1);
							System.out.println("Enter the name of the disease");
							disease = scanner.next();
							Medicine medicine = new Medicine(medId, medName, dateOfManufacturing, dateOfExpiry,
									medQuantity, disease);
							Medicine addMed = medDaoImpl.addMedicine(medicine);
							if (addMed == null) {
								System.out.println("Medicine not added!!");
							} else
								System.out.println("Successfully added medicine" + ":" + addMed.getMedName());
						}
						// catch block for the custom exception
						catch (CustomException e) {
							System.out.println(e);
						}
						// if user enters the date in wrong format then catch block of parse exception
						// will be execute
						catch (ParseException e) {
							System.out.println(e);
						} catch (InputMismatchException e) {
							System.out.println(e);
						}
						break;
					case 2:
						System.out.println("Enter the name of the disease for which you search the medicine");
						disease = scanner.next();
						List<Medicine> med = medDaoImpl.findMedByDisease(disease);
						if (med == null) {
							System.out.println("Medicine not found!!");
						} else

							System.out.println(med);

						break;
					case 3:
						try {
							System.out.println("Enter the id of the medicine");
							medId = scanner.nextInt();
							medDaoImpl.delMedById(medId);
						} catch (IndexOutOfBoundsException e) {
							System.out.println(e);
						}
						break;
					case 4:
						break;
					case 5:
						break;
					case 0:
						System.out.println("..Exit from the medicine part of the app.....");
						break;
					default:
						System.out.println("Check your input");
						break;
					}
				} while (choice != 0);
				break;
			//////////////// medicine operations  end//////////////////////////////////////////////////////
			case 0:
				System.out.println("..Exit..");
				break;
			default:
				System.out.println("Check your input");
				break;

			}

		} while (choice != 0);
		scanner.close();
	}

}
