package com.videoclub.controller;

import com.videoclub.lib.Input;
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
					alquilarMultimediaSocio();
					break;
				case 3:
					devolverMultimediaSocio();
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
				promptAltas(userAnswer);
				break;
			case 2:
				promptAltas(userAnswer);
				break;
			case 3:
				promptAltas(userAnswer);
				break;
		}
	}

	public void promptAltas(int userAnswer)
	{
		if (userAnswer == 1)
		{
			String nif = Input.readInput("NIF: ", "String");
			String nombre = Input.readInput("Nombre: ", "String");
			String fechaNac = Input.readInput("Fecha Nac (dd/mm/yyyy): ", "String");
			String poblacion = Input.readInput("Poblacion: ", "String");

			gsc.crearSocio(nif, nombre, fechaNac, poblacion);
		}
		else if (userAnswer == 2 || userAnswer == 3)
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
			else
			{
				throw new Error("Not Valid");
			}
		}
	}

	public void alquilarMultimediaSocio()
	{
		String nif = Input.readInput("Introduzca su nif: ", "String");
		String respuesta;
		if (gsc.existeSocio(nif))
		{
			if (!ic.tenerDeuda(nif))
			{
				respuesta = Input.readInput("Desea alquilar [pelicula/videojuego/disco] ", "String");

				String titulo = "";
				Socio socio = gsc.buscarSocio(nif);

				switch (respuesta.toLowerCase())
				{
					default:
						System.out.println("Input not Valid!");
						break;
					case "pelicula":
						if (ic.existenPeliculas())
						{
							System.out.println(ic.mostrarMultimedias("pelicula"));
							titulo = Input.readInput("Escriba el Titulo: ", "String");
							ic.alquilarMultimedia(socio, titulo);
						}
						else
							System.out.println("No tenemos peliculas en stock");
						break;
					case "videojuego":
						if (ic.existenVideojuegos())
						{
							System.out.println(ic.mostrarMultimedias("videojuego"));
							titulo = Input.readInput("Escriba el Titulo: ", "String");
							ic.alquilarMultimedia(socio, titulo);
						}
						else
							System.out.println("No tenemos videojuegos en stock");
						break;
					case "disco":
						if (ic.existenDiscos())
						{
							System.out.println(ic.mostrarMultimedias("disco"));
							titulo = Input.readInput("Escriba el Titulo: ", "String");
							ic.alquilarMultimedia(socio, titulo);
						}
						else
							System.out.println("No tenemos discos disponibles");
						break;
				}
			}
			else
			{
				System.out.println("Socio con el nif: " + nif + "\n" + "tiene deuda");
			}
		}
		else
		{
			System.out.println("nif no existe :(");
		}
	}

	public void devolverMultimediaSocio()
	{
		String nif = Input.readInput("Introduzca su nif: ", "String");
		if (gsc.existeSocio(nif))
		{
			Socio socio = gsc.buscarSocio(nif);
			ic.mostrarAlquileresSocio(socio);
		}

	}

	public void listarAlquileresSocio()
	{
		String nif = Input.readInput("Introduzca su nif: ", "String");
		Socio socio = null;

		try
		{
			socio = gsc.buscarSocio(nif);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

}