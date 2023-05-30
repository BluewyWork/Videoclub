/**
 * The `MultimediaController` class is responsible for managing the operations related to multimedia items
 * such as movies, video games, and discs.
 */
package com.videoclub.controller;

import com.videoclub.model.*;

import java.util.ArrayList;

public class MultimediaController {
	MultimediaDAO multimediaDAO;

	/**
	 * Constructs a new `MultimediaController` object and initializes the `MultimediaDAO`.
	 */
	public MultimediaController() {
		multimediaDAO = new MultimediaDAO();
	}

	/**
	 * Adds a new movie to the database with the given details.
	 *
	 * @param title      The title of the movie.
	 * @param author     The author/director of the movie.
	 * @param format     The format of the movie.
	 * @param year       The release year of the movie.
	 * @param duration   The duration of the movie.
	 * @param maleLead   The male lead actor in the movie.
	 * @param femaleLead The female lead actor in the movie.
	 */
	public void altaPelicula(String title, String author, String format, int year, int duration, String maleLead, String femaleLead) {
		Pelicula pelicula = new Pelicula(title, author, format, year, duration, maleLead, femaleLead);
		multimediaDAO.aniadirMultimedia(pelicula);
	}

	/**
	 * Adds a new video game to the database with the given details.
	 *
	 * @param title    The title of the video game.
	 * @param author   The author/developer of the video game.
	 * @param format   The format of the video game.
	 * @param year     The release year of the video game.
	 * @param platform The platform(s) on which the video game is available.
	 */
	public void altaVideojuego(String title, String author, String format, int year, String platform) {
		Videojuego videoJuego = new Videojuego(title, author, format, year, platform);
		multimediaDAO.aniadirMultimedia(videoJuego);
	}

	/**
	 * Adds a new disc to the database with the given details.
	 *
	 * @param titulo        The title of the disc.
	 * @param autor         The author/artist of the disc.
	 * @param formato       The format of the disc.
	 * @param anio          The release year of the disc.
	 * @param listCanciones The list of songs on the disc.
	 */
	public void altaDisco(String titulo, String autor, String formato, int anio, ArrayList<Cancion> listCanciones) {
		Disco disco = new Disco(titulo, autor, formato, anio, listCanciones);
		multimediaDAO.aniadirMultimedia(disco);
	}

	/**
	 * Stores a disc in the system.
	 * TODO: This method is not implemented. Implementation is missing.
	 */
	public void storeDisc() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Adds a multimedia item to the database.
	 *
	 * @param multimedia The multimedia item to be added.
	 */
	public void guardarMultimedia(Multimedia multimedia) {
		multimediaDAO.aniadirMultimedia(multimedia);
	}

	/**
	 * Retrieves a multimedia item from the database based on the title and author.
	 * The item is removed from the database after retrieval.
	 *
	 * @param titulo The title of the multimedia item.
	 * @param autor  The author of the multimedia item.
	 * @return The retrieved multimedia item, or null if not found.
	 */
	public Multimedia recuperarMultimedia(String titulo, String autor) {
		Multimedia multimedia = multimediaDAO.encontrarMultimedia(titulo, autor);
		multimediaDAO.eliminarMultimedia(titulo, autor);
		return multimedia;
	}

	/**
	 * Returns a list of all multimedia items in the database.
	 *
	 * @return An ArrayList of Multimedia objects representing the items.
	 */
	public ArrayList<Multimedia> returnStuff() {
		return multimediaDAO.getListMultimedia();
	}

	/**
	 * Filters multimedia items in the database by the specified title and returns the matching items.
	 *
	 * @param titulo The title to filter the items by.
	 * @return An ArrayList of Multimedia objects matching the specified title.
	 */
	public ArrayList<Multimedia> filtroPorTitulo(String titulo) {
		return multimediaDAO.filtroPorTitulo(titulo);
	}

	/**
	 * Filters multimedia items in the database by the specified author and returns the matching items.
	 *
	 * @param autor The author to filter the items by.
	 * @return An ArrayList of Multimedia objects matching the specified author.
	 */
	public ArrayList<Multimedia> filtroPorAutor(String autor) {
		return multimediaDAO.filtroPorAutor(autor);
	}

	/**
	 * Filters discs in the database by the specified title and returns the matching Disco object.
	 *
	 * @param titulo The title to filter the discs by.
	 * @return The Disco object matching the specified title, or null if not found.
	 */
	public Disco filtroDiscoPorTitulo(String titulo) {
		return multimediaDAO.filtroDiscoPorTitulo(titulo);
	}

	/**
	 * Retrieves a list of movies from the database, ordered by title.
	 *
	 * @return An ArrayList of Pelicula objects representing the movies.
	 */
	public ArrayList<Pelicula> obtenerPeliculasOrdenadosPorTitulo() {
		return multimediaDAO.obtenerPeliculasOrdenadosPorTitulo();
	}

	/**
	 * Retrieves a list of video games from the database, ordered by release year.
	 *
	 * @return An ArrayList of Videojuego objects representing the video games.
	 */
	public ArrayList<Videojuego> obtenerVideojuegosOrdenadosPorAnio() {
		return multimediaDAO.obtenerVideojuegosOrdenadosPorAnio();
	}

	/**
	 * Retrieves a list of all movies in the database.
	 *
	 * @return An ArrayList of Pelicula objects representing the movies.
	 */
	public ArrayList<Pelicula> todosLosPelis() {
		return multimediaDAO.obtenerTodasLasPeliculas();
	}

	/**
	 * Retrieves a list of all video games in the database.
	 *
	 * @return An ArrayList of Videojuego objects representing the video games.
	 */
	public ArrayList<Videojuego> todosLosVideojuegos() {
		return multimediaDAO.obtenerTodosLosVideojuegos();
	}

	/**
	 * Retrieves a list of all discs in the database.
	 *
	 * @return An ArrayList of Disco objects representing the discs.
	 */
	public ArrayList<Disco> todosLosDiscos() {
		return multimediaDAO.obtenerTodosLosDiscos();
	}

	/**
	 * Retrieves an array of titles of all discs in the database.
	 *
	 * @return A String array containing the titles of the discs.
	 */
	public String[] obtenerDiscosTitulo() {
		return multimediaDAO.obtenerDiscosTitulo();
	}

	/**
	 * Adds a song to a disc in the database.
	 *
	 * @param cancion The song to be added.
	 * @param disco   The disc to which the song should be added.
	 */
	public void aniadirCancionToDisco(Cancion cancion, Disco disco) {
		multimediaDAO.aniadirCancionToDisco(cancion, disco);
	}

	/**
	 * Removes a multimedia item from the database based on the title and author.
	 *
	 * @param titulo The title of the multimedia item to be removed.
	 * @param autor  The author of the multimedia item to be removed.
	 */
	public void darBajaMultimedia(String titulo, String autor) {
		multimediaDAO.eliminarMultimedia(titulo, autor);
	}
}
