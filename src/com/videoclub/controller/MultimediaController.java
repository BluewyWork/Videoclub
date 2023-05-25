package com.videoclub.controller;

import com.videoclub.model.*;

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

	public void altaDisco(String nombre, ArrayList<Cancion> listCanciones)
	{
		Disco disco = new Disco(nombre, listCanciones);
		multimediaDAO.aniadirMultimedia(disco);
	}

	public void storeDisc()
	{
		throw new UnsupportedOperationException();
	}

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

	public ArrayList<Multimedia> returnStuff()
	{
		return multimediaDAO.getListMultimedia();
	}

	public ArrayList<Multimedia> filtroPorTitulo(String titulo)
	{
		return multimediaDAO.filtroPorTitulo(titulo);
	}

	public ArrayList<Multimedia> filtroPorAutor(String autor)
	{
		return multimediaDAO.filtroPorAutor(autor);
	}

	public ArrayList<Pelicula> listarPeliculasTitulo()
	{
		return multimediaDAO.listarPeliculasTitulo();
	}

	public ArrayList<Pelicula> todosLosPelis()
	{
		return multimediaDAO.todosLasPeliculas();
	}

	public ArrayList<Cancion> obtenerCancionesPorDuracion(Disco disco)
	{
		return multimediaDAO.obtenerCancionesPorDuracion(disco);
	}

	public ArrayList<Videojuego> obtenerVideojuegosOrdenadosPorAnio()
	{
		return multimediaDAO.obtenerVideojuegosOrdenadosPorAnio();
	}
}
