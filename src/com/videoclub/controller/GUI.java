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

	private SocioController memberController;
	private MultimediaController multimediaController;
	private static IntroduccionView introduccionView;



	public static void main(String[] args)
	{
		GUI gui = new GUI();
		gui.run();
	}

	public void run()
	{
		introduccionView = new IntroduccionView();

		altasView = new AltasView();

		altasView.getBtnAltaASocio().addActionListener(this);
		altasView.getBtnAltaPelicula().addActionListener(this);
		altasView.getBtnAltaVideojuego().addActionListener(this);

		alquilerView = new AlquilerView();

		devolverView = new DevolverView();

		listarView = new ListarView();

		memberController = new SocioController();

		multimediaController = new MultimediaController();


		MenuView menuView = new MenuView(introduccionView, altasView, alquilerView, devolverView, listarView);

		menuView.setVisible(true);
		menuView.setBounds(250, 25, 1000, 780);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource().equals(altasView.getBtnAltaASocio()))
		{
			//memberControllear.registrarMiembros("minecraft", "minecraft", "03/10/2003", "minecraft");
			altaSocioView = new AltaSocioView(memberController);
			//memberController.registrarSocio("minecraft", "minecraft", "03/10/2003", "minecraft");
		}
		else if (e.getSource().equals(altasView.getBtnAltaPelicula()))
		{
			altaPeliculaView = new AltaPeliculaView(multimediaController);
		}
		else if (e.getSource().equals(altasView.getBtnAltaVideojuego()))
		{

		}
	}
}
