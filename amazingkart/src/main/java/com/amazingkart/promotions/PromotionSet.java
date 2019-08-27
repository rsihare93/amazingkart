package com.amazingkart.promotions;

import java.util.ArrayList;
import java.util.List;

import com.amazingkart.AmazingKartException;
import com.amazingkart.pojo.Discount;
import com.amazingkart.pojo.Product;

public abstract class PromotionSet {

	
	public void applyDefaultPromotion(Product product) throws AmazingKartException {
		
		if(product.getPrice()>1000) {
			product.setDiscount(new Discount(product.getPrice()*0.02, "get 2% off"));
		}
		
	}
	
	public void applyPromotion(Product product) throws AmazingKartException {
		Discount maxDiscount = getMaxDiscount(product);
		if (maxDiscount != null && maxDiscount.getAmount() > 0) {
			product.setDiscount(maxDiscount);
			return;
		}
		this.applyDefaultPromotion(product);
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
	
	
	abstract protected DiscountRule[] getDiscountRules();
	
	protected  Discount getMaxDiscount(Product product) throws AmazingKartException {
		double maxDisc = 0;
		Discount maxDiscount = null;

		for (DiscountRule r : getDiscountRules()) {
			Discount temp = r.applyDiscountRule(product);
			maxDiscount = maxDisc < temp.getAmount() ? temp : maxDiscount;
			maxDisc = (maxDiscount!=null)?maxDiscount.getAmount():maxDisc;
		}
		return maxDiscount;
	}
}
