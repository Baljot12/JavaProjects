//Define a POJO class Item
package com.store.model;

public class Item extends Product {
	// private data members
	private String itemName;
	private String category;
	private float buyingPrice;

	// public getter & setter methods

	public String getcategory() {
		return category;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setcategory(String category) {
		this.category = category;
	}

	public float getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(float buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	// default constructor to initialize the object of the class
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", category=" + category + ", buyingPrice=" + buyingPrice + ", productId="
				+ getProductid() + ", ProductName=" + getProductName() + ", SellingPrice=" + getSellingPrice()
				+ ", Quantity=" + getAvailableQuantity() + ", toString()=" + super.toString() + "]";
	}

	// param constructor to initialize the object of the class to pass the args
	public Item(String itemName, String category, float buyingPrice) {
		super();
		this.itemName = itemName;
		this.category = category;
		this.buyingPrice = buyingPrice;
	}

}
