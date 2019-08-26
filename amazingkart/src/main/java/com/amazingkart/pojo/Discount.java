package com.amazingkart.pojo;

public class Discount implements Comparable<Discount> {
	Double amount;
	String discountTag;

	public Discount(Double amount, String discountTag) {
		super();
		this.amount = amount;
		this.discountTag = discountTag;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDiscountTag() {
		return discountTag;
	}

	public void setDiscountTag(String discountTag) {
		this.discountTag = discountTag;
	}

	public int compareTo(Discount o) {
		return o.getAmount().compareTo(getAmount());
	}

}