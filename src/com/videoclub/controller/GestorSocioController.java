package com.videoclub.controller;

import com.videoclub.model.GestorSocio;

public class GestorSocioController {

	private GestorSocio myGS;

	public GestorSocioController() {
		myGS = new GestorSocio();
	}
	public void crearSocio(String nif, String nombre, String fechaNac, String poblacion) {
		myGS.addSocio(nif, nombre, fechaNac, poblacion);
	}

	public boolean existeSocio(String nif){
		return myGS.existe(nif);
	}
}
