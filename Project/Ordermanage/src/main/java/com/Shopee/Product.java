package com.Shopee;

public class Product {
	private int id;
	private String Name;
	private String imageUrl;
	private int weight;
	private int price;
	private int amount;
	private int shopID;
	
	public Product() {
	}
	public Product(int id, String name, String imageUrl, int weight, int price, int amount, int shopID) {
		super();
		this.id = id;
		Name = name;
		this.imageUrl = imageUrl;
		this.weight = weight;
		this.price = price;
		this.amount = amount;
		this.shopID = shopID;

	}
	
	public Product(int id) {
		super();
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getShopID() {
		return shopID;
	}

	public void setShopID(int shopID) {
		this.shopID = shopID;
	}
	

}
