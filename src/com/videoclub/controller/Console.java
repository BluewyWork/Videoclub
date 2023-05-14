package com.videoclub.controller;

import com.videoclub.lib.Input;
import com.videoclub.model.Movie;
import com.videoclub.model.Multimedia;
import com.videoclub.model.Rent;
import com.videoclub.model.VideoGame;
import com.videoclub.view.ConsoleView;

import java.util.ArrayList;

public class Console
{
	public static void main(String[] args)
	{
		ConsoleView consoleView = new ConsoleView();
		MemberController memberController = new MemberController();
		MultimediaController multimediaController = new MultimediaController();
		RentController rentController = new RentController();

		boolean exit = false;
		int userInput = 9;

		while (!exit)
		{
			consoleView.menuPrincipal();
			userInput = Input.readInput("Option: ", "int");

			switch (userInput)
			{
				case 0 -> exit = true;
				case 1 ->
				{
					consoleView.menuAltas();
					userInput = Input.readInput("Option: ", "int");

					String title = Input.readInput("Titulo: ", "String");
					String author = Input.readInput("Autor: ", "String");
					String format = Input.readInput("Formato: ", "String");
					int year = Input.readInput("Año: ", "int");

					switch (userInput)
					{


						case 1 ->
						{
							String nif = Input.readInput("NIF: ", "String");
							String name = Input.readInput("Name: ", "String");
							String birthDate = Input.readInput("Birth Date (dd/mm/yyyy): ");
							String town = Input.readInput("Town: ", "String");

							memberController.registerMember(nif, name, birthDate, town);
						}
						case 2 ->
						{
							int duration = Input.readInput("Duration:  ", "int");
							String maleLead = Input.readInput("Male Lead: ", "String");
							String femaleLead = Input.readInput("Female Lead: ", "String");

							multimediaController.storeMovie(title, author, format, year, duration, maleLead, femaleLead);
						}
						case 3 ->
						{
							String platform = Input.readInput("Plataforma: ");

							multimediaController.storeVideoGame(title, author, format, year, platform);
						}
					}
				}
				case 2 ->
				{
					System.out.println(memberController.showMembers());
					String memberNIF = Input.readInput("NIF: ", "String");

					ArrayList<Multimedia> listMultimedia = new ArrayList<>();

					boolean addMore = true;

					while (addMore)
					{
						System.out.println(multimediaController.showMultimedias());
						String title = Input.readInput("Title: ", "String");
						String author = Input.readInput("Author: ", "String");

						Multimedia multimedia = multimediaController.retrieveMultimedia(title, author);
						listMultimedia.add(multimedia);

						addMore = Input.readInput("Add more? [true/false] ", "boolean");
					}


					rentController.rentMultimedias(memberNIF, listMultimedia);
				}
				case 3 ->
				{
					System.out.println(rentController.showRents());
					int id = Input.readInput("ID: ", "int");

					Rent rent = rentController.releaseRent(id);
					ArrayList<Multimedia> listMultimedia = rent.getArrayListMultimedia();

					multimediaController.storeMultimedias(listMultimedia);
				}
				case 4 ->
				{
					System.out.println("In Stock: ");
					System.out.println("\t" + multimediaController.showMultimedias() + "\n");

					System.out.println("Rented: ");
					System.out.println("\t" + rentController.showRents() + "\n");
				}
			}
		}
	}
}
