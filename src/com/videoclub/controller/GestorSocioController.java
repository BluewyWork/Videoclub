package com.videoclub.controller;

import com.videoclub.model.*;

public class GestorSocioController {

	private static GestorSocio myGestorSocio = new GestorSocio();

	public static void crearSocio(String nif, String nombre, String fechaNaciemento, String poblacion) {
		myGestorSocio.addSocio(nif, nombre, fechaNaciemento, poblacion);
	}
}
