package com.videoclub.view;

import com.videoclub.controller.AlquilerController;
import com.videoclub.controller.CancionController;
import com.videoclub.controller.MultimediaController;
import com.videoclub.controller.SocioController;
import com.videoclub.util.Database;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase PrincipalDesign representa la interfaz principal de la aplicación del videoclub. Extiende la clase JFrame y
 * se encarga de gestionar los eventos y las acciones de los elementos de la interfaz.
 */
public class PrincipalDesign extends JFrame implements ActionListener
{
	// Componentes de la interfaz
	private AltaSocioDesign altaSocioDesign;
	private AltaPeliculaDesign altaPeliculaDesign;
	private AltaVideojuegoDesign altaVideojuegoDesign;
	private AltaCancionDesign altaCancionDesign;
	private AltaDiscoDesign altaDiscoDesign;
	private AddCancionDiscoDesign addCancionDiscoDesign;
	private AlquilerDesign alquilerDesign;
	private DevolverDesign devolverDesign;
	private ListadoSocioDesign listadoSocioDesign;
	private ListadoMultimediaDesign listadoMultimediaDesign;
	private ListadoPeliculaDesign listadoPeliculaDesign;
	private ListadoCancionDesign listadoCancionDesign;
	private ListadoVideojuegoDesign listadoVideojuegoDesign;
	private ListadoAlquilerSocioDesign listadoAlquilerSocioDesign;
	private ListadoSocioRecargoDesign listadoSocioRecargoDesign;

	// Controladores y base de datos
	private final SocioController socioController;
	private final MultimediaController multimediaController;
	private final CancionController cancionController;
	private final AlquilerController alquilerController;
	private Database db;

	// Elementos de la interfaz
	private JButton btnGuardar;
	private JPanel panel;
	private JMenuBar menuBar;
	private JMenu menuSocio, menuMultimedia, menuListar, menuAlquilar, menuDevolver;
	private JMenuItem altaSocio, listadoSocio, altaPelicula, altaVideojuego, altaCancion, altaDisco, addCancionToDisco, alquilar, devolver;
	private JMenuItem listarMultimedia, listarPelicula, listarCancion, listarVideojuego, listarAlquiler, listarSocio;

	/**
	 * Constructor de la clase PrincipalDesign.
	 *
	 * @param sc Controlador de socios
	 * @param mc Controlador de multimedia
	 * @param cc Controlador de canciones
	 * @param ac Controlador de alquileres
	 */
	public PrincipalDesign(SocioController sc, MultimediaController mc, CancionController cc, AlquilerController ac)
	{
		socioController = sc;
		multimediaController = mc;
		cancionController = cc;
		alquilerController = ac;
		initComponents();
	}

	/**
	 * Inicializa los componentes de la interfaz y configura la base de datos.
	 */
	public void initComponents()
	{
		// Creación de los componentes de la interfaz
		altaSocioDesign = new AltaSocioDesign(socioController);
		altaPeliculaDesign = new AltaPeliculaDesign(multimediaController);
		altaVideojuegoDesign = new AltaVideojuegoDesign(multimediaController);
		altaCancionDesign = new AltaCancionDesign(cancionController);
		altaDiscoDesign = new AltaDiscoDesign(multimediaController);
		addCancionDiscoDesign = new AddCancionDiscoDesign(multimediaController, cancionController);
		alquilerDesign = new AlquilerDesign(socioController, multimediaController, alquilerController);
		devolverDesign = new DevolverDesign(socioController, multimediaController, alquilerController);
		listadoSocioDesign = new ListadoSocioDesign(socioController, multimediaController, alquilerController);
		listadoMultimediaDesign = new ListadoMultimediaDesign(socioController, multimediaController, alquilerController);
		listadoPeliculaDesign = new ListadoPeliculaDesign(socioController, multimediaController, alquilerController);
		listadoCancionDesign = new ListadoCancionDesign(multimediaController, cancionController);
		listadoVideojuegoDesign = new ListadoVideojuegoDesign(socioController, multimediaController, alquilerController);
		listadoAlquilerSocioDesign = new ListadoAlquilerSocioDesign(socioController, multimediaController, alquilerController);
		listadoSocioRecargoDesign = new ListadoSocioRecargoDesign(socioController, multimediaController, alquilerController);

		panel = new JPanel();
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);

		// Configuración de la ventana principal
		this.add(panel);
		panel.add(btnGuardar);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setTitle("JAMA Videoclub");

		// Configuración del menú
		initMenuBar();

		// Configuración de la base de datos
		db = new Database(socioController, multimediaController, alquilerController, cancionController);
		db.loadSocios();
		db.loadPeliculas();
		db.loadVideojuegos();
		db.loadDiscos();
	}

	/**
	 * Inicializa la barra de menú de la interfaz y configura los elementos del menú.
	 */
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
		altaCancion = new JMenuItem("Alta de cancion");
		altaDisco = new JMenuItem("Alta de disco");
		addCancionToDisco = new JMenuItem("Añadir cancion a Disco");

		menuSocio.add(altaSocio);
		menuSocio.add(listadoSocio);

		menuMultimedia.add(altaPelicula);
		menuMultimedia.add(altaVideojuego);
		menuMultimedia.add(altaCancion);
		menuMultimedia.add(altaDisco);
		menuMultimedia.add(addCancionToDisco);

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
		altaCancion.addActionListener(this);
		altaDisco.addActionListener(this);
		addCancionToDisco.addActionListener(this);

		alquilar.addActionListener(this);
		devolver.addActionListener(this);

		listadoSocio.addActionListener(this);
		listarMultimedia.addActionListener(this);
		listarPelicula.addActionListener(this);
		listarCancion.addActionListener(this);
		listarVideojuego.addActionListener(this);
		listarAlquiler.addActionListener(this);
		listarSocio.addActionListener(this);

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
		else if (e.getSource().equals(altaCancion))
		{
			altaCancionDesign.setVisible(true);
		}
		else if (e.getSource().equals(altaDisco))
		{
			altaDiscoDesign.setVisible(true);
		}
		else if (e.getSource().equals(addCancionToDisco))
		{
			addCancionDiscoDesign.refreshComboBox();
			addCancionDiscoDesign.setVisible(true);
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
			listadoCancionDesign.refreshComboBox();
			listadoCancionDesign.setVisible(true);
		}
		else if (e.getSource().equals(listarVideojuego))
		{
			listadoVideojuegoDesign.refreshTable();
			listadoVideojuegoDesign.setVisible(true);
		}
		else if (e.getSource().equals(listarAlquiler))
		{
			listadoAlquilerSocioDesign.setVisible(true);
		}
		else if (e.getSource().equals(listarSocio))
		{
			listadoSocioRecargoDesign.setVisible(true);
		}
		else if (e.getSource().equals(btnGuardar))
		{
			db.updateSocioTable();
			db.updateTableVideojuego();
			db.updateTablePelicula();
			db.updateTableDisco();
			db.updateTableCancion();
		}
	}
}
