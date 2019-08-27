package com.amazingkart.pojo;

import java.util.HashMap;

public class ExchangeRates {

	HashMap<String, Double> rates = new HashMap<String, Double>();
	String base;
	String date;
	

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public HashMap<String, Double> getRates() {
		return rates;
	}

	public void setRates(HashMap<String, Double> rates) {
		this.rates = rates;
	}
	
	
}
