package com.videoclub.controller;

import com.videoclub.model.GestorAlquiler;

public class GestorAlquilerController {

	private GestorAlquiler myGA;

	public GestorAlquilerController() {
		myGA = new GestorAlquiler();
	}
    
	public void crearAlquiler(Socio socio, boolean deuda) {
		myGA.addAlquiler(socio, deuda);
	}
}
