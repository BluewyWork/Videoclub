package com.videoclub.controller;

import com.videoclub.model.Inventario;

public class InventarioController {

	private Inventario myInventario;

	public InventarioController() {
		myInventario = new Inventario();
	}

	public void createMultimedia(String type, String titulo, String autor, String formato, int anyo, int duracion, String actorPrincipal, String actrizPrincipal, String plataforma) {
		switch (type.toLowerCase()) {
			case "pelicula":
				myInventario.anadirMultimedia(type, titulo, autor, formato, anyo, duracion, actorPrincipal, actrizPrincipal, plataforma);
				break; 
			case "videojuego":
				myInventario.anadirMultimedia(type, titulo, autor, formato, anyo, duracion, actorPrincipal, actrizPrincipal, plataforma);
				break;
		}
	}
}
