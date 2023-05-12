package com.videoclub.model;

import java.util.ArrayList;

public class RentManager
{
	private ArrayList<Rent> arrayListMultimediaAlquilada;

	public RentManager()
	{
		arrayListMultimediaAlquilada = new ArrayList<>();
	}

	public void addAlquiler(Rent al)
	{
		arrayListMultimediaAlquilada.add(al);
	}

	@Override
	public String toString()
	{
		StringBuilder text = new StringBuilder();

		for (Rent alquiler : arrayListMultimediaAlquilada)
		{
			text.append(alquiler.toString());
		}

		return text.toString();
	}

	public boolean tieneDeudaPendiente(String nif)
	{
		boolean nani = false;
		for (Rent alquiler : arrayListMultimediaAlquilada)
		{
			if (alquiler.getMember().getNif().equals(nif))
			{
				nani = true;
				break;
			}
		}
		return nani;
	}

	public ArrayList<Rent> getArrayListMultimediaAlquilada()
	{
		return arrayListMultimediaAlquilada;
	}

	public void setArrayListMultimediaAlquilada(ArrayList<Rent> arrayListMultimediaAlquilada)
	{
		this.arrayListMultimediaAlquilada = arrayListMultimediaAlquilada;
	}

	public void mostrarAlquileresDeSocio(Member socio)
	{
		for (Rent alquiler : arrayListMultimediaAlquilada)
		{
			if (alquiler.getMember().equals(socio))
			{
				//System.out.println(alquiler.toString());
				System.out.println(socio.toString());

				//System.out.println(alquiler.getArrayListMultimedia());
			}
		}
	}

	public ArrayList<String> listarAlquileresSocio(String nif)
	{
		ArrayList<String> listAlquileresSocio = new ArrayList<>();

		for (Rent alquiler : arrayListMultimediaAlquilada)
		{
			if (alquiler.getMember().getNif().equals(nif))
			{
				for (Multimedia multimedia : alquiler.getArrayListMultimedia())
				{
					listAlquileresSocio.add(multimedia.getTitulo());
				}
			}
		}
		return listAlquileresSocio;
	}

	public ArrayList<String> listarSocioRecargo()
	{
		ArrayList<String> listSocioRecargo = new ArrayList<>();

		for (Rent alquiler : arrayListMultimediaAlquilada)
		{
			if (alquiler.tieneDeuda())
			{
				listSocioRecargo.add(alquiler.getMember().toString());
			}
		}
		return listSocioRecargo;
	}
}