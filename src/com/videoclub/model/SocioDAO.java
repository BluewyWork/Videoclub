package com.videoclub.model;

import java.util.ArrayList;

public class SocioDAO
{
	private final ArrayList<Socio> listSocios;

	public SocioDAO()
	{
		listSocios = new ArrayList<>();
	}

	@Override
	public String toString()
	{
		String text = "";

		for (Socio socio : listSocios)
		{
			text += socio.toString();
		}

		return text;
	}

	public ArrayList<Socio> getListSocios()
	{
		return listSocios;
	}

	public ArrayList<Socio> getListMembers()
	{
		return listSocios;
	}

	public Socio encontrarSocio(String nif)
	{
		Socio socio = null;
		boolean b = false;

		for (int i = 0; i < listSocios.size() && !b; i++)
		{
			if (nif.equals(listSocios.get(i).getNif()))
			{
				socio = listSocios.get(i);
				b = true;
			}
		}
		return socio;
	}

	public ArrayList<Socio> filtroPorNombre(String nombre)
	{
		ArrayList<Socio> listSocios = new ArrayList<>();

		for (Socio socio : this.listSocios)
		{
			if (socio.getNombre().equals(nombre))
			{
				listSocios.add(socio);
			}
		}

		return listSocios;
	}

	public ArrayList<Socio> filtroPorNif(String nIF)
	{
		ArrayList<Socio> listSocio = new ArrayList<>();

		for (Socio socio : this.listSocios)
		{
			if (socio.getNif().equals(nIF))
			{
				listSocio.add(socio);
			}
		}

		return listSocio;
	}

	public void aniadirSocio(Socio socio)
	{
		listSocios.add(socio);
	}

	public void eliminarSocio(String nif)
	{
		Socio socio = encontrarSocio(nif);
		if (socio != null)
		{
			listSocios.remove(socio);
		}
		else
		{
			throw new RuntimeException("Member with " + nif + " not found!");
		}

	}
}