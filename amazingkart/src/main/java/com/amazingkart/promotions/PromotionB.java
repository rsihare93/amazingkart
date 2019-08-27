package com.amazingkart.promotions;

import com.amazingkart.AmazingKartException;
import com.amazingkart.pojo.Discount;
import com.amazingkart.pojo.Product;
import com.amazingkart.promotions.Rule.CONDITIONS;
import com.amazingkart.promotions.Rule.DISCOUNT_TYPE;

public class PromotionB extends PromotionSet{
	@Override
	public void applyPromotion(Product product) throws AmazingKartException {

		Rule[] rules = {
				new Rule(DISCOUNT_TYPE.PERCENTAGE, 12.0, CONDITIONS.GREATER_THAN, new Integer[] { 20 }, "inventory",
						"7% discounted"),
				new Rule(DISCOUNT_TYPE.PERCENTAGE, 7.0, CONDITIONS.EQUAL, new String[] { "NEW" }, "arrival",
						"4% discounted"),
				};

		int maxDisc = 0;
		Discount maxDiscount = null;

		for (Rule r : rules) {
			Discount temp = r.applyRule(product);
			maxDiscount = maxDisc < temp.getAmount() ? temp : maxDiscount;
		}

		if (maxDiscount != null && maxDiscount.getAmount() > 0) {
			product.setDiscount(maxDiscount);
			return;
		}

		super.applyPromotion(product);
	}
}
