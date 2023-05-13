package com.videoclub.controller;

import com.videoclub.lib.Input;
import com.videoclub.model.Multimedia;
import com.videoclub.model.Rent;
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

					switch (userInput)
					{
						case 1 -> memberController.registerMember();
						case 2 -> multimediaController.storeMultimedia("movie");
						case 3 -> multimediaController.storeMultimedia("videogame");
					}
				}
				case 2 ->
				{
					System.out.println(memberController.showMembers());
					String memberNIF = Input.readInput("NIF: ", "String");

					System.out.println(multimediaController.showMultimedias());
					String title = Input.readInput("Title: ", "String");
					String author = Input.readInput("Author: ", "String");

					Multimedia multimedia = multimediaController.retrieveMultimedia(title, author);
					rentController.rentMultimedia(memberNIF, multimedia);
				}
				case 3 ->
				{
					System.out.println(rentController.showRents());
					int id = Input.readInput("ID: ", "int");

					Rent rent = rentController.returnRent(id);
					ArrayList<Multimedia> listMultimedia = rent.getArrayListMultimedia();

					multimediaController.storeMultimedias(listMultimedia);
				}
			}
		}
	}
}
