package com.amazingkart.promotions;

import java.util.ArrayList;
import java.util.List;

import com.amazingkart.AmazingKartException;
import com.amazingkart.pojo.Discount;
import com.amazingkart.pojo.Product;

public abstract class PromotionSet {

	
	public void applyPromotion(Product product) throws AmazingKartException {
		
		if(product.getPrice()>1000) {
			product.setDiscount(new Discount(product.getPrice()*0.02, "Default Discount"));
		}
		
	}
	
	public List<Product> applyPromotion(List<Product> products) throws AmazingKartException {
		List<Product> toRtturn = new ArrayList<Product>();
		for (Product product : products) {
			Product t = new Product(product);
			this.applyPromotion(t);
			toRtturn.add(t);
		}
		return toRtturn;
	}
}
