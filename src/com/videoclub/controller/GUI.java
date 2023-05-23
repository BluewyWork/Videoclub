package com.videoclub.controller;

import com.videoclub.view.ListadoMultimediaDesign;
import com.videoclub.view.ListadoSocioDesign;
import com.videoclub.view.AquilerDesign;

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
		listadoSocioDesign.setTitle("Listado Socio");
		listadoSocioDesign.setBounds(300, 100, 900, 600);

		multimediaController.altaPelicula("Iron man", "Chitan", "CD", 2023, 1234, "Actor", "Actora");
		multimediaController.altaVideojuego("uwu", "uwu2", "DVD", 12, "PC");

		ListadoMultimediaDesign listadoMultimediaDesign = new ListadoMultimediaDesign(socioController, multimediaController, alquilerController);
		listadoMultimediaDesign.setVisible(true);
		listadoMultimediaDesign.setTitle("Listado Multimedia");
		listadoMultimediaDesign.setBounds(300, 100, 900, 600);

		socioController.registrarSocio("1", "a", "10/10/2000", "uwu");

		AquilerDesign r = new AquilerDesign(socioController, multimediaController, alquilerController);
		r.setVisible(true);
		r.setTitle("Listado Alquiler");
		r.setBounds(300, 100, 900, 600);
	}
}
