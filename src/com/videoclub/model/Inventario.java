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
			case "pelicula":
				Pelicula myPelicula = new Pelicula(titulo, autor, formato, anyo, duracion, actorPrincipal, actrizPrincipal);
				arrayListMultimedia.add(myPelicula);
				break;
			case "videojuego":
				Videojuego myVideojuego = new Videojuego(titulo, autor, formato, anyo, plataforma);
				arrayListMultimedia.add(myVideojuego);
				break;
			case "disco":
				Disco myDisco = new Disco();
				arrayListMultimedia.add(myDisco);
				break;
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

	public String mostrarPeliculas()
	{
		String text = "";

		for (int i = 0; i < arrayListMultimedia.size(); i++)
		{
			if (arrayListMultimedia.get(i) instanceof Pelicula)
			{
				text += "Pelicula: " + arrayListMultimedia.get(i).getTitulo() + "\n";
			}
		}
		return text;
	}

	public String mostrarVideoJuegos()
	{
		String text = "";

		for (int i = 0; i < arrayListMultimedia.size(); i++)
		{
			if (arrayListMultimedia.get(i) instanceof Videojuego)
			{
				text += "videojuego: " + arrayListMultimedia.get(i).getTitulo() + "\n";
			}
		}
		return text;
	}

	public String mostarMultimedias(String type)
	{
		String text = "";
		for (Multimedia multimedia : arrayListMultimedia)
		{
			if (multimedia instanceof Pelicula && type.equalsIgnoreCase("pelicula"))
			{
				text += "Pelicula: " + multimedia.getTitulo() + "\n";
			}
			else if (multimedia instanceof Videojuego && type.equalsIgnoreCase("videojuego"))
			{
				text += "Videojuego: " + multimedia.getTitulo() + "\n";
			}
			else if (multimedia instanceof Disco && type.equalsIgnoreCase("disco"))
			{
				text += "Disco: " + multimedia.getTitulo() + "\n";
			}
			else
			{
				text += "Multimedia: " + multimedia.getTitulo() + "\n";
			}
		}
		return text;
	}
}
