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

	public ArrayList<Alquiler> returnStuff(String nif)
	{
		ArrayList<Alquiler> listArrayList = alquilerDAO.getListAlquiler();
		ArrayList<Alquiler> listAlquilerFilratado = new ArrayList<>();

		for (Alquiler alquiler : listArrayList)
		{
			if (alquiler.getNif().equals(nif))
			{
				listAlquilerFilratado.add(alquiler);
			}
		}

		return listAlquilerFilratado;
	}

	public ArrayList<Alquiler> listarAlquileresSocio(String nif)
	{
		return alquilerDAO.listarAlquileresSocio(nif);
	}

	public ArrayList<Alquiler> listarSocioRecargo()
	{
		return alquilerDAO.listarSocioRecargo();
	}
}
