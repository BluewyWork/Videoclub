package com.videoclub.controller;

import com.videoclub.lib.Input;
import com.videoclub.model.Movie;
import com.videoclub.model.Multimedia;
import com.videoclub.model.MultimediaDAO;
import com.videoclub.model.VideoGame;

import java.util.ArrayList;
import java.util.jar.JarEntry;

public class MultimediaController
{
	MultimediaDAO multimediaDAO;

	public MultimediaController()
	{
		multimediaDAO = new MultimediaDAO();
	}

	public void storeMovie(String title, String author, String format, int year, int duration, String maleLead, String femaleLead)
	{
		Movie movie = new Movie(title, author, format, year, duration, maleLead, femaleLead);
		multimediaDAO.addMultimedia(movie);
	}

	public void storeVideoGame(String title, String author, String format, int year, String platform)
	{
		VideoGame videoGame = new VideoGame(title, author, format, year, platform);
		multimediaDAO.addMultimedia(videoGame);
	}

	public void storeDisc()
	{
		throw new UnsupportedOperationException();
	}

	// works cause it is involved in 1:M relationship
	public void storeMultimedias(ArrayList<Multimedia> listMultimedia)
	{
		for (Multimedia multimedia : listMultimedia)
		{
			multimediaDAO.addMultimedia(multimedia);
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
