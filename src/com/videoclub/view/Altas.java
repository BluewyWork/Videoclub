package com.videoclub.view;

import java.awt.*;
import javax.swing.*;

public class Altas extends JPanel {

	JButton buttonAltaASocio;
	JButton buttonAltaPelicula;
	JButton buttonAltaVideojuego;

	public Altas() {
		setLayout(new GridLayout(2, 2));

		buttonAltaASocio = new JButton("Alta a Socio");
		add(buttonAltaASocio);

		buttonAltaPelicula = new JButton("Alta a Pelicula");
		add(buttonAltaPelicula);

		buttonAltaVideojuego = new JButton("Alta a Videojuego");
		add(buttonAltaVideojuego);
	}
}