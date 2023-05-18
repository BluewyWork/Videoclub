package com.videoclub.controller;

import com.videoclub.model.Alquiler;
import com.videoclub.model.AlquilerDAO;
import com.videoclub.model.Multimedia;

import java.util.ArrayList;

public class AlquilerController
{
	private AlquilerDAO alquilerDAO;

	public AlquilerController()
	{
		alquilerDAO = new AlquilerDAO();
	}

	// using clever techniques to retrieve desired amount of
	// multimedia and pass it as an argument
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

	public String mostrarAlquileres()
	{
		return alquilerDAO.toString();
	}


}
