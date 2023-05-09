package com.videoclub.model;

import com.videoclub.lib.Input;

import java.util.ArrayList;

public class GestorAlquiler
{
	private ArrayList<Alquiler> arrayListMultimediaAlquilada;

	public GestorAlquiler()
	{
		arrayListMultimediaAlquilada = new ArrayList<>();
	}

	public void addAlquiler(Alquiler al)
	{
		arrayListMultimediaAlquilada.add(al);
	}

	@Override
	public String toString()
	{
		String text = "";

		for (int i = 0; i < arrayListMultimediaAlquilada.size(); i++)
		{
			text += arrayListMultimediaAlquilada.get(i).toString();
		}

		return text;
	}

	public boolean tieneDeudaPendiente2(String nif)
	{
		boolean nani = false;
		for (Alquiler alquiler : arrayListMultimediaAlquilada)
		{
			if (alquiler.getMySocio().getNif().equals(nif))
			{
				nani = true;
				break;
			}
		}
		return nani;
	}

	public ArrayList<Alquiler> getArrayListMultimediaAlquilada()
	{
		return arrayListMultimediaAlquilada;
	}

	public void setArrayListMultimediaAlquilada(ArrayList<Alquiler> arrayListMultimediaAlquilada)
	{
		this.arrayListMultimediaAlquilada = arrayListMultimediaAlquilada;
	}

	public ArrayList<String> listarAlquileresSocio(String nif)
	{
		ArrayList<String> listAlquileresSocio = new ArrayList<>();

		for (Alquiler alquiler : arrayListMultimediaAlquilada)
		{
			if (alquiler.getMySocio().getNif().equals(nif))
			{
				listAlquileresSocio.add(alquiler.toString());
			}
		}
		return listAlquileresSocio;
	}

	public ArrayList<String> listarSocioRecargo()
	{
		ArrayList<String> listSocioRecargo = new ArrayList<>();

		for (Alquiler alquiler : arrayListMultimediaAlquilada)
		{
			if (alquiler.isDeuda())
			{
				listSocioRecargo.add(alquiler.getMySocio().toString());
			}
		}
		return listSocioRecargo;
	}
}
