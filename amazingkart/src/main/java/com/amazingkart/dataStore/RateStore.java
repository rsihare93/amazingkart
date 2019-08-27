package com.amazingkart.dataStore;

import java.util.Map;

import com.google.gson.internal.LinkedTreeMap;

public class RateStore {

	private static RateStore excahgenRateStore = new RateStore();

	Map<String, Double> rates = new LinkedTreeMap<String, Double>();

	private RateStore() {

	}

	public static RateStore getInstance() {
		return excahgenRateStore;
	}

	public Map<String, Double> getRates() {
		return rates;
	}

	public void setRates(Map<String, LinkedTreeMap<String,Double>> rates) {
		this.rates.putAll(rates.get("rates"));
	}

	public Double getRate(String currency) {
		return rates.get(currency);

	}
}
