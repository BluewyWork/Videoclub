package com.videoclub.controller;

import com.videoclub.lib.Input;
import com.videoclub.model.Pelicula;
import com.videoclub.model.Socio;
import com.videoclub.view.ConsoleMenuView;

public class ConsoleMenu
{
	GestorSocioController gsc;
	InventarioController ic;
	ConsoleMenuView cmv;

	public ConsoleMenu()
	{
		gsc = new GestorSocioController();
		ic = new InventarioController();
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

				gsc.crearSocio(nif, nombre, fechaNac, poblacion);
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

				ic.createMultimedia("pelicula", titulo, autor, formato, anyo, duracion, actorPrincipal, atrizPrincipal, formato);
			}
			else if (userAnswer == 3)
			{
				String plataforma = Input.readInput("Plataforma: ");

				ic.createMultimedia("videojuego", titulo, autor, formato, anyo, duracion, null, null, plataforma);
			}
		}
	}

//	public void alquilarMultimediaSocio()
//	{
//		String nif = Input.readInput("Introduzca su nif: ", "String");
//		String respuesta;
//		if (gsc.existeSocio(nif))
//		{
//			if (!gac.tieneDeudas(gsc.buscarSocio(nif)))
//			{
//				respuesta = Input.readInput("Desea alquilar una pelicula, un videojuego o un disco?", "String");
//				switch (respuesta)
//				{
//					case "pelicula" -> ic.mostrarPeliculas(gsc.buscarSocio(nif));
//
//					case "videojuego" ->
//							ic.mostrarVideojuegos(gsc.buscarSocio(nif));
//
//					case "disco" -> ic.mostrarDiscos(gsc.buscarSocio(nif));
//				}
//			}
//			else
//			{
//				System.out.println("Tienes una deuda pendiente, tienes que pagar para poder seguir alquilando");
//			}
//		}
//		else
//		{
//			System.out.println("Introduzca un DNI valido que exista en la base de datos");
//		}
//	}

	public void alquilarMultimediaSocio2()
	{
		String nif = Input.readInput("Introduzca su nif: ", "String");
		String respuesta;
		if (gsc.existeSocio(nif))
		{
			if (!ic.tenerDeuda(nif))
			{
				respuesta = Input.readInput("Desea alquilar [pelicula/videojuego/disco] ", "String");
				switch (respuesta.toLowerCase())
				{
					default:
						System.out.println("Input not Valid!");
					case "pelicula":
						System.out.println(ic.mostrarPeliculas());
						String titulo = Input.readInput("Titulo: ", "String");
						ic.alquilarMultimedia(gsc.buscarSocio(nif), titulo);
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

	public void listarAlquileresSocio()
	{
		String nif = Input.readInput("Introduzca su nif: ", "String");
		Socio socio = null;

		try
		{
			socio = gsc.buscarSocio(nif);

		} catch (Exception e)
		{
			System.out.println(e);
		}
	}
}



