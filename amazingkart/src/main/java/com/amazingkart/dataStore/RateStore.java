package com.amazingkart.dataStore;

import java.util.HashMap;
import java.util.Map;

public class RateStore {

	private static RateStore excahgenRateStore = new RateStore();

	HashMap<String, Double> rates = new HashMap<String, Double>();

	private RateStore() {

	}

	public static RateStore getInstance() {
		return excahgenRateStore;
	}

	public Map<String, Double> getRates() {
		return rates;
	}

	public void setRates(HashMap<String,Double> rates) {
		this.rates = rates;
	}

	public Double getRate(String currency) {
		return rates.get(currency);

	}
}
