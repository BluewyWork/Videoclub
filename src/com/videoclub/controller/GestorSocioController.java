package com.videoclub.controller;

import com.videoclub.model.GestorSocio;
import com.videoclub.model.Socio;

public class GestorSocioController
{

	private GestorSocio myGS;

	public GestorSocioController()
	{
		myGS = new GestorSocio();
	}

	public void crearSocio(String nif, String nombre, String fechaNac, String poblacion)
	{
		myGS.addSocio(nif, nombre, fechaNac, poblacion);
	}

	public boolean existeSocio(String nif)
	{
		return myGS.existe(nif);
	}

	public Socio buscarSocio(String nif)
	{
		return myGS.buscarSocio(nif);

	}
}
