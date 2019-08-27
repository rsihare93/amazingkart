package com.amazingkart.promotions;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import com.amazingkart.AmazingKartException;
import com.amazingkart.pojo.Product;

class Condition {
		enum COMPARISON_OPERATOR {
		EQUAL, IN, GREATER_THAN, LESS_THAN;
	}

		private String variableName;
		private List<Object> values;
		private Condition.COMPARISON_OPERATOR operator; 
		
		Condition(String productVariable, Condition.COMPARISON_OPERATOR operator, Object[] values) {
			this.operator =operator; 	
			this.variableName = productVariable;
			this.values = Arrays.asList(values);
		}
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public boolean runCondition(Product product) throws AmazingKartException {
			PropertyDescriptor pd;
			try {
				pd = new PropertyDescriptor(getVariableName(), Product.class);

				Method getter = pd.getReadMethod();
				switch (operator) {
				case EQUAL:
					if ((values.get(0)).equals(getter.invoke(product))) {
						return true;
					}
					break;
				case IN:
					if (values.contains(getter.invoke(product))) {
						return true;
					}
					break;
				case GREATER_THAN:
					if (((Comparable) getter.invoke(product)).compareTo(values.get(0)) > 0) {
						return true;
					}
					break;

				case LESS_THAN:
					if (((Comparable) getter.invoke(product)).compareTo(values.get(0)) < 0) {
						return true;
					}
					break;

				default:
					return false;
				}
			} catch (SecurityException | IllegalArgumentException | InvocationTargetException | IllegalAccessException
					| IntrospectionException e) {
				throw new AmazingKartException("Exception occured while applying discount", e);
			}
			return false;
		}
		
		public Condition.COMPARISON_OPERATOR getCondition() {
			return operator;
		}

		public void setCondition(Condition.COMPARISON_OPERATOR operator) {
			this.operator = operator;
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

	}