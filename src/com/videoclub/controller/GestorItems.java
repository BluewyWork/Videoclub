package com.videoclub.controller;

import com.videoclub.model.Alquiler;
import com.videoclub.model.GestorAlquiler;
import com.videoclub.model.Inventario;
import com.videoclub.model.Socio;

public class GestorItems
{
	private final Inventario myInventario;
	private final GestorAlquiler myGA;

	public GestorItems()
	{
		myInventario = new Inventario();
		myGA = new GestorAlquiler();
	}

	public void createMultimedia(String type, String titulo, String autor, String formato, int anyo, int duracion, String actorPrincipal, String actrizPrincipal, String plataforma)
	{
		switch (type.toLowerCase())
		{
			case "pelicula", "videojuego", "disco" ->
					myInventario.anadirMultimedia(type, titulo, autor, formato, anyo, duracion, actorPrincipal, actrizPrincipal, plataforma);
		}
	}

	public boolean tenerDeuda(String nif)
	{
		return myGA.tieneDeudaPendiente(nif);
	}

	public void alquilarMultimedia(Socio socio, String titulo)
	{
		Alquiler myAlquiler = new Alquiler();
		myAlquiler.setMySocio(socio);
		myAlquiler.setArrayListMultimediaAlquilada(myInventario.buscarMultimedia(titulo));
		System.out.println(titulo + " alquilado correctamente");
		myGA.addAlquiler(myAlquiler);
		myInventario.removerMultimedia(titulo);
	}

	public String mostrarMultimedias(String type)
	{
		return myInventario.mostarMultimedias(type);
	}

	public void mostrarAlquileresSocio(Socio socio)
	{
		myGA.mostrarAlquileresDeSocio(socio);
	}

	public boolean existenMultimedia(String type)
	{
		return myInventario.hayMultimediaDisponibles(type);
	}
}