package com.amazingkart.promotions;

import com.amazingkart.promotions.DiscountRule.CONDITION_GROUP_LOGIC_OPERATOR;
import com.amazingkart.promotions.DiscountRule.DISCOUNT_TYPE;

public class PromotionB extends PromotionSet {

	DiscountRule[] rules = {
			new DiscountRule(DISCOUNT_TYPE.PERCENTAGE, 12.0, "get 12% off", CONDITION_GROUP_LOGIC_OPERATOR.OR,
					new Condition[] { new Condition("inventory", Condition.COMPARISON_OPERATOR.GREATER_THAN,
							new Integer[] { 20 }) }),
			new DiscountRule(DISCOUNT_TYPE.PERCENTAGE, 7.0, "get 7% off", CONDITION_GROUP_LOGIC_OPERATOR.OR,
					new Condition[] {
							new Condition("arrival", Condition.COMPARISON_OPERATOR.EQUAL, new String[] { "NEW" }) }) };

	protected DiscountRule[] getDiscountRules() {
		return rules;
	}
}
