package com.videoclub.view;

import java.awt.*;
import javax.swing.*;

public class AltasDesign extends JPanel {

	private JButton buttonAltaASocio;
	private JButton buttonAltaPelicula;
	private JButton buttonAltaVideojuego;

	public AltasDesign() {
		initializeComponents();
	}

	public void initializeComponents() {

		setLayout(new GridLayout(2, 2));

		buttonAltaASocio = new JButton("Alta a Socio");
		add(buttonAltaASocio);

		buttonAltaPelicula = new JButton("Alta a Pelicula");
		add(buttonAltaPelicula);

		buttonAltaVideojuego = new JButton("Alta a Videojuego");
		add(buttonAltaVideojuego);
	}

	public JButton getButtonAltaASocio() {
		return buttonAltaASocio;
	}

	public void setButtonAltaASocio(JButton buttonAltaASocio) {
		this.buttonAltaASocio = buttonAltaASocio;
	}

	public JButton getButtonAltaPelicula() {
		return buttonAltaPelicula;
	}

	public void setButtonAltaPelicula(JButton buttonAltaPelicula) {
		this.buttonAltaPelicula = buttonAltaPelicula;
	}

	public JButton getButtonAltaVideojuego() {
		return buttonAltaVideojuego;
	}

	public void setButtonAltaVideojuego(JButton buttonAltaVideojuego) {
		this.buttonAltaVideojuego = buttonAltaVideojuego;
	}
}