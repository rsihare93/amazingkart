package com.amazingkart.importer.http;

import java.util.List;
import java.util.Map;

import com.amazingkart.AmazingKartException;
import com.amazingkart.util.HttpClient;
import com.amazingkart.util.JSONConverter;

public class HttpJsonResponseFetcher<T> {

	
	public List<T> fetchJSONResponse(String url) throws AmazingKartException {
		return new JSONConverter<T>().convertJsonToObject(HttpClient.fetchResponse(url));
	}
	
	public Map fetchJSONResponseIntoMap(String url) throws AmazingKartException {
		return (Map) new JSONConverter<T>().convertJsonToObjectMap(HttpClient.fetchResponse(url));
	}
	
	
	
	
}
