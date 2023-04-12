package com.videoclub;

import com.videoclub.model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Socio> arrayListSocio = new ArrayList<>();
		ArrayList<Multimedia> arrayListMultimedia = new ArrayList<>();
		ArrayList<Alquiler> arrayListAlquiler = new ArrayList<>();

		Scanner myScanner = new Scanner(System.in);

		boolean exit = false;
		int userInput;

		while(!exit) {
			menuOptions();
			userInput = userInput(myScanner, false);

			if (userInput == 0) {
				exit = true;
			}
			else if (userInput == 1) {
				altasMenuOptions();
				userInput = userInput(myScanner, false);
				altasMenu(userInput, arrayListSocio, arrayListMultimedia);
			}
			else if (userInput == 2) {
				ArrayList<Multimedia> arrayListMultimediaDeSocio = new ArrayList<>();
				
				for (int x = 0; x < arrayListMultimedia.size(); x++) {
					arrayListMultimediaDeSocio.add(arrayListMultimedia.get(x));
					arrayListMultimedia.remove(x);
				}

				Alquiler myAlquiler = new Alquiler(arrayListSocio.get(0), arrayListMultimediaDeSocio);

				arrayListAlquiler.add(myAlquiler);
			}
			else if (userInput == 4) {
				listarMenuOptions();
				userInput = userInput(myScanner, false);
				listarMenu(userInput, arrayListAlquiler);
			}
			else {
				System.out.println("Input Not Valid");
			}
		}
	}

	public static int userInput(Scanner myScanner, boolean raw) {
		int userInput;

		if (raw) {
			userInput = myScanner.nextInt();
			System.out.println("--- ---- ---");
		}
		else {
			System.out.print("Option: ");
			userInput = myScanner.nextInt();
			System.out.println("--- ---- ---");
		}

		return userInput;
	}

	public static void menuOptions() {
		System.out.println("### MENU ###");
		System.out.println("[1] Altas");
		System.out.println("[2] Alquilar Multimedia a Socio");
		System.out.println("[3] Devolver Multimedia a Socio");
		System.out.println("[4] Listar");
		System.out.println("[0] Salir");
		System.out.println("--- ---- ---");
	}
	
	public static void altasMenuOptions() {
		System.out.println("### Altas MENU ###");
		System.out.println("[1] Alta a Socio");
		System.out.println("[2] Alta a Pelicula");
		System.out.println("[3] Alta a Videojuego");
		System.out.println("[0] Salir");
		System.out.println("--- ---- ---- ---");
	}

	public static void listarMenuOptions() {
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

	public static void altasMenu(int userInput, ArrayList<Socio> arrayListSocio, ArrayList<Multimedia> arrayListMultimedia) {
		if (userInput == 0) {

		}
		else if (userInput == 1) {
			Socio mySocio = new Socio();
			arrayListSocio.add(mySocio);
		}
		else if (userInput == 2) {
			Pelicula myPelicula = new Pelicula();
			arrayListMultimedia.add((Multimedia) myPelicula);
		}
		else if (userInput == 3) {
			Videojuego myVideojuego = new Videojuego();
			arrayListMultimedia.add((Multimedia) myVideojuego);
		}
		else {
			System.out.println("Invalid Input");
		}
	}

	public static void listarMenu(int userInput, ArrayList<Alquiler> arrayListAlquiler) {
		Scanner myScanner = new Scanner(System.in);

		if (userInput == 0) {

		}
		else if (userInput == 1) {

		}
		else if (userInput == 5) {
			System.out.print("ID: ");
			userInput = userInput(myScanner, true);

			System.out.println(Alquiler.buscarAlquiler(arrayListAlquiler, userInput).toString());
		}
		else {
			System.out.println("Input Not Valid");
		}
	}
}