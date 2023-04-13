package com.videoclub.model;

import java.util.ArrayList;

public class GestorSocio {
	private static ArrayList<Socio> arrayListSocio;

	public GestorSocio() {
		arrayListSocio = new ArrayList<>();
	}

	public static void addSocio(String nif, String nombre, String fecahNac, String pobalcion) {
		Socio mySocio = new Socio(nif, nombre, fecahNac, pobalcion);

		arrayListSocio.add(mySocio);
	}
}
