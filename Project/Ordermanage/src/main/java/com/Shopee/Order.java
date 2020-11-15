package com.Shopee;

public class Order {
	private int id;
	private String date;
	private String[] shop;

	public Order(int id) {
		super();
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String[] getShop() {
		return shop;
	}

	public void setShop(String[] shop) {
		this.shop = shop;
	}

}
