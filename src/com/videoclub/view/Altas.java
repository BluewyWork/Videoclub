package com.videoclub.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Altas extends JPanel implements ActionListener {

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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
	}
}
