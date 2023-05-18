package com.videoclub.controller;

import com.videoclub.model.Alquiler;
import com.videoclub.model.AlquilerDAO;
import com.videoclub.model.Multimedia;

import java.util.ArrayList;
import java.util.HashMap;

public class AlquilerController
{
	private AlquilerDAO alquilerDAO;

	public AlquilerController()
	{
		alquilerDAO = new AlquilerDAO();
	}

	public void alquilarMultimedia(String memberNIF, Multimedia multimedia)
	{
		if (!alquilerDAO.pagosPendientes(memberNIF))
		{
			Alquiler alquiler = new Alquiler(memberNIF, multimedia);
			alquilerDAO.aniadir(alquiler);
		}
		else
		{
			throw new RuntimeException("Member with NIF: " + memberNIF + " has pending payments");
		}
	}

	public Alquiler delvolverAlquiler(int id)
	{
		Alquiler alquiler = alquilerDAO.encontrarAlquiler(id);

		alquilerDAO.eliminarAlquiler(id);

		return alquiler;
	}

	public HashMap<Integer, Multimedia> test()
	{
		return alquilerDAO.test();
	}
	public String[][] alquileresDeSocio(String nif)
	{
		return alquilerDAO.obtenerAlquileres(nif);
	}
}
