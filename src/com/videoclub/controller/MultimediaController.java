package com.videoclub.controller;

import com.videoclub.model.Multimedia;
import com.videoclub.model.MultimediaDAO;
import com.videoclub.model.Pelicula;
import com.videoclub.model.Videojuego;

import java.util.ArrayList;

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
		Videojuego videoJuego = new Videojuego(title, author, format, year, platform);
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
	public ArrayList<String> mostrarTituloMultimedia()
	{
		return multimediaDAO.mostrarTituloMultimedia();
	}

	public ArrayList<String> multimediasDisponibles()
	{
		ArrayList<String> strings = new ArrayList<>();
		String[][] strings2 = multimediaDAO.devolverListMultimedia();

		for (int x = 0; x < strings2.length; x++)
		{
			String var = strings2[x][0];
			String var2 = strings2[x][1];
			String var3 = strings2[x][2];
			String var4 = strings2[x][3];
			String var5 = strings2[x][4];

			String join = var + var2 + var3 + var4 + var5;

			strings.add(join);
		}

		return strings;
	}

	public ArrayList<String> multimediasDisponiblesID()
	{
		ArrayList<String> strings = new ArrayList<>();
		String[][] strings2 = multimediaDAO.devolverListMultimedia();

		for (int x = 0; x < strings2.length; x++)
		{
			String var = strings2[x][0];
			String var2 = strings2[x][1];

			String join = var + "||" +  var2;

			strings.add(join);
		}

		return strings;
	}
}
