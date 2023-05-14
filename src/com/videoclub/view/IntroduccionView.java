package com.videoclub.view;

import javax.swing.*;
import java.awt.*;

public class IntroduccionView extends JPanel
{
	private JMenuBar menuBar;
	private JMenu menuHome, menuAlta, menuListar, menuAlquilar, menuDevolver;
	private JMenuItem altaSocio, altaPelicula, altaVideojuego, listarMultimedia,
			listarPelicula, listarCancion, listarVideojuego, listarAlquiler, listarSocio;
	private JLabel lblHomePage;
	private JTextArea txtArea;

	public IntroduccionView()
	{
		menuBar = new JMenuBar();
		menuHome = new JMenu("Home");
		menuAlta = new JMenu("Altas");
		menuAlquilar = new JMenu("Alquilar Multimedia");
		menuDevolver = new JMenu("Devolver Multimedia");
		altaSocio = new JMenuItem("Alta de socio");
		altaPelicula = new JMenuItem("Alta de pelicula");
		altaVideojuego = new JMenuItem("Alta de videojuego");
		menuAlta.add(altaSocio);
		menuAlta.add(altaPelicula);
		menuAlta.add(altaVideojuego);
		menuListar = new JMenu("Listar");
		listarMultimedia = new JMenuItem("Todos los objetos multimedia");
		listarPelicula = new JMenuItem("Todas las peliculas ordenados por título");
		listarCancion = new JMenuItem("Todas las canciones de un disco por duración");
		listarVideojuego = new JMenuItem("Todos los videojuegos ordenados por año");
		listarAlquiler = new JMenuItem("Los alquileres actuales de un socio");
		listarSocio = new JMenuItem("Los socios con recargos pendientes");
		menuListar.add(listarMultimedia);
		menuListar.add(listarPelicula);
		menuListar.add(listarCancion);
		menuListar.add(listarVideojuego);
		menuListar.add(listarAlquiler);
		menuListar.add(listarSocio);
		menuAlquilar = new JMenu("Alquilar");
		menuDevolver = new JMenu("Devolver");

		menuBar.add(menuHome);
		menuBar.add(menuAlta);
		menuBar.add(menuAlquilar);
		menuBar.add(menuDevolver);
		menuBar.add(menuListar);

		lblHomePage = new JLabel();
		/*
		lblHomePage.setIcon(new ImageIcon("CodeSpeedy.jpg")); //Sets the image to be displayed as an icon
		Dimension size = lblHomePage.getPreferredSize(); //Gets the size of the image
		lblHomePage.setBounds(50, 30, size.width, size.height); //Sets the location of the image
		*/
	}
}
