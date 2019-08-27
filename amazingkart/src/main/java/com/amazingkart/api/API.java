package com.amazingkart.api;

import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import com.amazingkart.AmazingKartException;
import com.amazingkart.Services.DataLoaderService;
import com.amazingkart.dataStore.ProductStore;
import com.amazingkart.pojo.Product;
import com.amazingkart.promotions.PromotionSet;
import com.amazingkart.promotions.Promotions;
import com.amazingkart.util.JSONConverter;

public class API {

	private static final String OUTPUT_JSON_FILE_NAME = "output.json";
	private static final String TARGET = "target";

	/*
	 * This is main method, As a part of main method we call following steps 1)
	 * Validate and parse input to the program 2) It loads Product/currency rates
	 * data in memory 3) It applies promotion rules on all the product 4) Finally
	 * saves the products list in json file.
	 */
	public static void main(String[] args) {
		try {
			Promotions promotion = validateAndReadInput(args);
			loadDataInMemory();
			List<Product> updatedJSON = applyPromotion(promotion);
			writeToOutputFile(updatedJSON);
		} catch (AmazingKartException e) {
			e.printStackTrace();
		}

	}

	/* Writes the data back to json file */
	private static void writeToOutputFile(List<Product> applyPromotion) throws AmazingKartException {
		try {
			new JSONConverter<Product>().writeToJsonFile(
					Paths.get(TARGET, OUTPUT_JSON_FILE_NAME).toUri().toURL().getFile(), applyPromotion);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Applies the mentioned promotion on all products */
	private static List<Product> applyPromotion(Promotions promotion) throws AmazingKartException {
		PromotionSet promotionObject = promotion.getPromotionObject();
		List<Product> applyPromotion = promotionObject.applyPromotion(ProductStore.getInstance().getProducts());
		return applyPromotion;
	}

	/* Loads product and currency data into memory */
	private static void loadDataInMemory() throws AmazingKartException {
		DataLoaderService.getInstance().loadExchangeRates();
		DataLoaderService.getInstance().loadProductDetails();
	}

	/* Input Validations */
	private static Promotions validateAndReadInput(String[] args) throws AmazingKartException {
		if (args.length < 1 || args.length > 1) {
			throw new AmazingKartException("Invalid input parameter : " + args[0]);
		}
		Optional<Promotions> promotion = Promotions.getValue(args[0]);
		if (!promotion.isPresent()) {
			throw new AmazingKartException("Invalid input parameter : " + args[0]);
		}
		return promotion.get();
	}
}
