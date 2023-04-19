package com.videoclub.model;

import java.util.ArrayList;

public class GestorSocio {
	private ArrayList<Socio> arrayListSocio;

	public GestorSocio() {
		arrayListSocio = new ArrayList<>();
	}

	public void addSocio(String nif, String nombre, String fechaNac, String poblacion) {
		arrayListSocio.add(new Socio(nif, nombre, fechaNac, poblacion));
	}
}
