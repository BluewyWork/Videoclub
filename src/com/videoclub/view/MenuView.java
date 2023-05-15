package com.videoclub.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuView extends JFrame implements ActionListener, MouseListener
{
	private JPanel contentPane;
	private CardLayout cardLayout;
	private JButton buttonAltas;
	private JButton buttonAlquilarMultimediaASocio;
	private JButton buttonDevolverMultimedia;
	private JButton buttonListar;
	private JMenuBar menuBar;
	private JMenu menuHome, menuAlta, menuListar, menuAlquilar, menuDevolver;
	private JMenuItem altaSocio, altaPelicula, altaVideojuego, listarMultimedia,
			listarPelicula, listarCancion, listarVideojuego, listarAlquiler, listarSocio;
	IntroduccionView introduccionView;
	AltasView altasView;
	AlquilerView alquilerView;
	DevolverView devolverView;
	ListarView listarView;

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

		setJMenuBar(menuBar);

		contentPane = new JPanel();
		cardLayout = new CardLayout();
		contentPane.setLayout(cardLayout);

		introduccionView.setName("IntroduccionView");
		contentPane.add(introduccionView, "IntroduccionView");

		altasView.setName("altasView");
		contentPane.add(altasView, "altasView");

		alquilerView.setName("alquilerView");
		contentPane.add(alquilerView, "alquilerView");

		devolverView.setName("devolverView");
		contentPane.add(devolverView, "devolverView");

		listarView.setName("listaView");
		contentPane.add(listarView, "listaView");

		menuHome.addMouseListener(this);

		buttonAltas = new JButton("Altas");
		buttonAltas.addActionListener(this);

		buttonAlquilarMultimediaASocio = new JButton("Alquilar Multimedia\na Socio");
		buttonAlquilarMultimediaASocio.addActionListener(this);

		buttonDevolverMultimedia = new JButton("Delvolver Multimedia");
		buttonDevolverMultimedia.addActionListener(this);

		buttonListar = new JButton("Listar");
		buttonListar.addActionListener(this);

		JPanel buttonPanel = new JPanel();
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
			panelName = "panelAltas";
		}
		else if (e.getSource() == buttonAltas)
		{
			panelName = "panelAlquilarMultimediaASocio";
		}
		else if (e.getSource() == buttonAlquilarMultimediaASocio)
		{
			panelName = "panelAlquilarMultimediaASocio";
		}
		else if (e.getSource() == buttonDevolverMultimedia)
		{
			panelName = "panelDevolverMultimedia";
		}
		else if (e.getSource() == buttonListar)
		{
			panelName = "panelListar";
		}

		cardLayout.show(contentPane, panelName);
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		if (e.getSource() == menuHome)
			cardLayout.show(contentPane, "panelIntroduccion");
		else if (e.getSource() == altaPelicula)
			cardLayout.show(contentPane, "panelAltaPelicula");
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{

	}

	@Override
	public void mouseExited(MouseEvent e)
	{

	}
}