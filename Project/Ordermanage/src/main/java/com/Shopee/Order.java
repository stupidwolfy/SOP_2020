package com.Shopee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Order {
	private int id;
	private Date date;
	private List<String> shop;

	public Order(int id) {
		super();
		this.id = id;
		this.shop = new ArrayList<String>();
	}
	
	
	public Order(int id, Date date, List<String> shop) {
		super();
		this.id = id;
		this.date = date;
		this.shop = shop;
	}



	public long getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public void setDatenow() {
		this.date = new Date();
	}

	public List<String> getShop() {
		return shop;
	}

	public void setShop(List<String> shop) {
		this.shop = shop;
	}
	
	public void addShop(String newshop) {
		this.shop.add(newshop);
	}
	
	public void addShop(String ...args) {
		this.shop.addAll(Arrays.asList(args));
	}
	
	public void removeShop(String targetshop) {
		this.shop.remove(targetshop);
	}
	

}
