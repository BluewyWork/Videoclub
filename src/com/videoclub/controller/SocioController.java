/**
 La clase SocioController se encarga de gestionar las operaciones relacionadas con los miembros del videoclub. Interactúa con SocioDAO
 para realizar operaciones CRUD en objetos socio.
 */
package com.videoclub.controller;

import com.videoclub.model.Socio;
import com.videoclub.model.SocioDAO;

import java.util.ArrayList;

public class SocioController
{
	private final SocioDAO socioDAO;

	/**
	 * Construye un nuevo objeto `SocioController` e inicializa `SocioDAO`.
	 */
	public SocioController()
	{
		socioDAO = new SocioDAO();
	}

	/**
	 * Registra un nuevo socio en el videoclub con los detalles proporcionados.
	 *
	 * @param nif       El NIF (número de identificación) del socio.
	 * @param nombre    El nombre del socio.
	 * @param fechaNac  La fecha de nacimiento del socio.
	 * @param poblacion La poblacion de residencia del socio.
	 */
	public void registrarSocio(String nif, String nombre, String fechaNac, String poblacion)
	{
		Socio socio = new Socio(nif, nombre, fechaNac, poblacion);
		socioDAO.aniadirSocio(socio);
	}

	/**
	 * Elimina un socio del videoclub en base al NIF (número de identificación).
	 *
	 * @param nif El NIF del socio a eliminar.
	 */
	public void darBajaSocio(String nif)
	{
		socioDAO.eliminarSocio(nif);
	}

	/**
	 * Encuentra y recupera un socio del videoclub en base al NIF (número de identificación).
	 *
	 * @param nif El NIF del socio a encontrar.
	 * @return El objeto Socio que coincide con el NIF especificado, o null si no se encuentra.
	 */
	public Socio encontrarSocio(String nif)
	{
		return socioDAO.encontrarSocio(nif);
	}

	/**
	 * Devuelve una lista de todos los socios en el videoclub.
	 *
	 * @return Un ArrayList de objetos Socio que representan a los socios.
	 */
	public ArrayList<Socio> todosLosSocios()
	{
		return socioDAO.getListSocios();
	}

	/**
	 * Filtra los socios en el videoclub por el nombre especificado y devuelve los socios que coinciden.
	 *
	 * @param nombre El nombre para filtrar los socios.
	 * @return Un ArrayList de objetos Socio que coinciden con el nombre especificado.
	 */
	public ArrayList<Socio> filtroPorNombre(String nombre)
	{
		return socioDAO.filtroPorNombre(nombre);
	}

	/**
	 * Filtra los socios en el videoclub por el NIF especificado y devuelve los socios que coinciden.
	 *
	 * @param nIF El NIF para filtrar los socios.
	 * @return Un ArrayList de objetos Socio que coinciden con el NIF especificado.
	 */
	public ArrayList<Socio> filtroPorNIF(String nIF)
	{
		return socioDAO.filtroPorNif(nIF);
	}
}