package com.videoclub;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);

		boolean exit = false;
		int userInput;

		while(!exit) {
			menu();
			userInput = userInput(myScanner);

			if (userInput == 5) {
				exit = true;
			}
			else if (userInput == 1) {
				altasMenu();
				userInput = userInput(myScanner);
			}
			else if (userInput == 4) {
				listarMenu();
				userInput = userInput(myScanner);
			}
			else {
				System.out.println("Input Not Valid");
			}
		}
	}

	public static void menu() {
		System.out.println("### MENU ###");
		System.out.println("1. Altas");
		System.out.println("2. Alquilar Multimedia a Socio");
		System.out.println("3. Devolver Multimedia a Socio");
		System.out.println("4. Listar");
		System.out.println("--- ---- ---");
	} 
	
	public static void altasMenu() {
		System.out.println("### Altas MENU ###");
		System.out.println("1. Alta a Socio");
		System.out.println("2. Alta a Pelicula");
		System.out.println("3. Alta a Videojuego");
		System.out.println("--- ---- ---- ---");
	}

	public static void listarMenu() {
		System.out.println("### Listar MENU ###");
		System.out.println("1.Listado de todos los objetos multimedia");
		System.out.println("2. Listado de todas las películas ordenadas por título");
		System.out.println("3. Listado de todas las canciones de un disco por duración");
		System.out.println("4. Listado de todos los videojuegos ordenados por año");
		System.out.println("5. Listado de los alquileres actuales de un socio");
		System.out.println("6. Listado de los socios con recargos pendientes");
		System.out.println("--- ------ ---- ---");
	}

	public static int userInput(Scanner myScanner) {
		System.out.print("Option: ");
		int userInput = myScanner.nextInt();
		System.out.println("--- ---- ---");

		return userInput;
	}
}	
