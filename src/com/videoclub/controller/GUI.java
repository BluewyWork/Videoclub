package com.videoclub.controller;

import com.videoclub.model.Cancion;
import com.videoclub.view.PrincipalDesign;

import java.util.ArrayList;

public class GUI
{
	private SocioController socioController;
	private MultimediaController multimediaController;
	private CancionController cancionController;
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
		cancionController = new CancionController();
		alquilerController = new AlquilerController();

		multimediaController.altaDisco("Disco hardcode", "Chitan", "CD", 2023, new ArrayList<Cancion>());

		PrincipalDesign principalDesign = new PrincipalDesign(socioController, multimediaController, cancionController, alquilerController);
		principalDesign.setVisible(true);
		principalDesign.setTitle("JAMA Videoclub");
		principalDesign.setBounds(300, 100, 900, 600);
	}
}
