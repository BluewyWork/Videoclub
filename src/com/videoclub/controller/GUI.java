package com.videoclub.controller;

import com.videoclub.util.Database;
import com.videoclub.view.PrincipalDesign;

import java.sql.Date;

public class GUI
{
	private SocioController socioController;
	private MultimediaController multimediaController;
	private AlquilerController alquilerController;
	private Database db;

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
		db = new Database(socioController, multimediaController, alquilerController);

		PrincipalDesign principalDesign = new PrincipalDesign(socioController, multimediaController, alquilerController);
		principalDesign.setVisible(true);
		principalDesign.setTitle("JAMA Videoclub");
		principalDesign.setBounds(300, 100, 900, 600);

	}
}
