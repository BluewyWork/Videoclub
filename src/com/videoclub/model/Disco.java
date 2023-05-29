package com.videoclub.model;

import java.util.ArrayList;

public class Disco extends Multimedia
{
	private int duracion;
	private ArrayList<Cancion> listaCanciones;

	public Disco(String titulo, String autor, String formato, int anio, ArrayList<Cancion> listCanciones) {
		super(titulo, autor, formato, anio);
		setListSongs(listCanciones);
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

	public ArrayList<Cancion> getListaCanciones()
	{
		return listaCanciones;
	}

	public void setListaCanciones(ArrayList<Cancion> listaCanciones)
	{
		this.listaCanciones = listaCanciones;
	}

	public ArrayList<Cancion> getListSongs()
	{
		return listaCanciones;
	}

	public void setListSongs(ArrayList<Cancion> listaCanciones)
	{
		this.listaCanciones = listaCanciones;
	}

	public void addCancion(Cancion cancion)
	{
		listaCanciones.add(cancion);
	}

}