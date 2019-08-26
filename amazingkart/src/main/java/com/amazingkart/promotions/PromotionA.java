package com.amazingkart.promotions;

import com.amazingkart.AmazingKartException;
import com.amazingkart.pojo.Discount;
import com.amazingkart.pojo.Product;
import com.amazingkart.promotions.Rule.CONDITIONS;
import com.amazingkart.promotions.Rule.DISCOUNT_TYPE;

public class PromotionA extends PromotionSet{

	@Override
	public void applyPromotion(Product product) throws AmazingKartException {
	
		Rule[] rules = { new Rule(DISCOUNT_TYPE.PERCENTAGE, 7.0, CONDITIONS.EQUAL, 
				new String[]{"Africa"}, "origin", "7% discounted") 
		,new Rule(DISCOUNT_TYPE.PERCENTAGE, 4.0, CONDITIONS.EQUAL, 
				new Double[]{2.0}, "rating", "4% discounted") 
		 ,new Rule(DISCOUNT_TYPE.PERCENTAGE, 8.0, CONDITIONS.LESS_THAN, 
				new Double[]{2.0}, "rating", "4% discounted") 
		
		,new Rule(DISCOUNT_TYPE.AMOUNT, 100.0, CONDITIONS.IN, 
				new String[]{"electronics","furnishing"}, "category", "7% discounted") };

		
		int maxDisc = 0;
		Discount maxDiscount = null;
		
		for(Rule r : rules) {
			 Discount temp = r.applyRule(product);
			 maxDiscount = maxDisc<temp.getAmount()?temp:maxDiscount;
		}
	
		if(maxDiscount!= null && maxDiscount.getAmount()>0) {
			product.setDiscount(maxDiscount);
			return;
		}
		
		super.applyPromotion(product);
	}
	

}
