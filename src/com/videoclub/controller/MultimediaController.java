package com.videoclub.controller;

import com.videoclub.lib.*;
import com.videoclub.model.*;

public class MultimediaController
{
	MultimediaDAO multimediaDAO;

	public MultimediaController()
	{
		multimediaDAO = new MultimediaDAO();
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
				multimediaDAO.addMultimedia(movie);
			}
			case "videogame" ->
			{
				String platform = Input.readInput("Plataforma: ");

				VideoGame videoGame = new VideoGame(title, author, format, year, platform);
				multimediaDAO.addMultimedia(videoGame);
			}
		}
	}

	public Multimedia retrieveMultimedia(String title, String author)
	{
		Multimedia multimedia = multimediaDAO.findMultimedia(title, author);

		multimediaDAO.eraseMultimedia(title, author);

		return multimedia;
	}

	public String showMultimedias()
	{
		return multimediaDAO.toString();
	}
}
