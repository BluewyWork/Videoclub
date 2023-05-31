package com.videoclub.util;

import com.videoclub.model.Videojuego;

import java.util.Comparator;

/**
 * Esta clase implementa la interfaz Comparator para comparar objetos de tipo Videojuego según su año de lanzamiento.
 */
public class VideojuegoComparator implements Comparator<Videojuego>
{
	/**
	 * Compara dos objetos de tipo Videojuego según su año de lanzamiento.
	 *
	 * @param v1 El primer videojuego a comparar.
	 * @param v2 El segundo videojuego a comparar.
	 * @return Un valor negativo si v1 es anterior a v2 en términos de año de lanzamiento,
	 *         cero si v1 y v2 tienen el mismo año de lanzamiento,
	 *         o un valor positivo si v1 es posterior a v2 en términos de año de lanzamiento.
	 */
	@Override
	public int compare(Videojuego v1, Videojuego v2) {
		return v1.getAnio() - v2.getAnio();
	}
}
