package com.videoclub.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class MultimediaDAO
{
	private final ArrayList<Multimedia> listMultimedia;

	public MultimediaDAO()
	{
		listMultimedia = new ArrayList<>();
	}

	@Override
	public String toString()
	{
		StringBuilder txt = new StringBuilder();

		for (Multimedia multimedia : listMultimedia)
		{
			txt.append(multimedia.toString()).append("\n\n");
		}

		return txt.toString();
	}

	public ArrayList<Multimedia> getListMultimedia()
	{
		return listMultimedia;
	}

	public Multimedia encontrarMultimedia(String title, String author)
	{
		for (Multimedia multimedia : listMultimedia)
		{
			if (multimedia.getTitulo().equalsIgnoreCase(title) && multimedia.getAutor().equalsIgnoreCase(author))
			{
				return multimedia;
			}
		}
		return null;
	}

	public void aniadirMultimedia(Multimedia multimedia)
	{
		listMultimedia.add(multimedia);
	}

	public void eliminarMultimedia(String title, String author)
	{
		Multimedia multimedia = encontrarMultimedia(title, author);

		if (multimedia != null)
		{
			listMultimedia.remove(multimedia);
		}
		else
		{
			throw new RuntimeException("Multimedia Not Found");
		}
	}

	public ArrayList<Cancion> obtenerCancionesPorDuracion(Disco disco)
	{
		ArrayList<Cancion> canciones = disco.getListSongs();

		canciones.sort(Comparator.comparingInt(Cancion::getDuracion));

		return canciones;
	}

	public ArrayList<Videojuego> obtenerTodosLosVideojuegos()
	{
		ArrayList<Videojuego> videojuegos = new ArrayList<>();

		for (Multimedia multimedia : listMultimedia)
		{
			if (multimedia instanceof Videojuego)
			{
				videojuegos.add((Videojuego) multimedia);
			}
		}
		return videojuegos;
	}


	public ArrayList<Videojuego> obtenerVideojuegosOrdenadosPorAnio()
	{
		ArrayList<Videojuego> videojuegos = obtenerTodosLosVideojuegos();
		videojuegos.sort(Comparator.comparingInt(Videojuego::getAnio));

		return videojuegos;
	}

	public ArrayList<Pelicula> listarPeliculasTitulo()
	{
		ArrayList<Pelicula> listPeliculasTitulo = new ArrayList<>();
		ArrayList<Multimedia> copyListMultimedia = listMultimedia;
		Collections.sort(listMultimedia);

		for (int i = 0; i < copyListMultimedia.size(); i++)
		{
			if (copyListMultimedia.get(i) instanceof Pelicula)
			{
				listPeliculasTitulo.add(((Pelicula)copyListMultimedia.get(i)));
			}
		}

		return listPeliculasTitulo;
	}

	public ArrayList<Pelicula> todosLasPeliculas()
	{
		ArrayList<Pelicula> peliculas = new ArrayList<>();

		for (Multimedia multimedia : listMultimedia)
		{
			if (multimedia instanceof Pelicula)
			{
				peliculas.add((Pelicula) multimedia);
			}
		}
		return peliculas;
	}

	public ArrayList<Multimedia> filtroPorTitulo(String titulo)
	{
		ArrayList<Multimedia> listMultimedia = new ArrayList<>();

		for (Multimedia multimedia : this.listMultimedia)
		{
			if (multimedia.getTitulo().equals(titulo))
			{
				listMultimedia.add(multimedia);
			}
		}

		return listMultimedia;
	}

	public ArrayList<Multimedia> filtroPorAutor(String autor)
	{
		ArrayList<Multimedia> listMultimedia = new ArrayList<>();

		for (Multimedia multimedia : this.listMultimedia)
		{
			if (multimedia.getAutor().equals(autor))
			{
				listMultimedia.add(multimedia);
			}
		}

		return listMultimedia;
	}
}