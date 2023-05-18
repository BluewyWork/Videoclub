package com.videoclub.model;

import java.util.ArrayList;

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

	@Deprecated
	public ArrayList<String> mostrarTituloMultimedia()
	{
		ArrayList<String> string = new ArrayList<>();

		for (Multimedia multimedia : listMultimedia)
		{
			string.add(multimedia.getTitulo() + "||" + multimedia.getAutor());
		}

		return string;

	}

	public String[][] devolverListMultimedia()
	{
		int size = listMultimedia.size();
		String[][] list = new String[size][5];

		for (int x = 0; x < list.length; x++)
		{
			for (Multimedia multimedia : listMultimedia)
			{
				list[x][0] = multimedia.getTitulo();
				list[x][1] = multimedia.getAutor();
				list[x][2] = multimedia.getFormat().name();
				list[x][3] = String.valueOf(multimedia.getAnio());
				list[x][4] = String.valueOf(multimedia.getPrecioTotalAlquiler());
			}
		}

		return list;
	}
}