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

		// Test Canciones y disco
		/*Cancion a = new Cancion("Makapaka", 3);
		Cancion b = new Cancion("Waka", 2);
		Cancion c = new Cancion("Doremi", 65);
		Cancion y = new Cancion("Hola", 0);
		Cancion d = new Cancion("AAAA", 1);
		Cancion e = new Cancion("Vaya", 94);
		Cancion f = new Cancion("kk", 12);
		Cancion x = new Cancion("Adios", 0);

		ArrayList<Cancion> abc = new ArrayList<>();
		abc.add(a);
		abc.add(b);
		abc.add(c);
		abc.add(y);
		ArrayList<Cancion> def = new ArrayList<>();
		def.add(d);
		def.add(e);
		def.add(x);
		def.add(f);

		multimediaController.altaDisco("Disco 1", "Chitan", "CD", 2020, abc);
		multimediaController.altaDisco("Disco 2", "Chitan", "DVD", 2022, def);*/
		// Aqui acaba el test

		PrincipalDesign principalDesign = new PrincipalDesign(socioController, multimediaController, alquilerController);
		principalDesign.setVisible(true);
		principalDesign.setTitle("JAMA Videoclub");
		principalDesign.setBounds(300, 100, 900, 600);
	}
}
