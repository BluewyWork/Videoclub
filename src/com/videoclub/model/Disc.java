package com.videoclub.model;

import java.util.ArrayList;

public class Disc extends Multimedia
{
	private int duracion;
	private ArrayList<Song> listCanciones;

	public Disc()
	{
		setDuracion();
		listCanciones = new ArrayList<>();
	}

	@Override
	public String toString()
	{
		return
				super.toString() + "\n" +
						"\t" + "Duracion: " + duracion +
						"\t" + "Canciones: '" + listCanciones + '\'';
	}

	public int getDuracion()
	{
		return duracion;
	}

	public void setDuracion()
	{
		for (Song a : listCanciones)
		{
			duracion += a.getDuracion();
		}
	}

	public ArrayList<Song> getListCanciones()
	{
		return listCanciones;
	}

	public void setListCanciones(ArrayList<Song> listCanciones)
	{
		this.listCanciones = listCanciones;
	}
}