package com.videoclub.model;

import java.util.ArrayList;
import java.util.Collections;

public class MultimediaDAO
{
	private ArrayList<Multimedia> listMultimedia;

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

	public ArrayList<String> listarMultimedias()
	{
		ArrayList<String> listMultimedias = new ArrayList<>();

		for (Multimedia multimedia : listMultimedia)
		{
			//listMultimedias.add(multimedia.getTitulo());
			listMultimedias.add(multimedia.toString());
		}

		return listMultimedias;
	}

	public ArrayList<String> listarPeliculasTitulo()
	{
		ArrayList<String> listPeliculasTitulo = new ArrayList<>();
		ArrayList<Multimedia> copyListMultimedia = listMultimedia;
		Collections.sort(listMultimedia);

		for (Multimedia multimedia : copyListMultimedia)
		{
			if (multimedia instanceof Pelicula)
			{
				listPeliculasTitulo.add(multimedia.toString());
			}
		}

		return listPeliculasTitulo;
	}
}