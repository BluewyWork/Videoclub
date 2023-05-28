package com.videoclub.controller;

import com.videoclub.model.*;

import java.util.ArrayList;

public class CancionController
{
	CancionDAO cancionDAO;
	public CancionController()
{
	cancionDAO = new CancionDAO();
}

	public void altaCancion(String nombre, int duracion)
	{
		Cancion cancion = new Cancion(nombre, duracion);
		cancionDAO.aniadirCancion(cancion);
	}

	public ArrayList<Cancion> returnCancion()
	{
		return cancionDAO.getListCancion();
	}

	public ArrayList<Cancion> obtenerCancionesPorDuracion(Disco disco)
	{
		return cancionDAO.obtenerCancionesPorDuracion(disco);
	}

	public String[] obtenerCancionesNombre()
	{
		return cancionDAO.obtenerCancionesNombre();
	}
	public Cancion filtroCancionPorNombre(String nombre)
	{
		return cancionDAO.filtroCancionPorNombre(nombre);
	}

	public void darBajaCancion(String nombre, int duracion)
	{
		cancionDAO.eliminarCancion(nombre, duracion);
	}
}
