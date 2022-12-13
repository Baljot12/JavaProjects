//To declare abstract methods for product
package com.store.dao;

import java.sql.SQLException;
import java.util.List;

import com.store.model.Item;

public interface ProductDao {
	float calSellPrice(float buyingPrice);// set selling price by calling this method

	int addProduct(Item item) throws SQLException;// add the products in db by calling this method

	List<Item> getAllProducts() throws SQLException;// admin and user both get the list of products

	Item getTheProductById(int id) throws SQLException;// admin and user get the details of the product by pass id

	// admin and user both get the list of products by category
	List<Item> getProductsByCat(String category) throws SQLException;

	Item getTheProductByName(String name) throws SQLException;// get the details of the product by passing name

	int delProduct(String name, int id) throws SQLException;// perform delete operation

	List<Item> getProductsinAscOder() throws SQLException;// arrange products in asc order by selling price

	public float totalAmount() throws SQLException;// get total amount spent on all the products

	public void totalProfit() throws SQLException;// get total profit

	public Item updateProduct(Item item) throws SQLException;// update the details of the product

}
