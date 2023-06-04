/**
 La clase GUI representa la interfaz gráfica de usuario de la aplicación del videoclub. Inicializa los controladores
 necesarios y configura la ventana principal.
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
	 * Punto de entrada de la aplicación.
	 *
	 * @param args Argumentos de línea de comandos.
	 */
	public static void main(String[] args)
	{
		GUI gui = new GUI();
		gui.run();
	}

	/**
	 * Inicializa los controladores y configura la ventana principal de la aplicación.
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