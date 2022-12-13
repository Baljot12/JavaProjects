package com.store.ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.store.dao.ProductDaoImpl;
import com.store.dao.UserDaoImpl;
import com.store.model.Item;
import com.store.model.ShoppingCart;
import com.store.model.User;

public class UserStoreInterface {
	Scanner sc = new Scanner(System.in);// Define the scanner object to get the input from console
	private int choice;
	private List<Item> itemList = null;
	private String category = null;
	private Item item = null;
	private ShoppingCart[] itemArray = null;
	double totalBill = 0;
	private float bill = 0;

	public void userMenu() {
		ProductDaoImpl productdao = null;
		try {
			productdao = new ProductDaoImpl();
		} catch (ClassNotFoundException c) {
			System.out.println("Driver not loaded " + c);
			System.exit(0);
		} catch (SQLException e) {
			System.out.println("Sql issue" + e);
			System.exit(0);
		}
		// display all the products to the user when it login successfully

		try {
			itemList = productdao.getAllProducts();
			if (itemList.isEmpty())
				System.out.println("No product to show");
			else
				System.out.println("Id\tProduct Name\tQuantity\tSelling Price\tCategory");
			System.out.println("------ ~~~~~~~~~ ------ ~~~~~~ ------- ~~~~~~~~ ---------- ~~~~~~ ----------");
			for (Item get : itemList) {
				//
				System.out.println(get.getProductid() + "\t" + get.getProductName() + "\t\t"
						+ get.getAvailableQuantity() + "\t\t" + get.getSellingPrice() + "\t\t" + get.getcategory());
			}
			System.out.println("------ ~~~~~~~~~ ------ ~~~~~~ ------- ~~~~~~~~ ---------- ~~~~~~~~ ----------");
		} catch (SQLException e) {
			System.out.println(e);
		}

		do {
			System.out.println("1. Filter products based on category");
			System.out.println("2. Filter products based on price(low to high)");
			System.out.println("3. Purchase products :add more than one"
					+ "");
			System.out.println("4. Show the Bill");
			System.out.println("0. logout");
			System.out.println("enter your choice");
			choice = sc.nextInt();
			switch (choice) {
			// Filter product based on category
			case 1:
				System.out.println("Enter the category of the product :");
				category = sc.next();
				itemList = new ArrayList<>();
				try {
					itemList = productdao.getProductsByCat(category);
					if (itemList.isEmpty())
						System.out.println("No product available for " + category + " category");
					else

					{
						System.out.println("------------------------------------------------------------------------");
						System.out.println("              " + category + " Items         ");
						System.out.println("------------------------------------------------------------------------");
						for (Item get : itemList) {
							//
							System.out.println("Id :" + get.getProductid() + "\t" + "Name :" + get.getProductName()
									+ "\t" + "Quantity :" + get.getAvailableQuantity() + "\t" + "SellingPrice :"
									+ get.getSellingPrice());
						}
						System.out.println("------------------------------------------------------------------------");
					}
				} catch (SQLException e) {
					System.out.println(e);
				}
				break;
			// Filter product based on price(low to high)
			case 2:
				itemList = new ArrayList<>();
				try {
					itemList = productdao.getProductsinAscOder();
					if (itemList.isEmpty())
						System.out.println("Please Try Again");
					else

					{
						System.out.println("---------------------------------------------------------------");
						System.out.println("                   Items From Price Low To High               ");
						System.out.println("---------------------------------------------------------------");
						for (Item get : itemList) {
							//
							System.out.println("Id :" + get.getProductid() + "\t" + "Name :" + get.getProductName()
									+ "\t" + "Quantity :" + get.getAvailableQuantity() + "\t" + "SellingPrice :"
									+ get.getSellingPrice() + "\t" + "Category :" + get.getcategory());
						}
						System.out.println("--------------------------------------------------------------------");
					}
				} catch (SQLException e) {
					System.out.println(e);
				}
				break;

			// Purchase the products
			case 3:
				int id = 0;
				int num = 0;
				try {

					System.out.println("Remember u are allowed to purchase 5 items at a time");
					itemArray = new ShoppingCart[5];
					// store the purchased items of the user
					int counter = 0;
					for (int i = 0; i < itemArray.length; i++) {
						itemList = productdao.getAllProducts();// First display all the products in front of user so
																// that user select the products to buy
						if (itemList.isEmpty())
							System.out.println("No product to show");
						else
							System.out.println("Id\tProduct Name\tQuantity\tSelling Price\tCategory");
						System.out.println(
								"------ ~~~~~~~~~ ------ ~~~~~~ ------- ~~~~~~~~ ---------- ~~~~~~ ----------");
						for (Item get : itemList) {
							//
							System.out.println(get.getProductid() + "\t" + get.getProductName() + "\t\t"
									+ get.getAvailableQuantity() + "\t\t" + get.getSellingPrice() + "\t\t"
									+ get.getcategory());
						}
						System.out.println(
								"------ ~~~~~~~~~ ------ ~~~~~~ ------- ~~~~~~~~ ---------- ~~~~~~~~ ----------");
						System.out.println("Enter the id of the product that you want to purchase :");
						id = sc.nextInt();

						item = new Item();
						item = productdao.getTheProductById(id);// Return the product if id match with product id of the
																// product
						if (item == null) {
							System.out.println("Please check your id ");
							break;
						}
						System.out.println("Enter the no. of product you want to purchase :");
						num = sc.nextInt();
						float price = item.getSellingPrice();
						bill = num * price;// calculate the bill for one selected item.
						ShoppingCart cart = new ShoppingCart();
						cart.setItem(item);
						cart.setNum(num);
						cart.setBill(bill);
						itemArray[i] = cart;
						System.out.println("id: " + itemArray[i].getItem().getProductid() + " num :"
								+ itemArray[i].getNum() + " product name :" + itemArray[i].getItem().getProductName()
								+ " " + "bill :" + itemArray[i].getBill());
						counter++;
						System.out.println("Do you want to purchase more items : yes/no");
						String get = sc.next();
						if (get.equalsIgnoreCase("yes"))
							continue;
						else {
							System.out.println("The Details of the " + counter + " items purchased by the user ");
							System.out.println("====== ========== ========== ======== ===== ===== ==========");
							for (int p = 0; p < counter; p++) {
								System.out.println("id: " + itemArray[p].getItem().getProductid() + "num :"
										+ itemArray[p].getNum() + " product name :"
										+ itemArray[p].getItem().getProductName() + " bill :" + itemArray[p].getBill());

								double totalBillOfEach[] = new double[itemArray.length];
								// for(int t = 0 ;t <itemArray.length;t++)
								totalBillOfEach[p] = itemArray[p].getBill();// store the bill of each item of the user
								totalBill += totalBillOfEach[p];// Total Bill
							}
							System.out.println("====== ========== ========== ======== ===== ===== ==========");
							break;
						}
					}
				} catch (SQLException e) {
					System.out.println(e);
				} catch (InputMismatchException e1) {
					System.out.println(e1);
				} catch (NullPointerException e2) {
					System.out.println(e2);
				}
				break;
			// Show the Total Bill
			case 4:
				System.out.println("Total Bill :" + totalBill);
				break;
			case 0:
				System.out.println("..Exit..");
				break;
			default:
				System.out.println("invalid choice");
				break;
			}

		} while (choice != 0);
	}
}
