package com.videoclub.model;

import java.util.ArrayList;

public class Inventario
{
	private ArrayList<Multimedia> arrayListMultimedia;

	public Inventario()
	{
		arrayListMultimedia = new ArrayList<>();
	}

	public ArrayList<Multimedia> getArrayListMultimedia()
	{
		return arrayListMultimedia;
	}

	public void setArrayListMultimedia(ArrayList<Multimedia> arrayListMultimedia)
	{
		this.arrayListMultimedia = arrayListMultimedia;
	}

	public void anadirMultimedia(String type, String titulo, String autor, String formato, int anyo, int duracion, String actorPrincipal, String actrizPrincipal, String plataforma)
	{
		switch (type.toLowerCase())
		{
			case "pelicula" ->
			{
				Pelicula myPelicula = new Pelicula(titulo, autor, formato, anyo, duracion, actorPrincipal, actrizPrincipal);
				arrayListMultimedia.add(myPelicula);
			}
			case "videojuego" ->
			{
				Videojuego myVideojuego = new Videojuego(titulo, autor, formato, anyo, plataforma);
				arrayListMultimedia.add(myVideojuego);
			}
			case "disco" ->
			{
				Disco myDisco = new Disco();
				arrayListMultimedia.add(myDisco);
			}
		}
	}

	public void removerMultimedia(String titulo)
	{
		boolean encontrado = false;

		for (int x = 0; x < arrayListMultimedia.size() && !encontrado; x++)
		{
			if (arrayListMultimedia.get(x).getTitulo().equals(titulo))
			{
				encontrado = true;

				arrayListMultimedia.remove(x);
			}
		}
	}

	public Multimedia buscarMultimedia(String titulo)
	{
		Multimedia mul = null;
		boolean encontrado = false;

		for (int x = 0; x < arrayListMultimedia.size() && !encontrado; x++)
		{
			if (arrayListMultimedia.get(x).getTitulo().equals(titulo))
			{
				encontrado = true;

				mul = arrayListMultimedia.get(x);
			}
		}
		return mul;
	}

	// eliminar metodo una vez completada mostrarMultimedias
	public String mostrarPeliculas()
	{
		StringBuilder text = new StringBuilder();

		for (Multimedia multimedia : arrayListMultimedia)
		{
			if (multimedia instanceof Pelicula)
			{
				text.append("Pelicula: ").append(multimedia.getTitulo()).append("\n");
			}
		}
		return text.toString();
	}

	// eliminar metodo una vez completada mostrarMultimedias
	public String mostrarVideoJuegos()
	{
		StringBuilder text = new StringBuilder();

		for (Multimedia multimedia : arrayListMultimedia)
		{
			if (multimedia instanceof Videojuego)
			{
				text.append("videojuego: ").append(multimedia.getTitulo()).append("\n");
			}
		}
		return text.toString();
	}

	public String mostarMultimedias(String type)
	{
		StringBuilder text = new StringBuilder();
		for (Multimedia multimedia : arrayListMultimedia)
		{
			if (multimedia instanceof Pelicula && type.equalsIgnoreCase("pelicula"))
			{
				text.append("Pelicula: ").append(multimedia.getTitulo()).append("\n");
			}
			else if (multimedia instanceof Videojuego && type.equalsIgnoreCase("videojuego"))
			{
				text.append("Videojuego: ").append(multimedia.getTitulo()).append("\n");
			}
			else if (multimedia instanceof Disco && type.equalsIgnoreCase("disco"))
			{
				text.append("Disco: ").append(multimedia.getTitulo()).append("\n");
			}
		}
		return text.toString();
	}

	public boolean hayPeliculasDisponibles()
	{
		for (Multimedia multimedia : arrayListMultimedia)
		{
			if (multimedia instanceof Pelicula)
			{
				return true;
			}
		}
		return false;
	}

	public boolean hayVideojuegosDisponibles()
	{
		for (Multimedia multimedia : arrayListMultimedia)
		{
			if (multimedia instanceof Videojuego)
			{
				return true;
			}
		}
		return false;
	}

	public boolean hayDiscosDisponibles()
	{
		for (Multimedia multimedia : arrayListMultimedia)
		{
			if (multimedia instanceof Disco)
			{
				return true;
			}
		}
		return false;
	}

}