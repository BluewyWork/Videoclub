package com.videoclub.view.old;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuView extends JFrame implements ActionListener
{
	IntroduccionView introduccionView;
	AltasView altasView;
	AlquilerView alquilerView;
	DevolverView devolverView;
	ListarView listarView;
	private JPanel contentPane;
	private JPanel buttonPanel;
	private CardLayout cardLayout;
	private JButton buttonAltas, buttonAlquilarMultimediaASocio, buttonDevolverMultimedia, buttonListar;
	private JMenuBar menuBar;
	private JMenu menuHome, menuAlta, menuListar, menuAlquilar, menuDevolver;
	private JMenuItem menuHome2;
	private JMenuItem altaSocio, altaPelicula, altaVideojuego;
	private JMenuItem listarMultimedia, listarPelicula, listarCancion, listarVideojuego, listarAlquiler, listarSocio;

	public MenuView()
	{
		initComponents();
	}

	public MenuView(IntroduccionView iv, AltasView nv, AlquilerView rv, DevolverView rrv, ListarView lv)
	{
		introduccionView = iv;
		altasView = nv;
		alquilerView = rv;
		devolverView = rrv;
		listarView = lv;

		initComponents();
	}

	public void initComponents()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setTitle("JAMA Videoclub");
		initMenuBar();
		initPanel();
	}

	public void initMenuBar()
	{
		menuBar = new JMenuBar();
		menuHome = new JMenu("Home");
		menuAlta = new JMenu("Altas");
		menuAlquilar = new JMenu("Alquilar Multimedia");
		menuDevolver = new JMenu("Devolver Multimedia");
		menuHome2 = new JMenuItem("Aqui!");
		altaSocio = new JMenuItem("Alta de socio");
		altaSocio.addActionListener(this);
		altaPelicula = new JMenuItem("Alta de pelicula");
		altaVideojuego = new JMenuItem("Alta de videojuego");

		menuHome.add(menuHome2);

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

		setJMenuBar(menuBar);
	}

	public void initPanel()
	{
		contentPane = new JPanel();
		cardLayout = new CardLayout();
		contentPane.setLayout(cardLayout);

		introduccionView.setName("introduccionView");
		contentPane.add(introduccionView, "introduccionView");

		altasView.setName("altasView");
		contentPane.add(altasView, "altasView");

		alquilerView.setName("alquilerView");
		contentPane.add(alquilerView, "alquilerView");

		devolverView.setName("devolverView");
		contentPane.add(devolverView, "devolverView");

		listarView.setName("listaView");
		contentPane.add(listarView, "listaView");

		buttonAltas = new JButton("Altas");
		buttonAltas.addActionListener(this);

		buttonAlquilarMultimediaASocio = new JButton("Alquilar Multimedia\na Socio");
		buttonAlquilarMultimediaASocio.addActionListener(this);

		buttonDevolverMultimedia = new JButton("Delvolver Multimedia");
		buttonDevolverMultimedia.addActionListener(this);

		buttonListar = new JButton("Listar");
		buttonListar.addActionListener(this);

		buttonPanel = new JPanel();
		buttonPanel.add(buttonAltas);
		buttonPanel.add(buttonAlquilarMultimediaASocio);
		buttonPanel.add(buttonDevolverMultimedia);
		buttonPanel.add(buttonListar);

		add(contentPane, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e)
	{
		String panelName = "";

		if (e.getSource() == buttonAltas)
		{
			panelName = "altasView";
		}
		else if (e.getSource() == buttonAlquilarMultimediaASocio)
		{
			panelName = "alquilerView";
		}
		else if (e.getSource() == buttonDevolverMultimedia)
		{
			panelName = "devolverView";
		}
		else if (e.getSource() == buttonListar)
		{
			panelName = "listaView";
		}
		else if (e.getSource().equals(menuHome))
		{
			System.exit(0);
		}
		else if (e.getSource().equals(altaSocio))
		{
			System.exit(0);
		}

		cardLayout.show(contentPane, panelName);
	}
}