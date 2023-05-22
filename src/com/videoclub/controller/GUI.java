package com.videoclub.controller;

import com.videoclub.view.LookUpDesign;
import com.videoclub.view.RentDesign;

public class GUI
{

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

		LookUpDesign lookUpDesign = new LookUpDesign(socioController, multimediaController, alquilerController);
		lookUpDesign.setVisible(false);
		lookUpDesign.setBounds(100, 100, 900, 900);

		socioController.registrarSocio("1","a","10/10/2000", "uwu");
		multimediaController.altaVideojuego("uwu", "uwu2", "DVD", 12, "PC");

		RentDesign r = new RentDesign(socioController, multimediaController, alquilerController);
		r.setVisible(true);
		r.setBounds(100,100,900,900);
	}
}
