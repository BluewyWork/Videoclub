package com.videoclub.model;

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
	public void mostrarAlquileresDeSocio(Socio socio) {
		for (Alquiler alquiler : arrayListMultimediaAlquilada) {
			if (alquiler.getMySocio().equals(socio)) {
				//System.out.println(alquiler.toString());
				//System.out.println(alquiler.getArrayListMultimedia());
			}
		}
	}

}
