package com.videoclub;

import com.videoclub.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Socio> arrayListSocio = new ArrayList<>();
		ArrayList<Multimedia> arrayListMultimedia = new ArrayList<>();
		ArrayList<Alquiler> arrayListAlquiler = new ArrayList<>();


		boolean exit = false;
		int userInput;

		while(!exit) {
			menuOptions();
			userInput = integerInput(false);

			if (userInput == 0) {
				exit = true;
			}
			else if (userInput == 1) {
				altasMenuOptions();
				userInput = integerInput(false);
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
				userInput = integerInput(false);
				listarMenu(userInput, arrayListAlquiler);
			}
			else {
				System.out.println("Input Not Valid");
			}
		}
	}

	public static int integerInput(boolean raw) {
		Scanner myScanner = new Scanner(System.in);

		int userInput;

		if (raw) {
			userInput = myScanner.nextInt();
		}
		else {
			System.out.print("Option: ");
			userInput = myScanner.nextInt();
			System.out.println("--- ---- ---");
		}

		return userInput;
	}

	public static String stringInput(boolean raw) {
		Scanner myScanner = new Scanner(System.in);

		String input = "";

		if (raw) {
			input = myScanner.nextLine();
		}
		else {
			input = myScanner.nextLine();
			System.out.println("--- ---- ---");
		}

		return input;
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

			if (arrayListSocio.size() > 0) {
				arrayListSocio.remove(0);
			}

			System.out.print("NIF: ");
			String nif = stringInput(true);

			System.out.println("");

			System.out.print("Name: ");
			String name = stringInput(true);

			System.out.println("");

			System.out.print("Fecha Nacimiento (dd/mm/yyyy): ");
			String fechaNacimiento = stringInput(true);
			String[] fechas = fechaNacimiento.split("/");
			int dia = Integer.parseInt(fechas[0]);
			int mes = Integer.parseInt(fechas[1]);
			int anyo = Integer.parseInt(fechas[2]);

			LocalDate lc;
			lc = LocalDate.of(anyo, mes, dia);

			System.out.println("");

			System.out.print("Poblacion: ");
			String poblacion = stringInput(true);

			Socio mySocio = new Socio(nif, name, lc, poblacion);
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
			userInput = integerInput(true);

			System.out.println(Alquiler.buscarAlquiler(arrayListAlquiler, userInput).toString());
		}
		else {
			System.out.println("Input Not Valid");
		}
	}
}