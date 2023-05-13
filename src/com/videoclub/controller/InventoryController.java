package com.videoclub.controller;

import com.videoclub.lib.*;
import com.videoclub.model.*;

public class InventoryController
{
	InventoryDAO inventoryDAO;

	public InventoryController()
	{
		inventoryDAO = new InventoryDAO();
	}

	public void storeMultimedia(String type)
	{
		String title = Input.readInput("Titulo: ", "String");
		String author = Input.readInput("Autor: ", "String");
		String format = Input.readInput("Formato: ", "String");
		int year = Input.readInput("Año: ", "int");

		switch (type)
		{
			default -> throw new RuntimeException("Type Is Not Valid");
			case  "movie" ->
			{
				int duration = Input.readInput("Duration:  ", "int");
				String maleLead = Input.readInput("Male Lead: ", "String");
				String femaleLead = Input.readInput("Female Lead: ", "String");

				Movie movie = new Movie(title, author, format, year, duration, maleLead, femaleLead);
				inventoryDAO.addMultimedia(movie);
			}
			case "videogame" ->
			{
				String platform = Input.readInput("Plataforma: ");

				VideoGame videoGame = new VideoGame(title, author, format, year, platform);
				inventoryDAO.addMultimedia(videoGame);
			}
		}
	}

	public Multimedia retrieveMultimedia(String title, String author)
	{
		Multimedia multimedia = inventoryDAO.findMultimedia(title, author);

		inventoryDAO.eraseMultimedia(title, author);

		return multimedia;
	}
}
