package com.videoclub.model;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Esta clase representa un DAO (Objeto de Acceso a Datos) para las canciones en el sistema de videoclub.
 * Permite realizar operaciones relacionadas con las canciones, como agregar, eliminar, buscar y obtener información sobre ellas.
 */
public class CancionDAO
{
	private final ArrayList<Cancion> listCancion;

	/**
	 * Crea una nueva instancia de la clase CancionDAO.
	 * Inicializa la lista de canciones.
	 */
	public CancionDAO()
	{
		listCancion = new ArrayList<>();
	}

	/**
	 * Devuelve una representación en forma de cadena de todas las canciones en el DAO.
	 *
	 * @return La representación en forma de cadena de todas las canciones en el DAO.
	 */
	@Override
	public String toString()
	{
		StringBuilder txt = new StringBuilder();

		for (Cancion cancion : listCancion)
		{
			txt.append(cancion.toString()).append("\n\n");
		}

		return txt.toString();
	}

	/**
	 * Devuelve la lista de canciones en el DAO.
	 *
	 * @return La lista de canciones en el DAO.
	 */
	public ArrayList<Cancion> getListCancion()
	{
		return listCancion;
	}

	/**
	 * Busca una canción en el DAO por su nombre y duración.
	 *
	 * @param nombre   El nombre de la canción a buscar.
	 * @param duracion La duración de la canción a buscar.
	 * @return La canción encontrada, o null si no se encontró ninguna canción con los criterios especificados.
	 */
	public Cancion encontrarCancion(String nombre, int duracion)
	{
		for (Cancion cancion : listCancion)
		{
			if (cancion.getNombre().equalsIgnoreCase(nombre) && cancion.getDuracion() == duracion)
			{
				return cancion;
			}
		}
		return null;
	}

	/**
	 * Agrega una canción al DAO.
	 *
	 * @param cancion La canción a agregar.
	 */
	public void aniadirCancion(Cancion cancion)
	{
		listCancion.add(cancion);
	}

	/**
	 * Elimina una canción del DAO por su nombre y duración.
	 *
	 * @param nombre   El nombre de la canción a eliminar.
	 * @param duracion La duración de la canción a eliminar.
	 * @throws RuntimeException si la canción no se encuentra en el DAO.
	 */
	public void eliminarCancion(String nombre, int duracion)
	{
		Cancion cancion = encontrarCancion(nombre, duracion);

		if (cancion != null)
		{
			listCancion.remove(cancion);
		}
		else
		{
			throw new RuntimeException("Cancion Not Found");
		}
	}

	/**
	 * Obtiene una lista de canciones ordenadas por duración para un disco específico.
	 *
	 * @param disco El disco para el cual se desea obtener la lista de canciones ordenadas por duración.
	 * @return Una lista de canciones ordenadas por duración para el disco especificado.
	 */
	public ArrayList<Cancion> obtenerCancionesPorDuracion(Disco disco)
	{
		ArrayList<Cancion> canciones = disco.getListSongs();

		canciones.sort(Comparator.comparingInt(Cancion::getDuracion));

		return canciones;
	}

	/**
	 * Obtiene una lista de nombres de canciones.
	 *
	 * @return Una matriz de cadenas que contiene los nombres de todas las canciones en el DAO.
	 */
	public String[] obtenerCancionesNombre()
	{
		String[] cancionNameList = new String[getListCancion().size()];

		for (int i = 0; i < getListCancion().size(); i++)
		{
			cancionNameList[i] = getListCancion().get(i).getNombre();
		}

		return cancionNameList;
	}

	/**
	 * Filtra una canción en el DAO por su nombre.
	 *
	 * @param nombre El nombre de la canción a filtrar.
	 * @return La canción encontrada, o null si no se encontró ninguna canción con el nombre especificado.
	 */
	public Cancion filtroCancionPorNombre(String nombre)
	{
		ArrayList<Cancion> listCancion = getListCancion();
		Cancion cancion = null;

		for (Cancion cancionAux : listCancion)
		{
			if (nombre.equals(cancionAux.getNombre()))
				cancion = cancionAux;
		}
		return cancion;
	}

	/**
	 * Guarda las canciones en un disco.
	 *
	 * @param disco El disco en el cual se guardarán las canciones.
	 * @return Una lista de canciones guardadas en el disco.
	 */
	public ArrayList<Cancion> guardarCancionesEnDisco(Disco disco)
	{
		ArrayList<Cancion> cancionesDelDisco = new ArrayList<>();

		for (Cancion cancion : listCancion)
		{
			if (cancion.getTitulo().equals(disco.getTitulo()) && cancion.getAutor().equals(disco.getAutor()))
			{
				cancionesDelDisco.add(cancion);
			}
		}

		disco.setListaCanciones(cancionesDelDisco);
		return cancionesDelDisco;
	}
}
