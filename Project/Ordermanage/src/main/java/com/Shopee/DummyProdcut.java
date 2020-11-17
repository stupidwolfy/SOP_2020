package com.Shopee;

public class DummyProdcut {
	private int id;
	private String sku;
	private String name;
	private String description;
	private String imageUrl;
	private float weight;
	private float price;
	private int stock;
	private int shopId;
	
	public DummyProdcut() {
	}
	
	public DummyProdcut(int id) {
		super();
		this.id = id;
	}

	public DummyProdcut(int id, String sku, String name, String description, String imageUrl, float weight, float price,
			int stock, int shopId) {
		super();
		this.id = id;
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
		this.weight = weight;
		this.price = price;
		this.stock = stock;
		this.shopId = shopId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	
	

}
