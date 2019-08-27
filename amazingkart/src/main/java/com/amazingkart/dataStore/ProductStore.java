package com.amazingkart.dataStore;

import java.util.ArrayList;
import java.util.List;

import com.amazingkart.pojo.Product;
import com.amazingkart.util.CurrencyConverter;

public class ProductStore {

	private static ProductStore productStore = new ProductStore();

	private List<Product> products = new ArrayList<Product>();

	private ProductStore() {

	}

	public static ProductStore getInstance() {
		return productStore;
	}

	public void addAll(List<Product> products) {

		for (Product product : products) {
			if (!product.getCurrency().equals("INR")) {
				product.setPrice(CurrencyConverter.convert(product.getCurrency(), "INR", product.getPrice()));
			}
			products.add(product);
		}
	}

	public List<Product> getProducts() {
		return products;
	}

}
