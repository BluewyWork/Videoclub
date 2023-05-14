package com.videoclub.model;

import java.util.ArrayList;

public class Disco extends Multimedia
{
	private int duration;
	private ArrayList<Cancion> listCancions;

	public Disco()
	{
		setDuration();
		listCancions = new ArrayList<>();
	}

	@Override
	public String toString()
	{
		return
				super.toString() + "\n" +
						"\t" + "Duration: " + duration +
						"\t" + "Songs: '" + listCancions + '\'';
	}

	@Override
	public double calcularPrecioAlquiler()
	{
		if (duration < 30)
		{
			return Constantes.BASE_PRICE - 1;
		}
		else
		{
			return Constantes.BASE_PRICE;
		}
	}

	public int getDuration()
	{
		return duration;
	}

	public void setDuration()
	{
		for (Cancion a : listCancions)
		{
			duration += a.getDuration();
		}
	}

	public ArrayList<Cancion> getListSongs()
	{
		return listCancions;
	}

	public void setListSongs(ArrayList<Cancion> listCancions)
	{
		this.listCancions = listCancions;
	}
}