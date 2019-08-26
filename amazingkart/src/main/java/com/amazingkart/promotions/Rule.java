package com.amazingkart.promotions;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import com.amazingkart.AmazingKartException;
import com.amazingkart.pojo.Discount;
import com.amazingkart.pojo.Product;

public class Rule {

	enum CONDITIONS {
		EQUAL, IN, GREATER_THAN, LESS_THAN;
	}
	
	enum DISCOUNT_TYPE {
		AMOUNT, PERCENTAGE
	}
	
	private DISCOUNT_TYPE discount_type;
	private Double discount;
	private CONDITIONS condition;
	private List<Object> values;
	private String variableName;
	private String discountTag;
	



	public Rule(DISCOUNT_TYPE discount_type, Double discount, CONDITIONS condition, Object[] values,
			String variableName, String discountTag) {
		super();
		this.discount_type = discount_type;
		this.discount = discount;
		this.condition = condition;
		this.values = Arrays.asList(values);
		this.variableName = variableName;
		this.discountTag = discountTag;
	}



	public CONDITIONS getCondition() {
		return condition;
	}



	public void setCondition(CONDITIONS condition) {
		this.condition = condition;
	}



	public List<Object> getValues() {
		return values;
	}



	public void setValues(List<Object> values) {
		this.values = values;
	}



	public String getVariableName() {
		return variableName;
	}



	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}



	public Discount applyRule(Product product) throws AmazingKartException  {
		Discount discount = new Discount(0.0, "");
		PropertyDescriptor pd;
		try {
			pd = new PropertyDescriptor(getVariableName(), Product.class);
		
		Method getter = pd.getReadMethod();
		switch (condition) {
		case EQUAL:
			if(getter.invoke(product).equals(values.get(0))) {
				discount = new Discount(applyDiscount(product.getPrice()), discountTag);
			}
			break;
		case IN:
			if(values.contains(getter.invoke(product))) {
				discount = new Discount(applyDiscount(product.getPrice()), discountTag);
			}
			break;
		case GREATER_THAN:
			if(((Comparable)getter.invoke(product)).compareTo(values.get(0))>0) {
				discount = new Discount(applyDiscount(product.getPrice()), discountTag);
			}
			break;
			
		case LESS_THAN:
			if(((Comparable)getter.invoke(product)).compareTo(values.get(0))<0) {
				discount = new Discount(applyDiscount(product.getPrice()), discountTag);
			}
			break;	
		
		default:
			break;
		}
		} catch ( SecurityException|IllegalArgumentException|InvocationTargetException|IllegalAccessException|IntrospectionException e) {
			throw new AmazingKartException("Exception occured while applying discount",e);
		}
		return discount;
	}
	
	private double applyDiscount(Double amount) {
		if(DISCOUNT_TYPE.PERCENTAGE.equals(discount_type)) {
			return amount * (discount/100);
		} else {
			return discount;
		}
	}
	
	
}

