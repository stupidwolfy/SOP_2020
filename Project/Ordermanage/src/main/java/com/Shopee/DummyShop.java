package com.Shopee;

public class DummyShop {
	private int id;
	private int owner;
	private String picture;
	private String name;
	private String detail;
	private String categories;
	private int follower;
	private float rating;

	public DummyShop() {
		super();
	}

	public DummyShop(int id, int owner, String picture, String name, String detail, String categories, int follower,
			float rating) {
		super();
		this.id = id;
		this.owner = owner;
		this.picture = picture;
		this.name = name;
		this.detail = detail;
		this.categories = categories;
		this.follower = follower;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public int getFollower() {
		return follower;
	}

	public void setFollower(int follower) {
		this.follower = follower;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

}
