package com.aancachi.model;

public record HistorialModel(
		String originCurrency,
		String targetCurrency,
		double quantity,
		double converted,
		String date,
		String status
		) {
	
	@Override
	public final String toString() {
		// TODO Auto-generated method stub
		return "\t"+quantity + " ["+ originCurrency+"] "+ " convertido a " + converted + " ["+targetCurrency+"] "+ "en fecha: "+date+ " estado: "+status;
	}
}
