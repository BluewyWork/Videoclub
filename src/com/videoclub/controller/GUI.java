package com.videoclub.controller;

import com.videoclub.model.Cancion;
import com.videoclub.model.Disco;
import com.videoclub.view.PrincipalDesign;

import java.util.ArrayList;

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

		Cancion a = new Cancion("Makapaka", 3);
		Cancion b = new Cancion("Waka", 2);
		Cancion c = new Cancion("Doremi", 65);
		Cancion d = new Cancion("AAAA", 1);
		Cancion e = new Cancion("Vaya", 94);
		Cancion f = new Cancion("kk", 12);

		ArrayList<Cancion> abc = new ArrayList<>();
		abc.add(a);
		abc.add(b);
		abc.add(c);
		ArrayList<Cancion> def = new ArrayList<>();
		def.add(d);
		def.add(e);
		def.add(f);

		multimediaController.altaDisco(abc);
		multimediaController.altaDisco(def);

		PrincipalDesign principalDesign = new PrincipalDesign(socioController, multimediaController, alquilerController);
		principalDesign.setVisible(true);
		principalDesign.setTitle("JAMA Videoclub");
		principalDesign.setBounds(300, 100, 900, 600);
	}
}
