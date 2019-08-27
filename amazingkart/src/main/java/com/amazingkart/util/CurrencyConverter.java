package com.amazingkart.util;

import com.amazingkart.dataStore.RateStore;

public class CurrencyConverter {

	public static double convert(String sourceCurrency, String destCurrency, double price) {
		Double dest = RateStore.getInstance().getRate(destCurrency);
		Double src = RateStore.getInstance().getRate(sourceCurrency);
		return price * (dest/src);
	}
	
	
}
