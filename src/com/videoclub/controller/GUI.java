package com.videoclub.controller;

import com.videoclub.view.AquilerDesign;
import com.videoclub.view.ListadoSocioDesign;

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

		socioController.registrarSocio("123", "Chitan", "12/12/1999", "Algo");

		ListadoSocioDesign listadoSocioDesign = new ListadoSocioDesign(socioController, multimediaController, alquilerController);
		listadoSocioDesign.setVisible(true);
		listadoSocioDesign.setBounds(300, 100, 900, 600);

		socioController.registrarSocio("1", "a", "10/10/2000", "uwu");
		multimediaController.altaVideojuego("uwu", "uwu2", "DVD", 12, "PC");

		AquilerDesign r = new AquilerDesign(socioController, multimediaController, alquilerController);
		r.setVisible(true);
		r.setBounds(100, 100, 900, 900);
	}
}
