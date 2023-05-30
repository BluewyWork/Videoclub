package com.videoclub.controller;

import com.videoclub.model.Alquiler;
import com.videoclub.model.AlquilerDAO;
import com.videoclub.model.Multimedia;

import java.util.ArrayList;

public class AlquilerController
{
	private final AlquilerDAO alquilerDAO;

	public AlquilerController()
	{
		alquilerDAO = new AlquilerDAO();
	}

	/**
	 * asigna al socio la multimedia que desea
	 * al metodo se le pasa un String "nif" y un objecto "multimedia"
	 * utilizando el metodo pagosPendientes pasandole el nif comprueba si y socio tiene algun otro
	 * multimedia que tenga recargos y si si no le deja alquilar
	 * se crea un objecto alquiler con los con la informacion necesaria para luego recuperarla
	 *
	 * @param memberNIF el nif de socio
	 * @param multimedia el objecto multimedia que desea alquilar el socio
	 * @throws RuntimeException si el miembro tiene recargos
	 */

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

	/**
	 * elimina el alquiler del array list y retorna dicho alquiler
	 * utilizando el id para recuperar el alquiler exacto y lo elimina del arraylist
	 * antes de eso se guarda en un objecto alquiler es que retornado para
	 * hacer mas acciones como recuperar multimedia...
	 * @param id
	 * @return
	 */
	public Alquiler delvolverAlquiler(int id)
	{
		Alquiler alquiler = alquilerDAO.encontrarAlquiler(id);

		alquilerDAO.eliminarAlquiler(id);

		return alquiler;
	}

	/**
	 * Devuelve un arraylist que contiene todos los alquileres actuales del socio
	 *
	 * @param nif
	 * @return
	 */
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

	/**
	 * devuelve los alquiler de dicho socio utilzando el nif
	 *
	 * @param nif
	 * @return
	 */
	public ArrayList<Alquiler> listarAlquileresSocio(String nif)
	{
		return alquilerDAO.listarAlquileresSocio(nif);
	}

	/**
	 * recupera los alquilers con recargos de un socio
	 * @return
	 */
	public ArrayList<Alquiler> listarSocioRecargo()
	{
		return alquilerDAO.listarSocioRecargo();
	}

	/**
	 * devuelve todos los alquileres actuales
	 * @return
	 */
	public ArrayList<Alquiler> todosLosAlquileres()
	{
		return alquilerDAO.getListAlquiler();
	}
}
