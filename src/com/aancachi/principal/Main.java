package com.aancachi.principal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.aancachi.internet.ApiConsume;
import com.aancachi.model.HistorialModel;
import com.aancachi.util.Converter;
import com.aancachi.util.Printer;

public class Main {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		int opcion;
		Scanner teclado = new Scanner(System.in);
		List<HistorialModel> historial = new ArrayList<>();
		
		do {
			System.out.println("********************************************************");
			System.out.println("Biernvenido al convertidor de moneda Alura - Oracle ONE");
			System.out.println("********************************************************\n");
			
			System.out.println("\t1) Dólar =>> Peso Argentino");
			System.out.println("\t2) Peso argentino =>> Dólar");
			System.out.println("\t3) Dólar =>> Real brasileño");
			System.out.println("\t4) Real brasileño =>> Dólar");
			System.out.println("\t5) Dólar =>> Peso colombiano");
			System.out.println("\t6) Peso colombiano =>> Dólar");
			System.out.println("\t7) Ver mi historial de conversiones");
			System.out.println("\t8) Otras monedas");
			System.out.println("\t9) Salir\n");
			System.out.println("********************************************************\n");
			
			System.out.println("Elija una opción válida:");
			opcion = teclado.nextInt();
			
			
			switch (opcion) {
			case 1: 
				System.out.println("Ingrese la cantidad de [USD] a convertir en [ARS]: ");
				String usd = teclado.next();
				var convertedArs = Converter.convert("USD", "ARS", usd);
				historial.add(convertedArs);
				System.out.println(Converter.getMessage(convertedArs) + "\n");
				break;
			case 2: 
				System.out.println("Ingrese la cantidad de [ARS] a convertir en [USD]: ");
				String ars = teclado.next();
				var convertedUsd = Converter.convert("ARS", "USD", ars);
				historial.add(convertedUsd);
				System.out.println(Converter.getMessage(convertedUsd) + "\n");
				break;
			case 3:
				System.out.println("Ingrese la cantidad de [USD] a convertir en [BRL]: ");
				String usd2 = teclado.next();
				var convertedBrl = Converter.convert("USD", "BRL", usd2);
				historial.add(convertedBrl);
				System.out.println(Converter.getMessage(convertedBrl) + "\n");
				break;
			case 4: 
				System.out.println("Ingrese la cantidad de [BRL] a convertir en [USD]: ");
				String brl = teclado.next();
				var convertedUsd2 = Converter.convert("BRL", "USD", brl);
				historial.add(convertedUsd2);
				System.out.println(Converter.getMessage(convertedUsd2) + "\n");
				break;
			case 5:
				System.out.println("Ingrese la cantidad de [USD] a convertir en [COP]: ");
				String usd3 = teclado.next();
				var convertedCol = Converter.convert("USD", "COP", usd3);
				historial.add(convertedCol);
				System.out.println(Converter.getMessage(convertedCol) + "\n");
				break;
			case 6: 
				System.out.println("Ingrese la cantidad de [COP] a convertir en [USD]: ");
				String cop = teclado.next();
				var convertedUsd3 = Converter.convert("COP", "USD", cop);
				historial.add(convertedUsd3);
				System.out.println(Converter.getMessage(convertedUsd3) + "\n");
				break;
			case 7:
				System.out.println("\t\t******************* Mostrando tu historial de conversiones*************************");
				if(!historial.isEmpty()) {
					historial.forEach(h->System.out.println(h));
					System.out.println("😄 Fin del historial\n");
				}else {
					System.out.println("No realizaste ninguna conversión aún \n");
				}
				break;
			case 8:
				var codes = ApiConsume.allCodes();
				Printer.printMapCodes(codes.supported_codes());
				System.out.println("Ingrese el código de moneda a convertir: ");
				String firstCode = teclado.next();
				System.out.println("Ingrese la cantidad a convertir:");
				String quantity = teclado.next();
				System.out.println("Ingrese el código de moneda de destino:");
				String secondCode = teclado.next();
				var otherConverted = Converter.convert(firstCode, secondCode, quantity);
				historial.add(otherConverted);
				System.out.println(Converter.getMessage(otherConverted));
				break;
			case 9: 
				break;
			default:
				System.out.println("Ingrese un valor dentro del rango de opciones\n");
			}
			
		}while(opcion != 9);
		
		teclado.close();
		System.out.println("Terminado el programa -- Gracias por usar nuestro convetidor de monedas 🙋‍♂️ 👍😄👍");
		
	}

}
