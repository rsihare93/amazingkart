package com.amazingkart.promotions;

import com.amazingkart.promotions.Condition.COMPARISON_OPERATOR;
import com.amazingkart.promotions.DiscountRule.CONDITION_GROUP_LOGIC_OPERATOR;
import com.amazingkart.promotions.DiscountRule.DISCOUNT_TYPE;

public class PromotionA extends PromotionSet {

	DiscountRule[] discountRules = {
			new DiscountRule(DISCOUNT_TYPE.PERCENTAGE, 7.0, "get 7% off", CONDITION_GROUP_LOGIC_OPERATOR.OR,
					new Condition[] { new Condition("origin", COMPARISON_OPERATOR.EQUAL, new String[] { "Africa" }) }),
			new DiscountRule(DISCOUNT_TYPE.PERCENTAGE, 4.0, "get 4% off", CONDITION_GROUP_LOGIC_OPERATOR.OR,
					new Condition[] { new Condition("rating", COMPARISON_OPERATOR.EQUAL, new Double[] { 2.0 }) })

			, new DiscountRule(DISCOUNT_TYPE.PERCENTAGE, 8.0, "get 8% off", CONDITION_GROUP_LOGIC_OPERATOR.OR,
					new Condition[] { new Condition("rating", COMPARISON_OPERATOR.LESS_THAN, new Double[] { 2.0 }) })

			,
			new DiscountRule(DISCOUNT_TYPE.AMOUNT, 100.0, "get Rs 100 off", CONDITION_GROUP_LOGIC_OPERATOR.AND,
					new Condition[] {
							new Condition("category", COMPARISON_OPERATOR.IN,
									new String[] { "electronics", "furnishing" }),
							new Condition("price", COMPARISON_OPERATOR.GREATER_THAN, new Double[] { 499.0 }) }) };

	protected DiscountRule[] getDiscountRules() {
		return discountRules;
	}

}
