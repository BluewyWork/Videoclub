package com.videoclub.view;

import com.videoclub.controller.GestorAlquilerController;
import com.videoclub.controller.InventarioController;
import com.videoclub.lib.Input;

public class ConsoleMenu {
	
	GestorAlquilerController myAlquilerController = new GestorAlquilerController();
	InventarioController myInventarioController = new InventarioController();
	
	public static void menuPrincipal() {
		String prompt = "Option: ";
		int userAnswer = Input.readInput(prompt);
		boolean exit = false;

		while(!exit) {
			System.out.println("### MENU ###");
			System.out.println("[1] Altas");
			System.out.println("[2] Alquilar Multimedia a Socio");
			System.out.println("[3] Devolver Multimedia a Socio");
			System.out.println("[4] Listar");
			System.out.println("[0] Salir");
			System.out.println("--- ---- ---");

			switch(userAnswer) {
				default:
					System.out.println("Valor No Valido!");
					break;
				case 0:
					exit = true;
					break;
				case 1:
					menuAltas();
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					menuListar();
					break;
			}
		}

		
	}
	
	public static void menuAltas() {
		System.out.println("### Altas MENU ###");
		System.out.println("[1] Alta a Socio");
		System.out.println("[2] Alta a Pelicula");
		System.out.println("[3] Alta a Videojuego");
		System.out.println("[0] Salir");
		System.out.println("--- ---- ---- ---");

		int userAnswer = Input.readInput("Option: ");

		switch (userAnswer) {
			default:
				break;
			case 0:
				break;
			case 1:
				String nif = Input.readInput("NIF: ");
				String nombre = Input.readInput("Nombre: ");
				String fechaNacimiento = Input.readInput("fecha nac: ");
				String poblacion = Input.readInput("Poblacion: ");

				myAlquilerController.createSocio(nif, nombre, fechaNacimiento, poblacion);
				break;
			case 2:
				break;
			case 3:
				break;
				
		}
	}

	public static void menuListar() {
		System.out.println("### Listar MENU ###");
		System.out.println("[1] Listado de todos los objetos multimedia");
		System.out.println("[2] Listado de todas las películas ordenadas por título");
		System.out.println("[3] Listado de todas las canciones de un disco por duración");
		System.out.println("[4] Listado de todos los videojuegos ordenados por año");
		System.out.println("[5] Listado de los alquileres actuales de un socio");
		System.out.println("[6] Listado de los socios con recargos pendientes");
		System.out.println("[7] Salir");
		System.out.println("--- ------ ---- ---");
	}
}
