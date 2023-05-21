package com.videoclub.controller;

import com.videoclub.view.LookUpDesign;
import com.videoclub.view.old.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI
{
	private static IntroduccionView introduccionView;
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

		socioController.registrarSocio("123","Chitan", "12/12/1999", "Algo");

		LookUpDesign lookUpDesign = new LookUpDesign(socioController, multimediaController, alquilerController);
		lookUpDesign.setVisible(true);
		lookUpDesign.setBounds(100, 100, 900, 900);
	}
}
