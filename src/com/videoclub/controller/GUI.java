package com.videoclub.controller;

import com.videoclub.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener
{
	private AltasView altasView;
	private AlquilerView alquilerView;
	private DevolverView devolverView;
	private ListarView listarView;
	private AltaSocioView altaSocioView;
	private AltaPeliculaView altaPeliculaView;
	private AltaVideojuegoView altaVideojuegoView;

	private SocioController socioController;
	private MultimediaController multimediaController;
	private AlquilerController alquilerController;
	private static IntroduccionView introduccionView;

	public static void main(String[] args)
	{
		GUI gui = new GUI();
		gui.run();
	}

	public void run()
	{
		socioController = new SocioController();
		multimediaController = new MultimediaController();
		alquilerController = new AlquilerController();

		altasView = new AltasView(socioController, multimediaController);
		altasView.getBtnAltaASocio().addActionListener(this);
		altasView.getBtnAltaPelicula().addActionListener(this);
		altasView.getBtnAltaVideojuego().addActionListener(this);

		alquilerView = new AlquilerView(socioController, multimediaController, alquilerController);

		devolverView = new DevolverView(socioController, multimediaController, alquilerController);

		listarView = new ListarView(socioController, multimediaController, alquilerController);

		// other panels
		introduccionView = new IntroduccionView(socioController, multimediaController);

		MenuView menuView = new MenuView(introduccionView, altasView, alquilerView, devolverView, listarView);

		menuView.setVisible(true);
		menuView.setBounds(250, 25, 1000, 780);
		menuView.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource().equals(altasView.getBtnAltaASocio()))
		{
			//memberControllear.registrarMiembros("minecraft", "minecraft", "03/10/2003", "minecraft");
			altaSocioView = new AltaSocioView(socioController);
			//memberController.registrarSocio("minecraft", "minecraft", "03/10/2003", "minecraft");
		}
		else if (e.getSource().equals(altasView.getBtnAltaPelicula()))
		{
			altaPeliculaView = new AltaPeliculaView(multimediaController);
			altaPeliculaView.setVisible(true);
			altaPeliculaView.setBounds(100, 100, 500, 500);
		}
		else if (e.getSource().equals(altasView.getBtnAltaVideojuego()))
		{
			altaVideojuegoView = new AltaVideojuegoView(multimediaController);
		}
	}
}
