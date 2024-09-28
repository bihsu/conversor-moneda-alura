package com.aancachi.internet;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.aancachi.model.CodesModel;
import com.aancachi.model.ExchageRateModel;
import com.google.gson.Gson;

public class ApiConsume {
	
	private static HttpClient client = HttpClient.newHttpClient();
	private static final String KEY = "32533725c5c17d68cc733f54";
	private static final String API_URL = "https://v6.exchangerate-api.com/v6/"+KEY+"/latest/";
	private static final String CODES_URL = "https://v6.exchangerate-api.com/v6/"+KEY+"/codes";
	
	public static ExchageRateModel getRate(String moneda){
		try {
			HttpRequest request = HttpRequest.newBuilder(URI.create(API_URL+moneda)).build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			return new Gson().fromJson(response.body(), ExchageRateModel.class);
		} catch (IOException e) {
			System.out.println("No se pudo realizar la consulta");
		} catch (InterruptedException e) {
			System.out.println("Algo salío mal");
		} 
		return null;
	}
	
	public static CodesModel allCodes() {
		try {
			HttpRequest request = HttpRequest.newBuilder(URI.create(CODES_URL)).build();
			HttpResponse<String> repsonse = client.send(request, HttpResponse.BodyHandlers.ofString());
			return new Gson().fromJson(repsonse.body(), CodesModel.class);
		} catch (IOException e) {
			System.out.println("No se pudo realizar la consulta");
		} catch (InterruptedException e) {
			System.out.println("Algo salío mal");
		}
		return null;
	}

}
