package com.videoclub.controller;

import com.videoclub.model.Multimedia;
import com.videoclub.model.MultimediaDAO;
import com.videoclub.model.Pelicula;
import com.videoclub.model.VideoJuego;

public class MultimediaController
{
	MultimediaDAO multimediaDAO;

	public MultimediaController()
	{
		multimediaDAO = new MultimediaDAO();
	}

	public void altaPelicula(String title, String author, String format, int year, int duration, String maleLead, String femaleLead)
	{
		Pelicula pelicula = new Pelicula(title, author, format, year, duration, maleLead, femaleLead);
		multimediaDAO.aniadirMultimedia(pelicula);
	}

	public void altaVideojuego(String title, String author, String format, int year, String platform)
	{
		VideoJuego videoJuego = new VideoJuego(title, author, format, year, platform);
		multimediaDAO.aniadirMultimedia(videoJuego);
	}

	public void storeDisc()
	{
		throw new UnsupportedOperationException();
	}

	// works cause it is involved in 1:M relationship
	public void guardarMultimedia(Multimedia multimedia)
	{
		multimediaDAO.aniadirMultimedia(multimedia);
	}

	public Multimedia recuperarMultimedias(String title, String author)
	{
		Multimedia multimedia = multimediaDAO.encontrarMultimedia(title, author);

		multimediaDAO.eliminarMultimedia(title, author);
		
		return multimedia;
	}

	public String mostrarMultimedias()
	{
		return multimediaDAO.toString();
	}
}
