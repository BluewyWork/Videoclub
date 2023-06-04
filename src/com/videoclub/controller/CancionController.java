/**
 La clase CancionController se encarga de gestionar las operaciones relacionadas con las canciones.
 */
package com.videoclub.controller;

import com.videoclub.model.Cancion;
import com.videoclub.model.CancionDAO;
import com.videoclub.model.Disco;

import java.util.ArrayList;

public class CancionController
{
	CancionDAO cancionDAO;

	/**
	 * Constructor de `CancionController` e inicializa el `CancionDAO`.
	 */
	public CancionController()
	{
		cancionDAO = new CancionDAO();
	}

	/**
	 * Agrega una nueva canción con el nombre y duración proporcionados a la base de datos.
	 *
	 * @param nombre   El nombre de la canción.
	 * @param duracion La duración de la canción.
	 */
	public void altaCancion(String nombre, float duracion)
	{
		Cancion cancion = new Cancion(nombre, duracion);
		cancionDAO.aniadirCancion(cancion);
	}

	/**
	 * Devuelve una lista de todas las canciones en la base de datos.
	 *
	 * @return Un ArrayList de objetos Cancion que representan las canciones.
	 */
	public ArrayList<Cancion> returnCancion()
	{
		return cancionDAO.getListCancion();
	}

	/**
	 * Obtiene una lista de canciones de la base de datos que pertenecen al disco especificado y tienen la duración especificada.
	 *
	 * @param disco El disco para filtrar las canciones.
	 * @return Un ArrayList de objetos Cancion que coinciden con los criterios especificados.
	 */
	public ArrayList<Cancion> obtenerCancionesPorDuracion(Disco disco)
	{
		return cancionDAO.obtenerCancionesPorDuracion(disco);
	}

	/**
	 * Obtiene un array de nombres de todas las canciones en la base de datos.
	 *
	 * @return Un array de tipo String que contiene los nombres de las canciones.
	 */
	public String[] obtenerCancionesNombre()
	{
		return cancionDAO.obtenerCancionesNombre();
	}

	/**
	 * Filtra las canciones en la base de datos por el nombre especificado y devuelve el objeto Cancion correspondiente.
	 *
	 * @param nombre El nombre para filtrar las canciones.
	 * @return El objeto Cancion que coincide con el nombre especificado, o null si no se encuentra.
	 */
	public Cancion filtroCancionPorNombre(String nombre)
	{
		return cancionDAO.filtroCancionPorNombre(nombre);
	}

	/**
	 * Elimina una canción de la base de datos con el nombre y duración proporcionados.
	 *
	 * @param nombre   El nombre de la canción a eliminar.
	 * @param duracion La duración de la canción a eliminar.
	 */
	public void darBajaCancion(String nombre, float duracion)
	{
		cancionDAO.eliminarCancion(nombre, duracion);
	}
}