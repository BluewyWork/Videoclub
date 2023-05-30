package com.videoclub.model;

import com.videoclub.util.VideojuegoComparator;

import java.util.ArrayList;
import java.util.Collections;

public class MultimediaDAO
{
	/**
	 * atributos de la clase MultimediDAO
	 */
	private final ArrayList<Multimedia> listMultimedia;

	/**
	 * constructor por defecto
	 */
	public MultimediaDAO()
	{
		listMultimedia = new ArrayList<>();
	}

	/**
	 * override toString
	 * @return
	 */
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

	/**
	 * get del arrayList que devuelve las multimedias creadas
	 * @return
	 */
	public ArrayList<Multimedia> getListMultimedia()
	{
		return listMultimedia;
	}

	/**
	 * metodo para buscar multimedias, recibe dos parametros y comprueba si existe o no la multimedia comparando
	 * el titulo introducido y el autor introducidos con los existentes
	 * @param titulo
	 * @param autor
	 * @return
	 */
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

	/**
	 * metodo que añade multimedias credas al arrayList de multimedia
	 * @param multimedia
	 */
	public void aniadirMultimedia(Multimedia multimedia)
	{
		listMultimedia.add(multimedia);
	}

	/**
	 * método para eliminar una multimedia ya existente que recibe dos parámetros y los busca para eliminarlos o
	 * mostrar una excepcion si no se encuentra.
	 * @param titulo
	 * @param autor
	 */
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

	/**
	 * metodo que muestra un listado con los videojuegos existentes ordenados por anio
	 * @return
	 */
	public ArrayList<Videojuego> obtenerVideojuegosOrdenadosPorAnio() {
		ArrayList<Videojuego> videojuegos = obtenerTodosLosVideojuegos();
		videojuegos.sort(new VideojuegoComparator());

		return videojuegos;
	}

	/**
	 * metodo para mostrar la lista de películas en funcion de los titulos
	 * @return
	 */
	public ArrayList<Pelicula> obtenerPeliculasOrdenadosPorTitulo()
	{
		ArrayList<Pelicula> listPeliculasTitulo = obtenerTodasLasPeliculas();
		Collections.sort(listPeliculasTitulo);

		return listPeliculasTitulo;
	}

	/**
	 * metodo para mostrar todas las peliculas existentes
	 * @return
	 */
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

	/**
	 * metodo que muestra un listado con todos los videojuegos creados
	 * @return
	 */
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

	/**
	 * metodo para mostrar el listado de todos los discos
	 * @return
	 */
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

	/**
	 * metodo que recibe como parametro el titulo para poder filtrar las multimedias en funcion de este
	 * @param titulo
	 * @return
	 */
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

	/**
	 * metodo que filtra las multimedias existentes por autor introducido como parametro
	 * @param autor
	 * @return
	 */
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

	/**
	 * metodo que muestra los discos filtrados en funcion del titulo introducido
	 * @param titulo
	 * @return
	 */
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

	/**
	 * metodo para mostrar los discos por titulo
	 * @return
	 */
	public String[] obtenerDiscosTitulo()
	{
		String[] discoNameList = new String[obtenerTodosLosDiscos().size()];

		for (int i = 0; i < obtenerTodosLosDiscos().size(); i++)
		{
			discoNameList[i] = obtenerTodosLosDiscos().get(i).getTitulo();
		}

		return discoNameList;
	}

	/**
	 * metodo que añade una cancion a un disco
	 * @param cancion
	 * @param disco
	 */
	public void aniadirCancionToDisco(Cancion cancion, Disco disco)
	{
		disco.addCancion(cancion);
	}
}