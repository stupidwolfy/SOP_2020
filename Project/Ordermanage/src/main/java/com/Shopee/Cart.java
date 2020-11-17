package com.Shopee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Cart {
	private int id;
	private int user_id;
	private Date date;
	private List<Product> product;
	private String promotion;

	public Cart() {
	}

	public Cart(int id, int user_id, Date date, List<Product> product, String promotion) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.date = date;
		this.product = product;
		this.promotion = promotion;
	}

	public Cart(int id) {
		super();
		this.id = id;
		this.product = new ArrayList<Product>();
	}

	public int getId() {
		return id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setDatenow() {
		this.date = new Date();
	}

	public List<Product> getProduct() {
		return product;
	}

	public void addProduct(Product newproduct) {
		// If product already in Cart
		if (product.stream().anyMatch(p -> p.getId() == newproduct.getId())) {
			product.stream().filter(o -> o.getId() == newproduct.getId()).findFirst().orElse(null).addAmount(newproduct.getAmount());
			
		} else {
			this.product.add(newproduct);
		}
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public void addProduct(Product... args) {
		this.product.addAll(Arrays.asList(args));
	}

	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

}
