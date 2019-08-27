package com.amazingkart.promotions;

import com.amazingkart.AmazingKartException;
import com.amazingkart.pojo.Discount;
import com.amazingkart.pojo.Product;

/*DiscountRule object corresponds to the discount condition 
 * and amount/ percentage of discount 
 * that can be applied on product*/
public class DiscountRule {

	enum DISCOUNT_TYPE {
		AMOUNT, PERCENTAGE
	}

	enum CONDITION_GROUP_LOGIC_OPERATOR {
		AND, OR
	}

	private DISCOUNT_TYPE discount_type;
	private Condition conditions[];
	private Double discount;
	private String discountTag;
	private CONDITION_GROUP_LOGIC_OPERATOR operator;
	private CONDITION_GROUP_LOGIC_OPERATOR group_LOGIC_OPERATOR;

	public DiscountRule(DISCOUNT_TYPE discount_type, Double discount, String discountTag,
			CONDITION_GROUP_LOGIC_OPERATOR group_LOGIC_OPERATOR, Condition[] condition) {
		super();
		this.discount_type = discount_type;
		this.discount = discount;
		this.discountTag = discountTag;
		this.conditions = condition;
		this.group_LOGIC_OPERATOR = group_LOGIC_OPERATOR;
	}

	private double applyDiscount(Double amount) {
		if (DISCOUNT_TYPE.PERCENTAGE.equals(discount_type)) {
			return amount * (discount / 100);
		} else {
			return discount;
		}
	}

	/*
	 * This method applies the discount rule on product and returns the amount of
	 * discount that can be applied
	 */
	public Discount applyDiscountRule(Product product) throws AmazingKartException {
		Discount discount = new Discount(0.0, "");
		boolean ruleResult = CONDITION_GROUP_LOGIC_OPERATOR.AND.equals(this.operator) ? true : false;

		if (conditions.length > 0) {
			for (Condition condition : conditions) {
				boolean runCondition = condition.runCondition(product);
				ruleResult = CONDITION_GROUP_LOGIC_OPERATOR.AND.equals(this.operator) ? runCondition && ruleResult
						: ruleResult || runCondition;
			}
		} else {
			throw new AmazingKartException("No Discount rule condition is specified");
		}

		if (ruleResult) {
			discount = new Discount(applyDiscount(product.getPrice()), discountTag);
		}

		return discount;
	}

	public DISCOUNT_TYPE getDiscount_type() {
		return discount_type;
	}

	public void setDiscount_type(DISCOUNT_TYPE discount_type) {
		this.discount_type = discount_type;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getDiscountTag() {
		return discountTag;
	}

	public void setDiscountTag(String discountTag) {
		this.discountTag = discountTag;
	}

	public CONDITION_GROUP_LOGIC_OPERATOR getOperator() {
		return operator;
	}

	public void setOperator(CONDITION_GROUP_LOGIC_OPERATOR operator) {
		this.operator = operator;
	}

	public Condition[] getCondition() {
		return conditions;
	}

	public void setCondition(Condition[] condition) {
		this.conditions = condition;
	}

	public CONDITION_GROUP_LOGIC_OPERATOR getGroup_LOGIC_OPERATOR() {
		return group_LOGIC_OPERATOR;
	}

	public void setGroup_LOGIC_OPERATOR(CONDITION_GROUP_LOGIC_OPERATOR group_LOGIC_OPERATOR) {
		this.group_LOGIC_OPERATOR = group_LOGIC_OPERATOR;
	}

}
