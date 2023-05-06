package com.videoclub.controller;

import com.videoclub.model.GestorAlquiler;
import com.videoclub.model.Multimedia;
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

	public boolean tieneDeudas2(Socio socio)
	{
		return myGA.tieneDeudaPendiente2(socio);
	}

	public void aquilar(Socio socio, Multimedia m) {
		myGA.addAlquiler(socio, m);
	}
    
	/*public void crearAlquiler(Socio socio, boolean deuda) {
		myGA.addAlquiler(socio, deuda);
	}*/
}
