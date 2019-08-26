package com.amazingkart.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.amazingkart.AmazingKartException;

public class HttpClient {

	public static String fetchResponse(String urlString) throws AmazingKartException {
		HttpURLConnection con = null;
		BufferedReader in = null;
		try {
			URL url = new URL(urlString);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json");
			con.setConnectTimeout(5000);
			con.setReadTimeout(5000);
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			return content.toString();
		} catch (IOException e) {
			throw new AmazingKartException("Unable to fetch response of the url " + urlString + " ", e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {

				}
			}
			if (con != null) {
				con.disconnect();
			}
		}
	}

}
