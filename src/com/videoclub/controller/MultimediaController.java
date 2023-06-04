/**
 La clase MultimediaController se encarga de gestionar las operaciones relacionadas con elementos multimedia, como
 películas, videojuegos y discos.
 */
package com.videoclub.controller;

import com.videoclub.model.*;

import java.util.ArrayList;

public class MultimediaController
{
	MultimediaDAO multimediaDAO;

	/**
	 * Constructor de la clase `MultimediaController` que inicializa el `MultimediaDAO`.
	 */
	public MultimediaController()
	{
		multimediaDAO = new MultimediaDAO();
	}

	/**
	 * Agrega una nueva película a la base de datos con los detalles proporcionados.
	 *
	 * @param title      El título de la película.
	 * @param author     El autor/director de la película.
	 * @param format     El formato de la película.
	 * @param year       El año de lanzamiento de la película.
	 * @param duration   La duración de la película.
	 * @param maleLead   El actor principal masculino en la película.
	 * @param femaleLead La actriz principal femenina en la película.
	 */
	public void altaPelicula(String title, String author, String format, int year, int duration, String maleLead, String femaleLead)
	{
		Pelicula pelicula = new Pelicula(title, author, format, year, duration, maleLead, femaleLead);
		multimediaDAO.aniadirMultimedia(pelicula);
	}

	/**
	 * Agrega un nuevo videojuego a la base de datos con los detalles proporcionados.
	 *
	 * @param title    El título del videojuego.
	 * @param author   El autor/desarrollador del videojuego.
	 * @param format   El formato del videojuego.
	 * @param year     El año de lanzamiento del videojuego.
	 * @param platform La(s) plataforma(s) en las que está disponible el videojuego.
	 */
	public void altaVideojuego(String title, String author, String format, int year, String platform)
	{
		Videojuego videoJuego = new Videojuego(title, author, format, year, platform);
		multimediaDAO.aniadirMultimedia(videoJuego);
	}

	/**
	 * Agrega un nuevo disco a la base de datos con los detalles proporcionados.
	 *
	 * @param titulo        El título del disco.
	 * @param autor         El autor/artista del disco.
	 * @param formato       El formato del disco.
	 * @param anio          El año de lanzamiento del disco.
	 * @param listCanciones La lista de canciones en el disco.
	 */
	public void altaDisco(String titulo, String autor, String formato, int anio, ArrayList<Cancion> listCanciones)
	{
		Disco disco = new Disco(titulo, autor, formato, anio, listCanciones);
		multimediaDAO.aniadirMultimedia(disco);
	}

	/**
	 * Almacena un disco en el sistema.
	 * TODO: Este método no está implementado. Falta la implementación.
	 */
	public void storeDisc()
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * Agrega un elemento multimedia a la base de datos.
	 *
	 * @param multimedia El elemento multimedia que se va a agregar.
	 */
	public void guardarMultimedia(Multimedia multimedia)
	{
		multimediaDAO.aniadirMultimedia(multimedia);
	}

	/**
	 * Recupera un elemento multimedia de la base de datos según el título y autor. El elemento se elimina de la
	 * base de datos después de su recuperación.
	 *
	 * @param titulo El título del elemento multimedia.
	 * @param autor  El autor del elemento multimedia.
	 * @return El elemento multimedia recuperado, o null si no se encuentra.
	 */
	public Multimedia recuperarMultimedia(String titulo, String autor)
	{
		Multimedia multimedia = multimediaDAO.encontrarMultimedia(titulo, autor);
		multimediaDAO.eliminarMultimedia(titulo, autor);
		return multimedia;
	}

	/**
	 * Devuelve una lista de todos los elementos multimedia en la base de datos.
	 *
	 * @return Un ArrayList de objetos Multimedia que representan los elementos.
	 */
	public ArrayList<Multimedia> returnStuff()
	{
		return multimediaDAO.getListMultimedia();
	}

	/**
	 * Filtra los elementos multimedia en la base de datos por el título especificado y devuelve los elementos coincidentes.
	 *
	 * @param titulo El título para filtrar los elementos.
	 * @return Un ArrayList de objetos Multimedia que coinciden con el título especificado.
	 */
	public ArrayList<Multimedia> filtroPorTitulo(String titulo)
	{
		return multimediaDAO.filtroPorTitulo(titulo);
	}

	/**
	 * Filtra los elementos multimedia en la base de datos por el autor especificado y devuelve los elementos coincidentes.
	 *
	 * @param autor El autor para filtrar los elementos.
	 * @return Un ArrayList de objetos Multimedia que coinciden con el autor especificado.
	 */
	public ArrayList<Multimedia> filtroPorAutor(String autor)
	{
		return multimediaDAO.filtroPorAutor(autor);
	}

	/**
	 * Filtra los discos en la base de datos por el título especificado y devuelve el objeto Disco correspondiente.
	 *
	 * @param titulo El título para filtrar los discos.
	 * @return El objeto Disco que coincide con el título especificado, o null si no se encuentra.
	 */
	public Disco filtroDiscoPorTitulo(String titulo)
	{
		return multimediaDAO.filtroDiscoPorTitulo(titulo);
	}

	/**
	 * Recupera una lista de películas de la base de datos, ordenadas por título.
	 *
	 * @return Un ArrayList de objetos Pelicula que representan las películas.
	 */
	public ArrayList<Pelicula> obtenerPeliculasOrdenadosPorTitulo()
	{
		return multimediaDAO.obtenerPeliculasOrdenadosPorTitulo();
	}

	/**
	 * Recupera una lista de videojuegos de la base de datos, ordenados por año de lanzamiento.
	 *
	 * @return Un ArrayList de objetos Videojuego que representan los videojuegos.
	 */
	public ArrayList<Videojuego> obtenerVideojuegosOrdenadosPorAnio()
	{
		return multimediaDAO.obtenerVideojuegosOrdenadosPorAnio();
	}

	/**
	 * Recupera una lista de todas las películas en la base de datos.
	 *
	 * @return Un ArrayList de objetos Pelicula que representan las películas.
	 */
	public ArrayList<Pelicula> todosLosPelis()
	{
		return multimediaDAO.obtenerTodasLasPeliculas();
	}

	/**
	 * Recupera una lista de todos los videojuegos en la base de datos.
	 *
	 * @return Un ArrayList de objetos Videojuego que representan los videojuegos.
	 */
	public ArrayList<Videojuego> todosLosVideojuegos()
	{
		return multimediaDAO.obtenerTodosLosVideojuegos();
	}

	/**
	 * Recupera una lista de todos los discos en la base de datos.
	 *
	 * @return Un ArrayList de objetos Disco que representan los discos.
	 */
	public ArrayList<Disco> todosLosDiscos()
	{
		return multimediaDAO.obtenerTodosLosDiscos();
	}

	/**
	 * Recupera un array de títulos de todos los discos en la base de datos.
	 *
	 * @return Un array de tipo String que contiene los títulos de los discos.
	 */
	public String[] obtenerDiscosTitulo()
	{
		return multimediaDAO.obtenerDiscosTitulo();
	}

	/**
	 * Agrega una canción a un disco en la base de datos.
	 *
	 * @param cancion La canción que se va a agregar.
	 * @param disco   El disco al que se debe agregar la canción.
	 */
	public void aniadirCancionToDisco(Cancion cancion, Disco disco)
	{
		multimediaDAO.aniadirCancionToDisco(cancion, disco);
	}

	/**
	 * Elimina un elemento multimedia de la base de datos según el título y autor.
	 *
	 * @param titulo El título del elemento multimedia que se va a eliminar.
	 * @param autor  El autor del elemento multimedia que se va a eliminar.
	 */
	public void darBajaMultimedia(String titulo, String autor)
	{
		multimediaDAO.eliminarMultimedia(titulo, autor);
	}
}
