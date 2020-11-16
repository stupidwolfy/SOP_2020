package com.Shopee;

public class Promotion {
	private int id;
	private String description;
	
	public Promotion() {
	}

	public Promotion(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
