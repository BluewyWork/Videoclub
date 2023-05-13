package com.videoclub.model;

import java.util.ArrayList;

public class Inventory
{
	private ArrayList<Multimedia> listMultimedia;

	public Inventory()
	{
		listMultimedia = new ArrayList<>();
	}

	public ArrayList<Multimedia> getListMultimedia()
	{
		return listMultimedia;
	}

	public void setListMultimedia(ArrayList<Multimedia> listMultimedia)
	{
		this.listMultimedia = listMultimedia;
	}

	public void addMultimedia(String type, String titulo, String autor, String formato, int anyo, int duracion, String actorPrincipal, String actrizPrincipal, String plataforma)
	{
		switch (type.toLowerCase())
		{
			case "pelicula" ->
			{
				Movie myPelicula = new Movie(titulo, autor, formato, anyo, duracion, actorPrincipal, actrizPrincipal);
				listMultimedia.add(myPelicula);
			}
			case "videojuego" ->
			{
				VideoGame myVideojuego = new VideoGame(titulo, autor, formato, anyo, plataforma);
				listMultimedia.add(myVideojuego);
			}
			case "disco" ->
			{
				Disc myDisco = new Disc();
				listMultimedia.add(myDisco);
			}
		}
	}

	public void removeMultimedia(String titulo)
	{
		boolean found = false;

		for (int x = 0; x < listMultimedia.size() && !found; x++)
		{
			if (listMultimedia.get(x).getTitle().equals(titulo))
			{
				found = true;

				listMultimedia.remove(x);
			}
		}
	}

	public Multimedia returnMultimedia(String titulo)
	{
		Multimedia mul = null;
		boolean found = false;

		for (int x = 0; x < listMultimedia.size() && !found; x++)
		{
			if (listMultimedia.get(x).getTitle().equals(titulo))
			{
				found = true;

				mul = listMultimedia.get(x);
			}
		}
		return mul;
	}

	public String printMultimedias(String type)
	{
		StringBuilder text = new StringBuilder();
		for (Multimedia multimedia : listMultimedia)
		{
			if (multimedia instanceof Movie && type.equalsIgnoreCase("pelicula"))
			{
				text.append("Pelicula: ").append(multimedia.getTitle()).append("\n");
			}
			else if (multimedia instanceof VideoGame && type.equalsIgnoreCase("videojuego"))
			{
				text.append("Videojuego: ").append(multimedia.getTitle()).append("\n");
			}
			else if (multimedia instanceof Disc && type.equalsIgnoreCase("disco"))
			{
				text.append("Disco: ").append(multimedia.getTitle()).append("\n");
			}
		}
		return text.toString();
	}

	public boolean isMultimediaAvailable(String type)
	{
		for (Multimedia multimedia : listMultimedia)
		{
			if (multimedia instanceof Disc && type.equalsIgnoreCase("disc"))
			{
				return true;
			}
			else if (multimedia instanceof Movie && type.equalsIgnoreCase("movie"))
			{
				return true;
			}
			else if (multimedia instanceof VideoGame && type.equalsIgnoreCase("videogame"))
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