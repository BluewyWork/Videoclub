package com.videoclub.model;

import java.util.ArrayList;

public class Inventario {

	private ArrayList<Multimedia> arrayListMultimedia;

	public Inventario() {
		arrayListMultimedia = new ArrayList<>();
	}

	public ArrayList<Multimedia> getArrayListMultimedia() {
		return arrayListMultimedia;
	}

	public void setArrayListMultimedia(ArrayList<Multimedia> arrayListMultimedia) {
		this.arrayListMultimedia = arrayListMultimedia;
	}

	public void anadirMultimedia(String type, String titulo, String autor, String formato, int anyo, int duracion, String actorPrincipal, String actrizPrincipal, String plataforma) {
		switch(type.toLowerCase()) {
			case "pelicula":
				Pelicula myPelicula = new Pelicula(titulo, autor, formato, anyo, duracion, actorPrincipal, actrizPrincipal);
				arrayListMultimedia.add(myPelicula);
				break;
			case "videojuego":
				Videojuego myVideojuego = new Videojuego(titulo, autor, formato, anyo, plataforma);
				arrayListMultimedia.add(myVideojuego);
		}
		
	}
}
