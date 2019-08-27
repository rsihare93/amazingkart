package com.amazingkart.util;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.amazingkart.AmazingKartException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JSONConverter<T> {

	public T convertJsonToObject(String jsonString, Class<T> class1) {
		Gson gson = new Gson();
		return gson.fromJson(jsonString, class1);
	}
	
	public List<T> convertJsonToObject(String jsonString, Type type) {
		Gson gson = new Gson();
		return gson.fromJson(jsonString, type);
	}
	
	public T convertJsonToObjectMap(String jsonString) {
		Type listType = new TypeToken<T>() {
		}.getType();
		Gson gson = new Gson();
		return gson.fromJson(jsonString, listType);
	}

	public void writeToJsonFile(String file, List<T> products) throws AmazingKartException {
		Type listType = new TypeToken<ArrayList<T>>() {
		}.getType();
		Gson gson = new Gson();
		String json = gson.toJson(products, listType);
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
			fileWriter.write(json);

		} catch (IOException e) {
			throw new AmazingKartException("Could not write to the file", e);
		} finally {
			try {
				if (fileWriter != null)
					fileWriter.close();
			} catch (IOException e) {
				throw new AmazingKartException("Could not write to the file", e);
			}
		}
	}



}
