package com.videoclub.controller;

import com.videoclub.model.GestorAlquiler;
import com.videoclub.model.Socio;

public class GestorAlquilerController
{
	private GestorAlquiler myGA;

	public GestorAlquilerController()
	{
		myGA = new GestorAlquiler();
	}

	public boolean tieneDeudas(Socio socio)
	{
		return myGA.tieneDeudaPendiente(socio);
	}
    
	/*public void crearAlquiler(Socio socio, boolean deuda) {
		myGA.addAlquiler(socio, deuda);
	}*/
}
