package com.videoclub.controller;

import com.videoclub.model.Socio;
import com.videoclub.model.SocioDAO;

public class SocioController
{
	private final SocioDAO socioDAO;

	public SocioController()
	{
		socioDAO = new SocioDAO();
	}

	public void registrarMiembros(String nif, String name, String birthDate, String town)
	{
		Socio socio = new Socio(nif, name, birthDate, town);

		socioDAO.aniadirSocio(socio);
	}

	public void unregisterMember(String nif)
	{
		socioDAO.eliminarSocio(nif);
	}

	public String mostrarSocios()
	{
		return socioDAO.toString();
	}

}
