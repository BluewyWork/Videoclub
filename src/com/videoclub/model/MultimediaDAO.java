package com.videoclub.model;

import com.videoclub.util.VideojuegoComparator;

import java.util.ArrayList;
import java.util.Collections;

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

	public Multimedia encontrarMultimedia(String titulo, String autor)
	{
		for (Multimedia multimedia : listMultimedia)
		{
			if (multimedia.getTitulo().equalsIgnoreCase(titulo) && multimedia.getAutor().equalsIgnoreCase(autor))
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

	public void eliminarMultimedia(String titulo, String autor)
	{
		Multimedia multimedia = encontrarMultimedia(titulo, autor);

		if (multimedia != null)
		{
			listMultimedia.remove(multimedia);
		}
		else
		{
			throw new RuntimeException("Multimedia Not Found");
		}
	}

	public ArrayList<Videojuego> obtenerVideojuegosOrdenadosPorAnio() {
		ArrayList<Videojuego> videojuegos = obtenerTodosLosVideojuegos();
		videojuegos.sort(new VideojuegoComparator());

		return videojuegos;
	}

	public ArrayList<Pelicula> obtenerPeliculasOrdenadosPorTitulo()
	{
		ArrayList<Pelicula> listPeliculasTitulo = obtenerTodasLasPeliculas();
		Collections.sort(listPeliculasTitulo);

		return listPeliculasTitulo;
	}

	public ArrayList<Pelicula> obtenerTodasLasPeliculas()
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

	public ArrayList<Disco> obtenerTodosLosDiscos()
	{
		ArrayList<Disco> discos = new ArrayList<>();

		for (Multimedia multimedia : listMultimedia)
		{
			if (multimedia instanceof Disco)
			{
				discos.add((Disco) multimedia);
			}
		}
		return discos;
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

	public Disco filtroDiscoPorTitulo(String titulo)
	{
		ArrayList<Disco> listDisco = obtenerTodosLosDiscos();
		Disco disco = null;

		for (Disco discoAux : listDisco)
		{
			if (titulo.equals(discoAux.getTitulo()))
				disco = discoAux;
		}
		return disco;
	}

	public String[] obtenerDiscosTitulo()
	{
		String[] discoNameList = new String[obtenerTodosLosDiscos().size()];

		for (int i = 0; i < obtenerTodosLosDiscos().size(); i++)
		{
			discoNameList[i] = obtenerTodosLosDiscos().get(i).getTitulo();
		}

		return discoNameList;
	}

	public void aniadirCancionToDisco(Cancion cancion, Disco disco)
	{
		disco.addCancion(cancion);
	}
}