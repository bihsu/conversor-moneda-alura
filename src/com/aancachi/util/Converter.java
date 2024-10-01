package com.aancachi.util;

import java.text.DecimalFormat;
import java.util.Date;

import com.aancachi.internet.ApiConsume;
import com.aancachi.model.HistorialModel;

public class Converter {
	
	private static DecimalFormat decimalFormat = new DecimalFormat("#.00");
	
	public static HistorialModel convert(String originCurrency, String targetCurrency,String quantity) {
		
		try {
			double doubleQuantity = Double.valueOf(quantity);
			double ratio = 0;
			var data = ApiConsume.getRate(originCurrency);
			
			if(data.conversion_rates() != null && data.conversion_rates().containsKey(targetCurrency)) {
				ratio = data.conversion_rates().get(targetCurrency);
				double converted =  doubleQuantity*ratio;
				
				return new HistorialModel(originCurrency, targetCurrency, doubleQuantity, converted, new Date().toString(),"SUCCESS");
			}else {
				return new HistorialModel(originCurrency, targetCurrency, doubleQuantity, 0, new Date().toString(),"FAILED");
			}
			
		} catch (NumberFormatException e) {
			System.out.println("Ingrese valores númericos para convertir");
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("No se encontró el código de moneda");
		}
		return null;
	}
	
	public static String getMessage(HistorialModel model) {
		if(model.converted() != 0) {
			return model.quantity()+" ["+model.originCurrency()+"] corresponde a "+ decimalFormat.format(model.converted()) + " ["+model.targetCurrency()+"]\n";
		}else {
			return "No se pudo convertir -- Código de moneda no encontrado\n";
		}
	}

}
