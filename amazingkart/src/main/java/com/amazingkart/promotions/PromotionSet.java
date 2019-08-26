package com.amazingkart.promotions;

import com.amazingkart.AmazingKartException;
import com.amazingkart.pojo.Discount;
import com.amazingkart.pojo.Product;

public abstract class PromotionSet {

	
	public void applyPromotion(Product product) throws AmazingKartException {
		
		if(product.getPrice()>1000) {
			product.setDiscount(new Discount(product.getPrice()*0.02, "Default Discount"));
		}
		
	}
	
	
}
