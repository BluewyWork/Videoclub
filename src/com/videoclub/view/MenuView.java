package com.videoclub.view;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuView extends JFrame implements ActionListener
{
	private final JPanel contentPane;
	private final CardLayout cardLayout;
	private final JButton buttonAltas;
	private final JButton buttonAlquilarMultimediaASocio;
	private final JButton buttonDevolverMultimedia;
	private final JButton buttonListar;
	private JMenuBar menuBar;
	private JMenu menuHome, menuAlta, menuListar, menuAlquilar, menuDevolver;
	private JMenuItem altaSocio, altaPelicula, altaVideojuego, listarMultimedia,
			listarPelicula, listarCancion, listarVideojuego, listarAlquiler, listarSocio;
	IntroduccionView panelIntroduccion;
	AltasView panelAltas;
	AltaPeliculaView panelPeliculas;

	public MenuView()
	{
		//Aquí se crea el menuBar
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
		//Aqui termina de crear e inicializar items, menus, etc...

		setJMenuBar(menuBar);
		setTitle("JAMA Videoclub");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);

		contentPane = new JPanel();
		cardLayout = new CardLayout();
		contentPane.setLayout(cardLayout);

		panelIntroduccion = new IntroduccionView();
		panelIntroduccion.setName("panelIntroduccion");
		contentPane.add(panelIntroduccion, "panelIntroduccion");

		panelAltas = new AltasView();
		panelAltas.setName("panelAltas");
		contentPane.add(panelAltas, "panelAltas");

		panelPeliculas = new AltaPeliculaView();
		panelPeliculas.setName("panelAltaPelicula");
		contentPane.add(panelPeliculas, "panelAltaPelicula");

		AlquilarMultiMediaSocioView panelAlquilarMultimediaASocio = new AlquilarMultiMediaSocioView();
		panelAlquilarMultimediaASocio.setName("panelAlquilarMultimediaASocio");
		contentPane.add(panelAlquilarMultimediaASocio, "panelAlquilarMultimediaASocio");

		DevolverMultimediaView panelDevolverMultimediaView = new DevolverMultimediaView();
		panelDevolverMultimediaView.setName("panelDevolverMultimediaView");
		contentPane.add(panelDevolverMultimediaView, "panelDevolverMultimediaView");

		ListarView panelListarView = new ListarView();
		panelListarView.setName("panelListarView");
		contentPane.add(panelListarView, "panelListarView");

		menuHome.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e)
			{

				cardLayout.show(contentPane, "panelIntroduccion");
			}

			@Override
			public void mousePressed(MouseEvent e)
			{

			}

			@Override
			public void mouseReleased(MouseEvent e)
			{

			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				menuHome.setPopupMenuVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e)
			{

			}
		});

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

		if (e.getSource() == menuHome)
		{
			panelName = "panelIntroduccion";
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
		else if (e.getSource() == buttonAltas)
		{
			panelName = "panelAltas";
		}

		cardLayout.show(contentPane, panelName);
	}

	public AltasView getPanelAltas()
	{
		return panelAltas;
	}
}