package com.videoclub.view;

import java.awt.*;
import javax.swing.*;

public class AltasView extends JPanel
{

	private JButton buttonAltaASocio;
	private JButton buttonAltaPelicula;
	private JButton buttonAltaVideojuego;

	public AltasView()
	{
		initComponents();
	}

	public void initComponents()
	{
		setLayout(new GridLayout(2, 2));

		buttonAltaASocio = new JButton("Alta a Socio");
		add(buttonAltaASocio);

		buttonAltaPelicula = new JButton("Alta a Pelicula");
		add(buttonAltaPelicula);

		buttonAltaVideojuego = new JButton("Alta a Videojuego");
		add(buttonAltaVideojuego);
	}

	public JButton getButtonAltaASocio()
	{
		return buttonAltaASocio;
	}

	public JButton getButtonAltaPelicula()
	{
		return buttonAltaPelicula;
	}

	public JButton getButtonAltaVideojuego()
	{
		return buttonAltaVideojuego;
	}
}