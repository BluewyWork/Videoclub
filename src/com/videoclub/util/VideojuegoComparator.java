package com.videoclub.util;

import com.videoclub.model.Videojuego;

import java.util.Comparator;

public class VideojuegoComparator implements Comparator<Videojuego>
{
	@Override
	public int compare(Videojuego v1, Videojuego v2) {
		return v1.getAnio() - v2.getAnio();
	}
}