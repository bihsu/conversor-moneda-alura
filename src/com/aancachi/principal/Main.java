package com.aancachi.principal;

import java.io.IOException;
import java.util.Scanner;

import com.aancachi.util.Converter;

public class Main {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		int opcion;
		Scanner teclado = new Scanner(System.in);
		
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
			System.out.println("\t7) Salir\n");
			System.out.println("********************************************************\n");
			
			System.out.println("Elija una opción válida:");
			opcion = teclado.nextInt();
			
			
			switch (opcion) {
			case 1: 
				System.out.println("Ingrese la cantidad de [USD] a convertir en [ARS]: ");
				String usd = teclado.next();
				String convertedArs = Converter.convert("USD", "ARS", usd);
				System.out.println(convertedArs + "\n");
				break;
			case 2: 
				System.out.println("Ingrese la cantidad de [ARS] a convertir en [USD]: ");
				String ars = teclado.next();
				String convertedUsd = Converter.convert("ARS", "USD", ars);
				System.out.println(convertedUsd + "\n");
				
				//////////////REVISAR LAS EXCEPCIONES CUANDO EL API RETORNA UN 404
				break;
			case 3: 
				break;
			case 4: 
				break;
			case 5: 
				break;
			case 6: 
				break;
			case 7: 
				break;
			default:
				System.out.println("Ingrese un valor dentro del rango de opciones\n");
			}
			
		}while(opcion != 7);
		
		teclado.close();
		System.out.println("programa terminado");
		
	}

}
