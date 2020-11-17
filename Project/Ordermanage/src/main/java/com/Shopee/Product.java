package com.Shopee;

public class Product {
	private int id;
	private int amount;
	private int total;
	
	public Product() {
	}
	public Product(int id, int amount, int total) {
		super();
		this.id = id;
		this.amount = amount;
		this.total = total;

	}
	
	public Product(int id) {
		super();
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void addAmount(int amount) {
		this.amount += amount;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	

}
