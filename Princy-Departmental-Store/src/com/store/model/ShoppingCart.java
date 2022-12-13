//To Create a shopping cart for the user
package com.store.model;

public class ShoppingCart {
	private Item item;// To enter the details of the purchasing item
	private int num;// To store the number of items
	private float bill;// To display the bill

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getBill() {
		return bill;
	}

	public void setBill(float bill) {
		this.bill = bill;
	}

	@Override
	public String toString() {
		return "ShoppingCart [item=" + item + ", num=" + num + ", bill=" + bill + "]";
	}

	public ShoppingCart() {
		super();
	}

	public ShoppingCart(Item item, int num, float bill) {
		super();
		this.item = item;
		this.num = num;
		this.bill = bill;
	}

}
