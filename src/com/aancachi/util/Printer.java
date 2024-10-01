package com.aancachi.util;

import java.util.Map;

public class Printer {
	
	public static boolean printMapCodes(Map<String,String> codes) {
		
		int anchoClave = 15;
        int anchoValor = 10;
		
		if(codes != null) {
			// Imprimir encabezados
	        System.out.printf("\t%-" + anchoClave + "s %" + anchoValor + "s%n", "Código", "País");
	        System.out.println("\t"+"-".repeat(anchoClave + anchoValor));

	        // Imprimir las entradas del mapa
	        for (Map.Entry<String, String> entrada : codes.entrySet()) {
	            System.out.printf("\t%-" + anchoClave + "s %" + anchoValor + "s%n", entrada.getKey(), entrada.getValue());
	        }
	        return true;
		}
		else {
			System.out.println("No se pudo obtener respuestas del servidor\n");
			return false;
		}
	}

}
