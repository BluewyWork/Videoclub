package com.videoclub.model;

import java.util.ArrayList;

public class GestorSocio
{
	private final ArrayList<Socio> arrayListSocio;

	public GestorSocio()
	{
		arrayListSocio = new ArrayList<>();
	}

	public void addSocio(String nif, String nombre, String fechaNac, String poblacion)
	{
		arrayListSocio.add(new Socio(nif, nombre, fechaNac, poblacion));
	}

	public boolean existe(String nif)
	{
		boolean b = false;
		for (int i = 0; i < arrayListSocio.size() && !b; i++)
		{
			if (nif.equals(arrayListSocio.get(i).getNif()))
			{
				System.out.println("NIF" + arrayListSocio.get(i).getNif());
				b = true;
			}
		}
		return b;
	}

	public Socio buscarSocio(String nif)
	{
		Socio socio = null;
		boolean b = false;

		for (int i = 0; i < arrayListSocio.size() && !b; i++)
		{
			if (nif.equals(arrayListSocio.get(i).getNif()))
			{
				socio = arrayListSocio.get(i);
				b = true;
			}
		}
		return socio;
	}
}
