package com.amazingkart.dataStore;

import java.util.ArrayList;
import java.util.List;

import com.amazingkart.pojo.Product;

public class ProductStore {

	
	private static ProductStore productStore = new ProductStore();
	
	private List<Product> products = new ArrayList<Product>();
	
	private ProductStore() {
		
	}
	
	public static ProductStore getInstance() {
		return productStore;
	}
	
	
	public void addAll(List<Product> products) {
		products.addAll(products);
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
}
