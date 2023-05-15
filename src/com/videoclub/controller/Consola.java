package com.videoclub.controller;

import com.videoclub.lib.Input;
import com.videoclub.model.Alquiler;
import com.videoclub.model.Multimedia;
import com.videoclub.view.ConsolaView;

public class Consola
{
	public static void main(String[] args)
	{
		ConsolaView consolaView = new ConsolaView();
		SocioController socioController = new SocioController();
		MultimediaController multimediaController = new MultimediaController();
		AlquilerController alquilerController = new AlquilerController();

		boolean exit = false;
		int userInput = 9;

		while (!exit)
		{
			consolaView.menuPrincipal();
			userInput = Input.readInput("Option: ", "int");

			switch (userInput)
			{
				case 0 -> exit = true;
				case 1 ->
				{
					consolaView.menuAltas();
					userInput = Input.readInput("Option: ", "int");

					switch (userInput)
					{

						case 1 ->
						{
							String nif = Input.readInput("NIF: ", "String");
							String name = Input.readInput("Name: ", "String");
							String birthDate = Input.readInput("Birth Date (dd/mm/yyyy): ");
							String town = Input.readInput("Town: ", "String");

							socioController.registrarSocio(nif, name, birthDate, town);
						}
						case 2, 3 ->
						{
							String title = Input.readInput("Titulo: ", "String");
							String author = Input.readInput("Autor: ", "String");
							String format = Input.readInput("Formato: ", "String");
							int year = Input.readInput("Año: ", "int");

							switch (userInput)
							{
								case 2 ->
								{
									int duration = Input.readInput("Duration:  ", "int");
									String maleLead = Input.readInput("Male Lead: ", "String");
									String femaleLead = Input.readInput("Female Lead: ", "String");

									multimediaController.altaPelicula(title, author, format, year, duration, maleLead, femaleLead);
								}

								case 3 ->
								{
									String platform = Input.readInput("Plataforma: ");

									multimediaController.altaVideojuego(title, author, format, year, platform);
								}
							}
						}
					}
				}
				case 2 ->
				{
					System.out.println(socioController.mostrarSocios());
					String memberNIF = Input.readInput("NIF: ", "String");

					System.out.println(multimediaController.mostrarMultimedias());
					String title = Input.readInput("Title: ", "String");
					String author = Input.readInput("Author: ", "String");

					Multimedia multimedia = multimediaController.recuperarMultimedias(title, author);

					alquilerController.alquilarMultimedia(memberNIF, multimedia);
				}
				case 3 ->
				{
					System.out.println(alquilerController.mostrarAlquileres());
					int id = Input.readInput("ID: ", "int");

					Alquiler alquiler = alquilerController.delvolverAlquiler(id);

					Multimedia multimedia = alquiler.getMultimedia();

					multimediaController.guardarMultimedia(multimedia);
				}
				case 4 ->
				{
					System.out.println("In Stock: ");
					String originalString = multimediaController.mostrarMultimedias(); // Get the original string
					String indentedString = "\t" + originalString.replace("\n", "\n\t"); // Prepend a tab character to each line
					System.out.println(indentedString + "\n");

					System.out.println("Rented: ");
					String org = alquilerController.mostrarAlquileres();
					String ind = "\t" + org.replace("\n", "\n\t");
					System.out.println(ind + "\n");
				}
			}
		}
	}
}
