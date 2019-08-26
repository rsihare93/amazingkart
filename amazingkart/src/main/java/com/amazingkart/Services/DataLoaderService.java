package com.amazingkart.Services;

import com.amazingkart.AmazingKartException;
import com.amazingkart.Constants;
import com.amazingkart.dataStore.ProductStore;
import com.amazingkart.dataStore.RateStore;
import com.amazingkart.importer.http.HttpJsonResponseFetcher;
import com.amazingkart.pojo.ExchangeRates;
import com.amazingkart.pojo.Product;

public class DataLoaderService {

	public void fetchProductDetails() throws AmazingKartException {
		ProductStore.getInstance()
		.addAll(new HttpJsonResponseFetcher<Product>().fetchJSONResponse(Constants.PRODUCT_DETAILS_URL));
	}

	public void fetchExchangeRates() throws AmazingKartException {
		RateStore.getInstance().setRates(
				 new HttpJsonResponseFetcher<ExchangeRates>().fetchJSONResponse(Constants.EXCHANGE_RATE_URL).get(0).getRates());
	}

}
