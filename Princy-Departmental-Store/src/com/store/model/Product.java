////Define a POJO class Product
package com.store.model;

public class Product {
	// private data members
	private int productid;
	private String productName;
	private float sellingPrice;
	private float availableQuantity;

	// public getter & setter methods
	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public float getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(float availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	// default constructor to initialize the object of the class
	public Product() {
		super();

	}

	// param constructor to initialize the object of the class to pass the args
	public Product(int productid, String productName, float sellingPrice, float availableQuantity) {
		super();
		this.productid = productid;
		this.productName = productName;
		this.sellingPrice = sellingPrice;
		this.availableQuantity = availableQuantity;
	}

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productName=" + productName + ", sellingPrice=" + sellingPrice
				+ ", availableQuantity=" + availableQuantity + "]";
	}

}
