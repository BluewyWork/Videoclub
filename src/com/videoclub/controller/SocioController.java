/**
 * The `SocioController` class is responsible for managing the operations related to members of the videoclub. It
 * interacts with the `SocioDAO` to perform CRUD operations on socio (member) objects.
 */
package com.videoclub.controller;

import com.videoclub.model.Socio;
import com.videoclub.model.SocioDAO;

import java.util.ArrayList;

public class SocioController
{
	private final SocioDAO socioDAO;

	/**
	 * Constructs a new `SocioController` object and initializes the `SocioDAO`.
	 */
	public SocioController()
	{
		socioDAO = new SocioDAO();
	}

	/**
	 * Registers a new socio (member) in the videoclub with the given details.
	 *
	 * @param nif       The NIF (identification number) of the socio.
	 * @param name      The name of the socio.
	 * @param birthDate The birth date of the socio.
	 * @param town      The town of residence of the socio.
	 */
	public void registrarSocio(String nif, String name, String birthDate, String town)
	{
		Socio socio = new Socio(nif, name, birthDate, town);
		socioDAO.aniadirSocio(socio);
	}

	/**
	 * Removes a socio (member) from the videoclub based on the NIF (identification number).
	 *
	 * @param nif The NIF of the socio to be removed.
	 */
	public void darBajaSocio(String nif)
	{
		socioDAO.eliminarSocio(nif);
	}

	/**
	 * Finds and retrieves a socio (member) from the videoclub based on the NIF (identification number).
	 *
	 * @param nif The NIF of the socio to be found.
	 * @return The Socio object matching the specified NIF, or null if not found.
	 */
	public Socio encontrarSocio(String nif)
	{
		return socioDAO.encontrarSocio(nif);
	}

	/**
	 * Returns a list of all socios (members) in the videoclub.
	 *
	 * @return An ArrayList of Socio objects representing the socios.
	 */
	public ArrayList<Socio> todosLosSocios()
	{
		return socioDAO.getListSocios();
	}

	/**
	 * Filters socios (members) in the videoclub by the specified name and returns the matching socios.
	 *
	 * @param nombre The name to filter the socios by.
	 * @return An ArrayList of Socio objects matching the specified name.
	 */
	public ArrayList<Socio> filtroPorNombre(String nombre)
	{
		return socioDAO.filtroPorNombre(nombre);
	}

	/**
	 * Filters socios (members) in the videoclub by the specified NIF and returns the matching socios.
	 *
	 * @param nIF The NIF to filter the socios by.
	 * @return An ArrayList of Socio objects matching the specified NIF.
	 */
	public ArrayList<Socio> filtroPorNIF(String nIF)
	{
		return socioDAO.filtroPorNif(nIF);
	}
}