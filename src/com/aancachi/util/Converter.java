package com.aancachi.util;

import com.aancachi.internet.ApiConsume;

public class Converter {
	
	public static String convert(String originCurrency, String targetCurrency,String quantity) {
		try {
			double doubleQuantity = Double.valueOf(quantity);
			
			var data = ApiConsume.getRate(originCurrency);
			
			double ratio = data.conversion_rates().get(targetCurrency);
			
			double converted =  doubleQuantity*ratio;
			
			String response = quantity+" ["+originCurrency+"] corresponde a "+ converted + " ["+targetCurrency+"]";
			
			return response;
			
		} catch (NumberFormatException e) {
			System.out.println("Ingrese valores númericos para convertir");
		}
		return "No se pudo realizar la operación";
	}
}
