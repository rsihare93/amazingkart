package com.amazingkart.promotions;

import java.util.Arrays;
import java.util.Optional;

public enum Promotions {

	PROMOTION_A("promotionSetA", new PromotionA()),
	PROMOTION_B("promotionSetB", new PromotionB());

	private String name;
	private PromotionSet instance;

	Promotions(String name, PromotionSet obj) {
		this.name = name;
		this.instance = obj;
	}

	public static Optional<Promotions> getValue(String name) {
		return Arrays.asList(Promotions.values()).stream().filter(p -> p.name.equals(name)).findFirst();
	}

	public PromotionSet getPromotionObject() {
		return this.instance;
	}

}
