package com.amazingkart.importer.http;

import java.lang.reflect.Type;
import java.util.List;

import com.amazingkart.AmazingKartException;
import com.amazingkart.pojo.Product;
import com.amazingkart.util.HttpClient;
import com.amazingkart.util.JSONConverter;

public class HttpJsonResponseFetcher<T> {

	
	public T fetchJSONResponse(String url, Class<T> class1) throws AmazingKartException {
		return new JSONConverter<T>().convertJsonToObject(HttpClient.fetchResponse(url), class1);
	}

	public List<Product> fetchJSONResponse(String productDetailsUrl, Type type) throws AmazingKartException {
		return new JSONConverter<Product>().convertJsonToObject(HttpClient.fetchResponse(productDetailsUrl), type);
	}
	
	
}
