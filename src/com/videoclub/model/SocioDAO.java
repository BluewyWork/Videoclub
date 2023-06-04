package com.videoclub.model;

import java.util.ArrayList;

public class SocioDAO
{
	/**
	 * Atributos de la clase SocioDAO
	 */
	private final ArrayList<Socio> listSocios;

	/**
	 * Constructor por defecto de la clase SocioDAO
	 */
	public SocioDAO()
	{
		listSocios = new ArrayList<>();
	}

	/**
	 * Override de toString
	 * @return
	 */
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

	/**
	 * Getters y setters
	 * @return
	 */
	public ArrayList<Socio> getListSocios()
	{
		return listSocios;
	}

	public ArrayList<Socio> getListMembers()
	{
		return listSocios;
	}

	/**
	 * Metodo para encontrar socios mediante el nif
	 * @param nif
	 * @return
	 */
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

	/**
	 * Metodo que muestra una lista de los socios filtadros por nombre
	 * @param nombre
	 * @return
	 */
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

	/**
	 * Metodo que muestra una lista de los socios filtadros por nif
	 * @param nIF
	 * @return
	 */
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

	/**
	 * Metodo que añade un socio a la lista de socios
	 * @param socio
	 */
	public void aniadirSocio(Socio socio)
	{
		listSocios.add(socio);
	}

	/**
	 * Metodo que elimina un socio de la lista de socios
	 * @param nif
	 */
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