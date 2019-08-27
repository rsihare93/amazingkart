package com.amazingkart.api;

import java.util.List;
import java.util.Optional;

import com.amazingkart.AmazingKartException;
import com.amazingkart.Services.DataLoaderService;
import com.amazingkart.dataStore.ProductStore;
import com.amazingkart.pojo.Product;
import com.amazingkart.promotions.Promotions;
import com.amazingkart.util.JSONConverter;

public class API {

	public static void main(String[] args) {

		try {
			Optional<Promotions> promotion = Promotions.getValue(args[0]);
			if (!promotion.isPresent()) {
				throw new AmazingKartException("Invalid input parameter : " + args[0]);
			}
			DataLoaderService.getInstance().loadExchangeRates();
			DataLoaderService.getInstance().loadProductDetails();
			List<Product> applyPromotion = promotion.get().getPromotionObject().applyPromotion(ProductStore.getInstance().getProducts());
			new  JSONConverter<Product>().writeToJsonFile("output.json", applyPromotion);
		} catch (AmazingKartException e) {
			e.printStackTrace();
		}

	}
}
