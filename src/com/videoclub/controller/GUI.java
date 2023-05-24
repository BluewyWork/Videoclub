package com.videoclub.controller;

import com.videoclub.view.PrincipalDesign;

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

		socioController.registrarSocio("123", "Chitan", "12/12/1999", "China");
		socioController.registrarSocio("1", "a", "10/10/2000", "Beni");

		multimediaController.altaPelicula("Iron man", "Chitan", "CD", 2023, 1234, "Actor", "Actora");
		multimediaController.altaPelicula("Iron Gay", "Chitan", "CD", 2023, 1234, "Actor", "Actora");

		multimediaController.altaVideojuego("Mario karts", "uwu2", "DVD", 12, "PC");

		PrincipalDesign principalDesign = new PrincipalDesign(socioController, multimediaController, alquilerController);
		principalDesign.setVisible(true);
		principalDesign.setTitle("JAMA Videoclub");
		principalDesign.setBounds(300, 100, 900, 600);
	}
}
