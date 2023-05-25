package com.videoclub.view;

import com.videoclub.controller.AlquilerController;
import com.videoclub.controller.MultimediaController;
import com.videoclub.controller.SocioController;
import com.videoclub.model.Multimedia;
import com.videoclub.util.Database;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PrincipalDesign extends JFrame implements ActionListener
{
	private JButton btnGuardar;
	private JPanel panel;
	private JMenuBar menuBar;
	private JMenu menuSocio, menuMultimedia, menuListar, menuAlquilar, menuDevolver;
	private JMenuItem altaSocio, listadoSocio, altaPelicula, altaVideojuego, alquilar, devolver;
	private JMenuItem listarMultimedia, listarPelicula, listarCancion, listarVideojuego, listarAlquiler, listarSocio;
	AltaSocioDesign altaSocioDesign;
	AltaPeliculaDesign altaPeliculaDesign;
	AltaVideojuegoDesign altaVideojuegoDesign;

	AlquilerDesign alquilerDesign;
	DevolverDesign devolverDesign;
	ListadoSocioDesign listadoSocioDesign;
	ListadoMultimediaDesign listadoMultimediaDesign;
	ListadoPeliculaDesign listadoPeliculaDesign;
	ListadoCancionDesign listadoCancionDesign;
	ListadoVideojuegoDesign listadoVideojuegoDesign;
	ListadoAlquilerSocioDesign listadoAlquilerSocioDesign;

	SocioController socioController;
	MultimediaController multimediaController;
	AlquilerController alquilerController;

	Database db;

	public PrincipalDesign(SocioController sc, MultimediaController mc, AlquilerController ac)
	{
		socioController = sc;
		multimediaController = mc;
		alquilerController = ac;

		initComponents();
	}

	public void initComponents()
	{
		altaSocioDesign = new AltaSocioDesign(socioController);
		altaPeliculaDesign = new AltaPeliculaDesign(multimediaController);
		altaVideojuegoDesign = new AltaVideojuegoDesign(multimediaController);

		alquilerDesign = new AlquilerDesign(socioController, multimediaController, alquilerController);
		devolverDesign = new DevolverDesign(socioController, multimediaController, alquilerController);
		listadoSocioDesign = new ListadoSocioDesign(socioController, multimediaController, alquilerController);
		listadoMultimediaDesign = new ListadoMultimediaDesign(socioController, multimediaController, alquilerController);
		listadoPeliculaDesign = new ListadoPeliculaDesign(socioController, multimediaController, alquilerController);
		listadoCancionDesign = new ListadoCancionDesign(multimediaController);
		listadoVideojuegoDesign = new ListadoVideojuegoDesign(socioController, multimediaController, alquilerController);
		listadoAlquilerSocioDesign = new ListadoAlquilerSocioDesign(socioController, multimediaController, alquilerController);

		panel = new JPanel();
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);

		this.add(panel);
		panel.add(btnGuardar);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setTitle("JAMA Videoclub");
		initMenuBar();

		db = new Database(socioController, multimediaController, alquilerController);
		db.loadSocios();
		db.loadPeliculas();
		db.loadVideojuegos();

	}

	public void initMenuBar()
	{
		menuBar = new JMenuBar();
		menuSocio = new JMenu("Socio");
		menuMultimedia = new JMenu("Multimedia");
		menuAlquilar = new JMenu("Alquilar");
		menuDevolver = new JMenu("Devolver");

		alquilar = new JMenuItem("Alquilar multimedia a socio");
		devolver = new JMenuItem("Devolver multimedia de socio");
		altaSocio = new JMenuItem("Alta de socio");
		listadoSocio = new JMenuItem("Listado de socio");
		altaPelicula = new JMenuItem("Alta de pelicula");
		altaVideojuego = new JMenuItem("Alta de videojuego");

		menuSocio.add(altaSocio);
		menuSocio.add(listadoSocio);

		menuMultimedia.add(altaPelicula);
		menuMultimedia.add(altaVideojuego);

		menuAlquilar.add(alquilar);
		menuDevolver.add(devolver);

		menuListar = new JMenu("Listados");
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

		menuBar.add(menuSocio);
		menuBar.add(menuMultimedia);
		menuBar.add(menuAlquilar);
		menuBar.add(menuDevolver);
		menuBar.add(menuListar);

		altaSocio.addActionListener(this);
		altaPelicula.addActionListener(this);
		altaVideojuego.addActionListener(this);

		alquilar.addActionListener(this);
		devolver.addActionListener(this);
		listadoSocio.addActionListener(this);
		listarMultimedia.addActionListener(this);
		listarPelicula.addActionListener(this);
		listarCancion.addActionListener(this);
		listarVideojuego.addActionListener(this);
		listarAlquiler.addActionListener(this);

		setJMenuBar(menuBar);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource().equals(altaSocio))
		{
			altaSocioDesign.setVisible(true);
		}
		else if (e.getSource().equals(altaPelicula))
		{
			altaPeliculaDesign.setVisible(true);
		}
		else if (e.getSource().equals(altaVideojuego))
		{
			altaVideojuegoDesign.setVisible(true);
		}
		else if (e.getSource().equals(alquilar))
		{
			alquilerDesign.setVisible(true);
		}
		else if (e.getSource().equals(devolver))
		{
			devolverDesign.setVisible(true);
		}
		else if (e.getSource().equals(listadoSocio))
		{
			listadoSocioDesign.setVisible(true);
		}
		else if (e.getSource().equals(listarMultimedia))
		{
			listadoMultimediaDesign.setVisible(true);
		}
		else if (e.getSource().equals(listarPelicula))
		{
			listadoPeliculaDesign.refreshTable();
			listadoPeliculaDesign.setVisible(true);
		}
		else if (e.getSource().equals(listarCancion))
		{
			listadoCancionDesign.setVisible(true);
		}
		else if (e.getSource().equals(listarVideojuego))
		{
			listadoVideojuegoDesign.setVisible(true);
		}
		else if (e.getSource().equals(listarAlquiler))
		{
			listadoAlquilerSocioDesign.setVisible(true);
		}
		else if (e.getSource().equals(btnGuardar))
		{
			db.updateSocioTable();
			db.updateTableVideojuego();
			db.updateTablePelicula();
		}
	}
}
