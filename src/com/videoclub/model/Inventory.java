package com.videoclub.model;

import java.util.ArrayList;

public class Inventory
{
	private ArrayList<Multimedia> arrayListMultimedia;

	public Inventory()
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
				Movie myPelicula = new Movie(titulo, autor, formato, anyo, duracion, actorPrincipal, actrizPrincipal);
				arrayListMultimedia.add(myPelicula);
			}
			case "videojuego" ->
			{
				Videogame myVideojuego = new Videogame(titulo, autor, formato, anyo, plataforma);
				arrayListMultimedia.add(myVideojuego);
			}
			case "disco" ->
			{
				Disc myDisco = new Disc();
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

	public String mostarMultimedias(String type)
	{
		StringBuilder text = new StringBuilder();
		for (Multimedia multimedia : arrayListMultimedia)
		{
			if (multimedia instanceof Movie && type.equalsIgnoreCase("pelicula"))
			{
				text.append("Pelicula: ").append(multimedia.getTitulo()).append("\n");
			}
			else if (multimedia instanceof Videogame && type.equalsIgnoreCase("videojuego"))
			{
				text.append("Videojuego: ").append(multimedia.getTitulo()).append("\n");
			}
			else if (multimedia instanceof Disc && type.equalsIgnoreCase("disco"))
			{
				text.append("Disco: ").append(multimedia.getTitulo()).append("\n");
			}
		}
		return text.toString();
	}

	public boolean hayMultimediaDisponibles(String type)
	{
		for (Multimedia multimedia : arrayListMultimedia)
		{
			if (multimedia instanceof Disc && type.equalsIgnoreCase("disco"))
			{
				return true;
			}
			else if (multimedia instanceof Movie && type.equalsIgnoreCase("pelicula"))
			{
				return true;
			}
			else if (multimedia instanceof Videogame && type.equalsIgnoreCase("videojuego"))
			{
				return true;
			}
			else
			{
				throw new RuntimeException("Wrong Type!");
			}
		}
		return false;
	}
}