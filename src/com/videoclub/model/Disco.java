package com.videoclub.model;

import java.util.ArrayList;

public class Disco extends Multimedia
{
	private String nombre;
	private int duracion;
	private ArrayList<Cancion> listaCanciones;

	public Disco(String nombre, ArrayList<Cancion> listCanciones) {
		this.nombre = nombre;
		this.listaCanciones = listCanciones;
		setDuration();
	}

	@Override
	public String toString()
	{
		return super.toString() + "\n" +
						"\t" + "Duracion: " + duracion +
						"\t" + "Canciones: '" + listaCanciones + '\'';
	}

	@Override
	public double calcularPrecioAlquiler()
	{
		if (duracion < 30)
		{
			return Constantes.BASE_PRICE - 1;
		}
		else
		{
			return Constantes.BASE_PRICE;
		}
	}

	public int getDuracion()
	{
		return duracion;
	}

	public void setDuration()
	{
		for (Cancion a : listaCanciones)
		{
			duracion += a.getDuracion();
		}
	}

	public ArrayList<Cancion> getListSongs()
	{
		return listaCanciones;
	}

	public void setListSongs(ArrayList<Cancion> listaCanciones)
	{
		this.listaCanciones = listaCanciones;
	}

}