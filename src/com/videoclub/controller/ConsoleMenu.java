package com.videoclub.controller;

import com.videoclub.controller.GestorAlquilerController;
import com.videoclub.controller.GestorSocioController;
import com.videoclub.controller.InventarioController;
import com.videoclub.lib.Input;
import com.videoclub.model.Pelicula;
import com.videoclub.model.Socio;
import com.videoclub.view.ConsoleMenuView;

public class ConsoleMenu
{
	GestorSocioController myGestorSocioController;
	GestorAlquilerController myGestorAlquilerController;
	InventarioController inventarioController;
	ConsoleMenuView cmv;

	public ConsoleMenu()
	{
		myGestorAlquilerController = new GestorAlquilerController();
		myGestorSocioController = new GestorSocioController();
		inventarioController = new InventarioController();
		cmv = new ConsoleMenuView();
	}

	public void run()
	{
		boolean exit = false;

		while (!exit)
		{
			cmv.menuPrincipal();
			int userAnswer = Input.readInput("Option: ", "int");

			switch (userAnswer)
			{
				default:
					System.out.println("Valor no Valido!");
					break;
				case 0:
					exit = true;
					break;
				case 1:
					cmv.menuAltas();
					altas();
					break;
				case 2:
					alquilarMultimediaSocio2();
					break;
				case 3:
					break;
				case 4:
					cmv.menuListar();
					break;
			}
		}
	}

	public void altas()
	{
		int userAnswer = Input.readInput("Option: ", "int");

		switch (userAnswer)
		{
			default:
				System.out.println("Valor No Valido!");
				break;
			case 0:
				break;
			case 1:
				String nif = Input.readInput("NIF: ", "String");
				String nombre = Input.readInput("Nombre: ", "String");
				String fechaNac = Input.readInput("Fecha Nac (dd/mm/yyyy): ", "String");
				String poblacion = Input.readInput("Poblacion: ", "String");

				myGestorSocioController.crearSocio(nif, nombre, fechaNac, poblacion);
				break;
			case 2:
				promptMultimedia(userAnswer);
				break;
			case 3:
				promptMultimedia(userAnswer);
				break;
		}
	}

	public void promptMultimedia(int userAnswer)
	{
		if (userAnswer == 2 || userAnswer == 3)
		{
			String titulo = Input.readInput("Titulo: ", "String");
			String autor = Input.readInput("Autor: ", "String");
			String formato = Input.readInput("Formato: ", "String");
			int anyo = Input.readInput("Año: ", "int");
			int duracion = Input.readInput("Duracion: ", "int");

			if (userAnswer == 2)
			{
				String actorPrincipal = Input.readInput("Actor Principal: ", "String");
				String atrizPrincipal = Input.readInput("Actriz Principal: ", "String");

				inventarioController.createMultimedia("pelicula", titulo, autor, formato, anyo, duracion, actorPrincipal, atrizPrincipal, formato);
			}
			else if (userAnswer == 3)
			{
				String plataforma = Input.readInput("Plataforma: ");

				inventarioController.createMultimedia("videojuego", titulo, autor, formato, anyo, duracion, null, null, plataforma);
			}
		}
	}

	public void alquilarMultimediaSocio()
	{
		String nif = Input.readInput("Introduzca su nif: ", "String");
		String respuesta;
		if (myGestorSocioController.existeSocio(nif))
		{
			if (!myGestorAlquilerController.tieneDeudas(myGestorSocioController.buscarSocio(nif)))
			{
				respuesta = Input.readInput("Desea alquilar una pelicula, un videojuego o un disco?", "String");
				switch (respuesta)
				{
					case "pelicula" -> inventarioController.mostrarPeliculas(myGestorSocioController.buscarSocio(nif));

					case "videojuego" ->
							inventarioController.mostrarVideojuegos(myGestorSocioController.buscarSocio(nif));

					case "disco" -> inventarioController.mostrarDiscos(myGestorSocioController.buscarSocio(nif));
				}
			}
			else
			{
				System.out.println("Tienes una deuda pendiente, tienes que pagar para poder seguir alquilando");
			}
		}
		else
		{
			System.out.println("Introduzca un DNI valido que exista en la base de datos");
		}
	}

	public void alquilarMultimediaSocio2()
	{
		String nif = Input.readInput("Introduzca su nif: ", "String");
		String respuesta;
		if (myGestorSocioController.existeSocio(nif))
		{
			if (!myGestorAlquilerController.tieneDeudas2(myGestorSocioController.buscarSocio(nif)))
			{
				respuesta = Input.readInput("Desea alquilar una pelicula, un videojuego o un disco?", "String");
				switch (respuesta)
				{
					case "pelicula" -> inventarioController.mostrarPeliculas(myGestorSocioController.buscarSocio(nif));

					case "videojuego" ->
							inventarioController.mostrarVideojuegos(myGestorSocioController.buscarSocio(nif));

					case "disco" -> inventarioController.mostrarDiscos(myGestorSocioController.buscarSocio(nif));
				}
				myGestorAlquilerController.aquilar(myGestorSocioController.buscarSocio(nif), new Pelicula());
			}
			else
			{
				System.out.println("Tienes una deuda pendiente, tienes que pagar para poder seguir alquilando");
			}
		}
		else
		{
			System.out.println("Introduzca un DNI valido que exista en la base de datos");
		}
	}

	public void listarAlquileresSocio()
	{
		String nif = Input.readInput("Introduzca su nif: ", "String");
		Socio socio = null;

		try
		{
			socio = myGestorSocioController.buscarSocio(nif);

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}
}



