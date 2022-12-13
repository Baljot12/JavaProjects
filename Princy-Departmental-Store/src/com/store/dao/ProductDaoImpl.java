//To implement product interface to perform functionalities
package com.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.store.model.Item;

public class ProductDaoImpl implements ProductDao {
	private Connection conn;
	private PreparedStatement ps;
	private PreparedStatement ps1;
	private ResultSet result;
	List<Item> itemList = null;

	// call the get connection function of DBConnection
	public ProductDaoImpl() throws ClassNotFoundException, SQLException {
		conn = DBConnection.getConnection();
	}

	@Override
	public float calSellPrice(float buyingPrice) {
		float sellPrice = (float) ((buyingPrice * 0.5) + buyingPrice);
		return sellPrice;
	}

	@Override
	public int addProduct(Item item) throws SQLException {
		int add = 0;
		String query = "insert into product (productName, sellingPrice, availableQuantity) values (?,?,?)";
		String query1 = "insert into item (itemname, category, buyingPrice) values(?,?,?)";
		ps = conn.prepareStatement(query);
		ps1 = conn.prepareStatement(query1);

		ps.setString(1, item.getProductName());
		ps.setFloat(2, item.getSellingPrice());
		ps.setFloat(3, item.getAvailableQuantity());
		int n = ps.executeUpdate();
		if (n > 0) {
			ps1.setString(1, item.getItemName());
			ps1.setString(2, item.getcategory());
			ps1.setFloat(3, item.getBuyingPrice());
			add = ps1.executeUpdate();
		}
		return add;

	}

	public List<Item> getAllProducts() throws SQLException {
		itemList = new ArrayList<>();
		// inner join return all the rows which are common in both
		String query = "select * from product inner join item on product.productName = item.itemname";
		ps = conn.prepareStatement(query);
		result = ps.executeQuery();// obj of result store the return value of executeQuery
		while (result.next() == true) {
			Item getitem = new Item();
			getitem.setProductid(result.getInt(1));
			getitem.setProductName(result.getString(2));
			getitem.setSellingPrice(result.getFloat(3));
			getitem.setAvailableQuantity(result.getFloat(4));
			getitem.setcategory(result.getString(6));
			getitem.setBuyingPrice(result.getFloat(7));
			itemList.add(getitem);
		}
		return itemList;
	}

	public Item getTheProductById(int id) throws SQLException {

		String query = "select * from product inner join item on product.productName = item.itemname where product.productid =? ";
		ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		result = ps.executeQuery();// obj of result store the return value of executeQuery
		if (result.next()) {
			Item getitem = new Item();
			getitem.setProductid(result.getInt(1));
			getitem.setProductName(result.getString(2));
			getitem.setSellingPrice(result.getFloat(3));
			getitem.setAvailableQuantity(result.getFloat(4));
			getitem.setcategory(result.getString(6));
			getitem.setBuyingPrice(result.getFloat(7));
			return getitem;
		} else
			return null;

	}

	public List<Item> getProductsByCat(String category) throws SQLException {
		itemList = new ArrayList<>();
		// inner join return all the rows which are common in both
		String query = "select * from product inner join item on product.productName = item.itemname where item.category =?";
		ps = conn.prepareStatement(query);
		ps.setString(1, category);
		result = ps.executeQuery();// obj of result store the return value of executeQuery
		while (result.next() == true) {
			Item getitem = new Item();
			getitem.setProductid(result.getInt(1));
			getitem.setProductName(result.getString(2));
			getitem.setSellingPrice(result.getFloat(3));
			getitem.setAvailableQuantity(result.getFloat(4));
			getitem.setBuyingPrice(result.getFloat(7));
			itemList.add(getitem);
		}
		return itemList;
	}

	public Item getTheProductByName(String name) throws SQLException {
		String query = "select * from product inner join item on product.productName = item.itemname where product.productName =? ";
		ps = conn.prepareStatement(query);
		ps.setString(1, name);
		result = ps.executeQuery();// obj of result store the return value of executeQuery
		if (result.next()) {
			Item getitem = new Item();
			getitem.setProductid(result.getInt(1));
			getitem.setProductName(result.getString(2));
			getitem.setSellingPrice(result.getFloat(3));
			getitem.setAvailableQuantity(result.getFloat(4));
			getitem.setcategory(result.getString(6));
			getitem.setBuyingPrice(result.getFloat(7));
			return getitem;
		} else
			return null;
	}

	public int delProduct(String name, int id) throws SQLException {
		String query = "delete item,product from item inner join product on item.itemname = product.productName where item.itemname =? and product.productid =?";
		ps = conn.prepareStatement(query);
		ps.setString(1, name);
		ps.setInt(2, id);
		return ps.executeUpdate();

	}

	public float totalAmount() throws SQLException {
		// get the list of (Available Quantity * Buying Price) of all the rows
		List<Float> totalSpendAmountonEach = new ArrayList<>();
		String query = "select product.availableQuantity ,item.buyingPrice, (availableQuantity*buyingPrice) from product inner join item on product.productName = item.itemname ";
		ps = conn.prepareStatement(query);
		result = ps.executeQuery();
		while (result.next()) {
			Item getitem = new Item();
			// return values according to their increasing order of productid.
			getitem.setAvailableQuantity(result.getFloat(1));
			getitem.setBuyingPrice(result.getFloat(2));
			Float getValue = result.getFloat(3);
			totalSpendAmountonEach.add(getValue);
		}
		System.out.println("(Available Quantity * Buying Price)" + totalSpendAmountonEach);
		float sum1 = 0;
		for (int i = 0; i < totalSpendAmountonEach.size(); i++) {
			sum1 += totalSpendAmountonEach.get(i);
		}
		return sum1;
	}

	@Override
	public List<Item> getProductsinAscOder() throws SQLException {
		// use inner join to select the data from both the tables
		String query = "select * from product inner join item on product.productName = item.itemname order by sellingPrice";
		ps = conn.prepareStatement(query);
		result = ps.executeQuery();
		itemList = new ArrayList<>();
		while (result.next()) {
			Item getitem = new Item();
			getitem.setProductid(result.getInt(1));
			getitem.setProductName(result.getString(2));
			getitem.setSellingPrice(result.getFloat(3));
			getitem.setAvailableQuantity(result.getFloat(4));
			getitem.setcategory(result.getString(6));
			itemList.add(getitem);
		}
		return itemList;
	}

	@Override
	public void totalProfit() throws SQLException {
		float sum1 = totalAmount();// Sum of Cost Price of all the products.
		System.out.println("Total sum of CostPrice of  all the products :" + sum1);
		System.out.println();
		String query = "select availableQuantity ,sellingPrice, (availableQuantity*sellingPrice) from product";
		ps = conn.prepareStatement(query);
		result = ps.executeQuery();
		// get the list of (Available Quantity * Selling Price) of all the rows
		List<Float> totalSpendAmountonEach = new ArrayList<>();
		while (result.next()) {
			Item getitem = new Item();
			// return values according to their increasing order of productid.
			getitem.setAvailableQuantity(result.getFloat(1));
			getitem.setSellingPrice(result.getFloat(2));
			Float getValue = result.getFloat(3);
			totalSpendAmountonEach.add(getValue);
		}
		System.out.println("Available Quantity * Selling Price)" + totalSpendAmountonEach);
		float sum2 = 0;
		for (int i = 0; i < totalSpendAmountonEach.size(); i++) {

			sum2 += totalSpendAmountonEach.get(i);
		}
		System.out.println("Total sum of Selling Price of  all the products :" + sum2);
		float profit = sum2 - sum1;
		System.out.println();
		System.out.println("Total(Profit) = Total(SellingPrice) - Total(CostPrice)");
		System.out.println(+profit + " = " + sum2 + " - " + sum1);
		System.out.println("--~~~~~~ ~~~~~~~~~~~~~~ ----------~~~~~~~~~~ ~~~~~~~");

	}

	@Override
	public Item updateProduct(Item item) throws SQLException {
		String query = "update product inner join item on product.productName = item.itemname set productName =?,"
				+ "sellingPrice =?,availableQuantity=?,itemname=?," + "category=?, buyingPrice= ? where productid =? ";
		ps = conn.prepareStatement(query);
		ps.setInt(7, item.getProductid());
		ps.setString(1, item.getProductName());
		ps.setFloat(2, item.getSellingPrice());
		ps.setFloat(3, item.getAvailableQuantity());
		ps.setString(4, item.getItemName());
		ps.setString(5, item.getcategory());
		ps.setFloat(6, item.getBuyingPrice());
		ps.executeUpdate();// it is responsible to execute the query///
		return item;
	}

}
