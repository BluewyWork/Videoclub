package com.videoclub.model;

import java.util.ArrayList;

/**
 * Esta clase representa un disco en el sistema de videoclub. Extiende la clase Multimedia y agrega funcionalidades específicas para los discos.
 */
public class Disco extends Multimedia
{
	private double duracion;
	private ArrayList<Cancion> listaCanciones;

	/**
	 * Crea una nueva instancia de la clase Disco con el título, autor, formato y año especificados, y una lista de canciones.
	 *
	 * @param titulo          El título del disco.
	 * @param autor           El autor del disco.
	 * @param formato         El formato del disco.
	 * @param anio            El año de lanzamiento del disco.
	 * @param listCanciones   La lista de canciones del disco.
	 */
	public Disco(String titulo, String autor, String formato, int anio, ArrayList<Cancion> listCanciones)
	{
		super(titulo, autor, formato, anio);
		setListSongs(listCanciones);
		setDuration();
	}

	/**
	 * Devuelve una representación en forma de cadena del disco.
	 *
	 * @return La representación en forma de cadena del disco.
	 */
	@Override
	public String toString()
	{
		return super.toString() + "\n" +
				"\t" + "Duracion: " + duracion +
				"\t" + "Canciones: '" + listaCanciones + '\'';
	}

	/**
	 * Calcula el precio de alquiler del disco.
	 *
	 * @return El precio de alquiler del disco.
	 */
	@Override
	public double calcularPrecioAlquiler()
	{
		if (duracion < 30)
		{
			return Constantes.BASE_PRICE - 1;
		}
		else
		{
			return Constantes.BASE_PRICE;
		}
	}

	/**
	 * Devuelve la duración total del disco en minutos.
	 *
	 * @return La duración total del disco en minutos.
	 */
	public double getDuracion()
	{
		return duracion;
	}

	/**
	 * Calcula y establece la duración total del disco en minutos sumando las duraciones de todas las canciones.
	 */
	public void setDuration()
	{
		for (Cancion a : listaCanciones)
		{
			duracion += a.getDuracion();
		}
	}

	/**
	 * Devuelve la lista de canciones del disco.
	 *
	 * @return La lista de canciones del disco.
	 */
	public ArrayList<Cancion> getListaCanciones()
	{
		return listaCanciones;
	}

	/**
	 * Establece la lista de canciones del disco.
	 *
	 * @param listaCanciones La lista de canciones a establecer.
	 */
	public void setListaCanciones(ArrayList<Cancion> listaCanciones)
	{
		this.listaCanciones = listaCanciones;
	}

	/**
	 * Devuelve la lista de canciones del disco.
	 *
	 * @return La lista de canciones del disco.
	 * @deprecated Usar el método getListaCanciones() en su lugar.
	 */
	@Deprecated
	public ArrayList<Cancion> getListSongs()
	{
		return listaCanciones;
	}

	/**
	 * Establece la lista de canciones del disco.
	 *
	 * @param listaCanciones La lista de canciones a establecer.
	 * @deprecated Usar el método setListaCanciones(ArrayList<Cancion>) en su lugar.
	 */
	@Deprecated
	public void setListSongs(ArrayList<Cancion> listaCanciones)
	{
		this.listaCanciones = listaCanciones;
	}

	/**
	 * Agrega una canción a la lista de canciones del disco.
	 *
	 * @param cancion La canción a agregar.
	 */
	public void addCancion(Cancion cancion)
	{
		listaCanciones.add(cancion);
	}
}
