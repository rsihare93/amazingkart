package com.amazingkart.Services;

import com.amazingkart.AmazingKartException;
import com.amazingkart.Constants;
import com.amazingkart.dataStore.ProductStore;
import com.amazingkart.dataStore.RateStore;
import com.amazingkart.importer.http.HttpJsonResponseFetcher;
import com.amazingkart.pojo.ExchangeRates;
import com.amazingkart.pojo.Product;

public class DataLoaderService {

	
	
	private DataLoaderService() {
		
	}
	
	private static DataLoaderService dataLoaderService =  new DataLoaderService();
	
	public static DataLoaderService getInstance() {
		return dataLoaderService;
	}
	
	public void loadProductDetails() throws AmazingKartException {
		ProductStore.getInstance()
		.addAll(new HttpJsonResponseFetcher<Product>().fetchJSONResponse(Constants.PRODUCT_DETAILS_URL));
	}

	public void loadExchangeRates() throws AmazingKartException {
		RateStore.getInstance().setRates(
				 new HttpJsonResponseFetcher<ExchangeRates>().fetchJSONResponseIntoMap(Constants.EXCHANGE_RATE_URL));
	}

}
