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

	public void aniadirSocio(Socio socio)
	{
		listSocios.add(socio);
	}

	public void eliminarSocio(String nif)
	{
		Socio socio = encontrarSocio(nif);
		if (socio != null)
		{
			listSocios.remove(encontrarSocio(nif));
		}
		else
		{
			throw new RuntimeException("Member with " + nif + " not found!");
		}

	}
}