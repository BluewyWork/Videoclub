package com.videoclub.controller;

import com.videoclub.model.Socio;
import com.videoclub.model.SocioDAO;

import java.util.ArrayList;

public class SocioController
{
	private final SocioDAO socioDAO;

	public SocioController()
	{
		socioDAO = new SocioDAO();
	}

	public void registrarSocio(String nif, String name, String birthDate, String town)
	{
		Socio socio = new Socio(nif, name, birthDate, town);

		socioDAO.aniadirSocio(socio);
	}

	public void darBajaSocio(String nif)
	{
		socioDAO.eliminarSocio(nif);
	}

	public Socio encontrarSocio(String nif)
	{
		return socioDAO.encontrarSocio(nif);
	}

	public ArrayList<Socio> todosLosSocios()
	{
		return socioDAO.getListSocios();
	}

	public ArrayList<Socio> filtroPorNombre(String nombre)
	{
		return socioDAO.filtroPorNombre(nombre);
	}

	public ArrayList<Socio> filtroPorNIF(String nIF)
	{
		return socioDAO.filtroPorNif(nIF);
	}
}