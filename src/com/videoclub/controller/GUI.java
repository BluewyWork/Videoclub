/**
 * The `GUI` class represents the graphical user interface of the videoclub application. It initializes the necessary
 * controllers and sets up the main window.
 */
package com.videoclub.controller;

import com.videoclub.view.PrincipalDesign;

public class GUI
{
	private SocioController socioController;
	private MultimediaController multimediaController;
	private CancionController cancionController;
	private AlquilerController alquilerController;

	/**
	 * The entry point of the application.
	 *
	 * @param args Command line arguments.
	 */
	public static void main(String[] args)
	{
		GUI gui = new GUI();
		gui.run();
	}

	/**
	 * Initializes the controllers and sets up the main window of the application.
	 */
	public void run()
	{
		socioController = new SocioController();
		multimediaController = new MultimediaController();
		cancionController = new CancionController();
		alquilerController = new AlquilerController();

		PrincipalDesign principalDesign = new PrincipalDesign(socioController, multimediaController, cancionController, alquilerController);
		principalDesign.setVisible(true);
		principalDesign.setTitle("JAMA Videoclub");
		principalDesign.setBounds(300, 100, 900, 600);
	}
}