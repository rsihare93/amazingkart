package com.amazingkart.pojo;

public class Product {

	String category;
	Integer inventory;
	Double rating;
	String currency;
	Double price;
	String origin;
	String product;
	Discount discount;

	public Product(String category, Integer inventory, Double rating, String currency, Double price, String origin,
			String product, Discount discount) {
		super();
		this.category = category;
		this.inventory = inventory;
		this.rating = rating;
		this.currency = currency;
		this.price = price;
		this.origin = origin;
		this.product = product;
		this.discount = discount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

}

