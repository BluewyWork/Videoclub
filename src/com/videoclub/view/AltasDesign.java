package com.videoclub.view;

import java.awt.*;
import javax.swing.*;

public class AltasDesign extends JPanel {

	private JButton buttonAltaASocio;
	private JButton buttonAltaPelicula;
	private JButton buttonAltaVideojuego;

	public AltasDesign() {
		initComponents();
	}

	public void initComponents() {
		setLayout(new GridLayout(2, 2));

		buttonAltaASocio = new JButton("Alta a Socio");
		add(buttonAltaASocio);

		buttonAltaPelicula = new JButton("Alta a Pelicula");
		add(buttonAltaPelicula);

		buttonAltaVideojuego = new JButton("Alta a Videojuego");
		add(buttonAltaVideojuego);
	}
}