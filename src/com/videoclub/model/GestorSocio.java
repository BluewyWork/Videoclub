package com.videoclub.model;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorSocio {
	private ArrayList<Socio> arrayListSocio;

	public GestorSocio() {
		arrayListSocio = new ArrayList<>();
	}

	public void addSocio(String nif, String nombre, String fechaNac, String poblacion) {
		arrayListSocio.add(new Socio(nif, nombre, fechaNac, poblacion));
	}

	//comprobar si el socio existe en la BDD. Pensar si devolvemos socio o boolean
	public boolean existe(String nif){
		//Socio socio = null;
		boolean b = false;
		System.out.println(arrayListSocio.size());
		for (int i = 0; i < arrayListSocio.size() && !b; i++) {
			if (nif.equals(arrayListSocio.get(i).getNif())) {
				//arrayListSocio.get(i).setDeuda(true);
				System.out.println("NIF" + arrayListSocio.get(i).getNif());
				//socio = arrayListSocio.get(i);
				b = true;
			}
		}
		return b;
	}

}
