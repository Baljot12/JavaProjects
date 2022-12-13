//To perform  the admin functions on departmental store
package com.store.ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.store.dao.AdminDao;
import com.store.dao.ProductDaoImpl;
import com.store.exception.UserException;
import com.store.model.Item;
import com.store.model.Product;

public class AdminInterface {
	private AdminDao admindao = new AdminDao();// define the object of AdminDao Class
	Scanner sc = new Scanner(System.in);// Define the scanner object to get the input from console
	// Required global variables
	private int choice;
	private String email, password;
	private int productid;
	private String productName;
	private float availableQuantity;
	private String category;
	private float buyingPrice;

//admin login
	public void adminScreen() {
		try {
			System.out.println("Enter the emailId :");
			email = sc.next();
			if (email.contains("prin123@gmail.com") == false)
				// throw user exception
				throw new UserException("Your email is incorrect!!");
			System.out.println("Enter the password :");
			password = sc.next();
			// throw user exception
			if (password.contains("pr12#@123") == false)
				throw new UserException("Your password is incorrect!!");
			boolean validate = admindao.adminLogin(email, password);
			if (validate == false) {
				System.out.println("Invalid credentails!!");
			} else {
				System.out.println("Welcome To The Store Princy");
				System.out.println("------ ~~~~~~~~~ ------ ~~~~~~ -------");
				adminMenu();// call the admin Menu to display the admin functions
			}

		} catch (InputMismatchException e) {
			System.out.println("user entered a wrong input" + e);
		} catch (UserException e) {
			System.out.println(e);
		}
	}

	// Create an object of Product class
	Product product = null;
	// Create an object of Item class
	Item item = null;
	// Create an object of ProductDaoImpl
	ProductDaoImpl productdao = null;

	// admin menu
	private void adminMenu() {
		// Allocate memory to the obj of ProductDaoImpl class
		try {
			productdao = new ProductDaoImpl();
		} catch (ClassNotFoundException c) {
			System.out.println("Driver not loaded " + c);
			System.exit(0);
		} catch (SQLException e) {
			System.out.println("Sql issue" + e);
			System.exit(0);
		}
		do {
			int n = 0;
			List<Item> itemList = null;
			// int id = 0;
			System.out.println("1. Add the products in the store");
			System.out.println("2. List the products in the store");
			System.out.println("3. Search the product by using productid in the store");
			System.out.println("4. Get the list of the products by category");
			System.out.println("5. Search the product by using the name");
			System.out.println("6. Remove the product");
			System.out.println("7. Update the product details");
			System.out.println("8. To check the total amount spend on her products");
			System.out.println("9. Display the Profit amount that you get on products");
			System.out.println("0. logout");
			System.out.println("------ ~~~~~~~~~ ------ ~~~~~~ -------");
			System.out.println("enter your choice");
			choice = sc.nextInt();
			switch (choice) {
			// insert
			case 1:

				product = new Product();
				item = new Item();
				try {
					System.out.println("Enter the name of the product:");
					productName = sc.next();
					System.out.println("Enter the category of the product:");
					category = sc.next();
					System.out.println("Enter the available quantity:");
					availableQuantity = sc.nextFloat();
					System.out.println("Enter the buying price :");
					buyingPrice = sc.nextFloat();

					float sp = productdao.calSellPrice(buyingPrice);
					System.out.println("The selling price of the item is :" + sp);
					item.setProductName(productName);
					item.setAvailableQuantity(availableQuantity);
					item.setSellingPrice(sp);
					item.setItemName(productName);
					item.setBuyingPrice(buyingPrice);
					item.setcategory(category);

					n = productdao.addProduct(item);
					if (n == 0)
						System.out.println(" no record inserted ");
					else
						System.out.println(n + " :record inserted successfully!!");
				} catch (SQLException e) {
					System.out.println("Sql issues" + e);
				} catch (InputMismatchException e) {
					System.out.println("user entered a wrong input" + e);
				}

				break;
			// getAllProducts
			case 2:
				itemList = new ArrayList<>();
				try {
					itemList = productdao.getAllProducts();
					if (itemList.isEmpty())
						System.out.println("No product to show");
					else
						System.out.println("Id\tProduct Name\tQuantity\tSelling Price\tBuying Price\tCategory");
					System.out
							.println("------ ~~~~~~~~~ ------ ~~~~~~ ------- ~~~~~~~~ ---------- ~~~~~~~~~~ --------");
					for (Item get : itemList) {
						//
						System.out.println(get.getProductid() + "\t" + get.getProductName() + "\t\t"
								+ get.getAvailableQuantity() + "\t\t" + get.getSellingPrice() + "\t\t"
								+ get.getBuyingPrice() + "\t\t" + get.getcategory());
					}
					System.out
							.println("------ ~~~~~~~~~ ------ ~~~~~~ ------- ~~~~~~~~ ---------- ~~~~~~~~~ ----------");
				} catch (SQLException e) {
					System.out.println(e);
				}
				break;
			case 3:
				try {
					System.out.println("Enter the id of the product to search :");
					productid = sc.nextInt();
					item = new Item();

					item = productdao.getTheProductById(productid);
					if (item == null) {
						System.out.println("no product exist for id :" + productid);
					} else {
						System.out.println("Id :" + item.getProductid() + " " + "Name :" + item.getProductName() + " "
								+ "Quantity :" + item.getAvailableQuantity() + " " + "SellingPrice :"
								+ item.getSellingPrice() + " " + "Buying Price :" + item.getBuyingPrice() + " "
								+ "Category :" + item.getcategory());
					}
				} catch (SQLException e) {
					System.out.println(e);
				} catch (InputMismatchException e) {
					System.out.println("user entered a wrong input" + e);
				}

				break;
			case 4:
				
					System.out.println("Enter the category of the product:");
					category = sc.next();
					try {
					itemList = new ArrayList<>();

					itemList = productdao.getProductsByCat(category);
					if (itemList.isEmpty())
						System.out.println("No product available for " + category + " category");
					else {
						System.out.println("---------------------------------------------------------------");
						System.out.println("              " + category + " Items         ");
						System.out.println("---------------------------------------------------------------");
						for (Item get : itemList) {
							//
							System.out.println("Id :" + get.getProductid() + "\t" + "Name :" + get.getProductName()
									+ "\t" + "Quantity :" + get.getAvailableQuantity() + "\t" + "SellingPrice :"
									+ get.getSellingPrice() + "\t" + "Buying Price :" + get.getBuyingPrice());
						}
						System.out.println("--------------------------------------------------------------------");
					}
				} catch (SQLException e) {
					System.out.println(e);
				} 
				break;
			case 5:
				
					System.out.println("Enter the name of the product : ");
					productName = sc.next();
					try {
					item = new Item();

					item = productdao.getTheProductByName(productName);
					if (item == null) {
						System.out.println(productName + " : not exist");
					} else
						System.out.println("Id :" + item.getProductid() + " " + "Name :" + item.getProductName() + " "
								+ "Quantity :" + item.getAvailableQuantity() + " " + "SellingPrice :"
								+ item.getSellingPrice() + " " + "Buying Price :" + item.getBuyingPrice() + " "
								+ "Category :" + item.getcategory());
				} catch (SQLException e) {
					System.out.println(e);
				}
				break;
			// Remove the product by id and name
			case 6:
				
					System.out.println("Enter the name of the product to remove :");
					productName = sc.next();
					try {
					System.out.println("Enter the id of the product to remove :");
					productid = sc.nextInt();

					n = productdao.delProduct(productName, productid);
					if (n == 0)
						System.out.println(" no record deleted ");
					else
						System.out.println(n + " :record deleted successfully!!");
				} catch (SQLException e) {
					System.out.println("Sql issues" + e);
				} catch (InputMismatchException e) {
					System.out.println("user entered a wrong input" + e);
				}
				break;
			// Update the product details
			case 7:
				item = new Item();
				Item updateItem = null;
				System.out.println("Enter the id of the product that you want to update :");
				productid = sc.nextInt();
				System.out.println("Enter the name of the product:");
				productName = sc.next();
				System.out.println("Enter the category of the product:");
				category = sc.next();
				System.out.println("Enter the available quantity:");
				availableQuantity = sc.nextFloat();
				System.out.println("Enter the buying price :");
				buyingPrice = sc.nextFloat();
				float sp = productdao.calSellPrice(buyingPrice);
				System.out.println("The selling price of the item is :" + sp);
				item.setProductid(productid);
				item.setProductName(productName);
				item.setAvailableQuantity(availableQuantity);
				item.setSellingPrice(sp);
				item.setItemName(productName);
				item.setBuyingPrice(buyingPrice);
				item.setcategory(category);
				try {
					updateItem = productdao.updateProduct(item);
					if (updateItem == null)
						System.out.println("the item not updated");
					else
						System.out.println("Id :" +updateItem.getProductid() + " " + "Name :" + updateItem.getProductName() + " "
								+ "Quantity :" + updateItem.getAvailableQuantity() + " " + "SellingPrice :"
								+ updateItem.getSellingPrice() + " " + "Buying Price :" + updateItem.getBuyingPrice() + " "
								+ "Category :" + updateItem.getcategory());
				} catch (SQLException e1) {
					System.out.println(e1);
				}
				break;
			// To check the total amount spend on her products
			case 8:
				try {
					float sum = 0;
					sum = productdao.totalAmount();
					if (sum == 0)
						System.out.println("not calculated");
					else
						System.out.println("Total amount spend on buying all the products :" + sum);
				} catch (SQLException e) {
					System.out.println("Sql issues" + e);
				}
				break;
			// Total profit
			case 9:
				try {
					productdao.totalProfit();
				} catch (SQLException e) {
					System.out.println("Sql issues" + e);
				}
				break;
			case 0:
				System.out.println("** ** Bye Admin ** **");
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		} while (choice != 0);
	}

}
