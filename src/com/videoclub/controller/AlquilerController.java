package com.videoclub.controller;

import com.videoclub.model.*;
import java.util.ArrayList;
import java.time.LocalDate;

public class AlquilerController {
	private ArrayList<Socio> arrayListSocio;
	private ArrayList<Multimedia> arrayListMultimedia;
	private ArrayList<Alquiler> arrayListAlquiler;	

	public AlquilerController() {
		arrayListSocio = new ArrayList<>();
		arrayListMultimedia = new ArrayList<>();
		arrayListAlquiler = new ArrayList<>();
	}

	public void crearSocio(String nif, String nombre, LocalDate fechaNacimiento, String poblacion) {
		Socio mySocio = new Socio(nif, nombre, fechaNacimiento, poblacion);

		arrayListSocio.add(mySocio);
	}

	public void alquilar(Socio mySocio, ArrayList<Multimedia> arrayListMultimediaInvetario) {
		Alquiler myAlquiler = new Alquiler(mySocio, arrayListMultimedia);
		arrayListAlquiler.add(myAlquiler);
	}

	//
	public void delvolver(int id) {
		boolean encontrado = false;

		for (int x = 0; x < arrayListAlquiler.size(); x++) {
			if (id == arrayListAlquiler.get(x).getId() && encontrado == false) {
				arrayListAlquiler.remove(x);
				encontrado = true;
			}
		}
	}

	// kinda makes sense in here
	public String mostrarAlquileres() {
		String text = "";

		for (int x = 0; x < arrayListAlquiler.size(); x++) {
			text += arrayListAlquiler.get(x).toString() + "\n";
		}

		return text;
	}
}
