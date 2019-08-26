package com.amazingkart.pojo;

import java.util.HashMap;
import java.util.Map;

public class ExchangeRates {

	Map<String, Double> rates = new HashMap<String, Double>();

	public Map<String, Double> getRates() {
		return rates;
	}

	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}
	
	
}
