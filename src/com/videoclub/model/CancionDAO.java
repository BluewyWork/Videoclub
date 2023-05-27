package com.videoclub.model;

import java.util.ArrayList;
import java.util.Comparator;

public class CancionDAO
{
	private final ArrayList<Cancion> listCancion;

	public CancionDAO()
	{
		listCancion = new ArrayList<>();
	}

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

	public ArrayList<Cancion> getListCancion()
	{
		return listCancion;
	}

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

	public void aniadirCancion(Cancion cancion)
	{
		listCancion.add(cancion);
	}

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

	public ArrayList<Cancion> obtenerCancionesPorDuracion(Disco disco)
	{
		ArrayList<Cancion> canciones = disco.getListSongs();

		canciones.sort(Comparator.comparingInt(Cancion::getDuracion));

		return canciones;
	}
}
