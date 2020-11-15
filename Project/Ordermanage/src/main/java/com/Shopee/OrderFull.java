package com.Shopee;

public class OrderFull {
	private int id;
	private String name;
	private String address;
	private Order order;
	private String shipping;
	private int promotion;
	private String payment;
	private int payShipping;
	private int totalPrice;

	public OrderFull(int id) {
		super();
		this.id = id;
	}

	public OrderFull(int id, String name, String address, Order order, String shipping, int promotion, String payment,
			int payShipping, int totalPrice) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.order = order;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getShipping() {
		return shipping;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

	public int getPromotion() {
		return promotion;
	}

	public void setPromotion(int promotion) {
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
