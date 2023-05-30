/**
 * The `CancionController` class is responsible for managing the operations related to songs.
 */
package com.videoclub.controller;

import com.videoclub.model.*;

import java.util.ArrayList;

public class CancionController {
	CancionDAO cancionDAO;

	/**
	 * Constructs a new `CancionController` object and initializes the `CancionDAO`.
	 */
	public CancionController() {
		cancionDAO = new CancionDAO();
	}

	/**
	 * Adds a new song with the given name and duration to the database.
	 *
	 * @param nombre   The name of the song.
	 * @param duracion The duration of the song.
	 */
	public void altaCancion(String nombre, int duracion) {
		Cancion cancion = new Cancion(nombre, duracion);
		cancionDAO.aniadirCancion(cancion);
	}

	/**
	 * Returns a list of all songs in the database.
	 *
	 * @return An ArrayList of Cancion objects representing the songs.
	 */
	public ArrayList<Cancion> returnCancion() {
		return cancionDAO.getListCancion();
	}

	/**
	 * Retrieves a list of songs from the database that belong to the specified disco and have the specified duration.
	 *
	 * @param disco The disco to filter the songs by.
	 * @return An ArrayList of Cancion objects matching the specified criteria.
	 */
	public ArrayList<Cancion> obtenerCancionesPorDuracion(Disco disco) {
		return cancionDAO.obtenerCancionesPorDuracion(disco);
	}

	/**
	 * Retrieves an array of names of all songs in the database.
	 *
	 * @return A String array containing the names of the songs.
	 */
	public String[] obtenerCancionesNombre() {
		return cancionDAO.obtenerCancionesNombre();
	}

	/**
	 * Filters the songs in the database by the specified name and returns the matching Cancion object.
	 *
	 * @param nombre The name to filter the songs by.
	 * @return The Cancion object matching the specified name, or null if not found.
	 */
	public Cancion filtroCancionPorNombre(String nombre) {
		return cancionDAO.filtroCancionPorNombre(nombre);
	}

	/**
	 * Removes a song from the database with the given name and duration.
	 *
	 * @param nombre   The name of the song to be removed.
	 * @param duracion The duration of the song to be removed.
	 */
	public void darBajaCancion(String nombre, int duracion) {
		cancionDAO.eliminarCancion(nombre, duracion);
	}
}