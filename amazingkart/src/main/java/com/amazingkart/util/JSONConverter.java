package com.amazingkart.util;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JSONConverter<T> {
	
	public List<T> convertJsonToObject(String jsonString) {
		Type listType = new TypeToken<ArrayList<T>>(){}.getType();
		Gson gson = new Gson();
		return gson.fromJson(jsonString, listType);
				
	}
	
}
