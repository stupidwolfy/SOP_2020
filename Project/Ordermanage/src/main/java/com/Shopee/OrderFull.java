package com.Shopee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderFull {
	private int id;
	private String name;
	private String address;
	private List<Order> orderPool;
	private String shipping;
	private String promotion;
	private String payment;
	private int payShipping;
	private int totalPrice;

	public OrderFull(int id) {
		super();
		this.id = id;
		this.orderPool = new ArrayList<Order>();
	}

	public OrderFull(int id, String name, String address, List<Order> orderPool, String shipping, String promotion,
			String payment, int payShipping, int totalPrice) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.orderPool = orderPool;
		this.shipping = shipping;
		this.promotion = promotion;
		this.payment = payment;
		this.payShipping = payShipping;
		this.totalPrice = totalPrice;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Order> getOrderPool() {
		return orderPool;
	}

	public void setOrderPool(List<Order> orderPool) {
		this.orderPool = orderPool;
	}

	public void addOrder(Order newOrder) {
		this.orderPool.add(newOrder);
	}

	public void addOrder(Order... args) {
		this.orderPool.addAll(Arrays.asList(args));
	}

	public String getShipping() {
		return shipping;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getPayShipping() {
		return payShipping;
	}

	public void setPayShipping(int payShipping) {
		this.payShipping = payShipping;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

}
