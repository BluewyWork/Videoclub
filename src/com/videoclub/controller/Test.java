package com.videoclub.controller;

import com.videoclub.model.Socio;
import com.videoclub.view.AltaPeliculaDesign;
import com.videoclub.view.AltaSocioDesign;
import com.videoclub.view.AltaVideojuegoDesign;

import java.awt.*;

public class Test
{
	AltaPeliculaDesign altaPeliculaDesign;
	AltaVideojuegoDesign altaVideojuegoDesign;
	AltaSocioDesign altaSocioDesign;
	MultimediaController multimediaController;
	SocioController socioController;

	public static void main(String[] args)
	{
		Test gui = new Test();
		gui.run();
	}

	public void run()
	{
		multimediaController = new MultimediaController();
		altaPeliculaDesign = new AltaPeliculaDesign(multimediaController);
		altaPeliculaDesign.setVisible(true);
		altaPeliculaDesign.setBounds(300, 100, 800, 500);
		altaPeliculaDesign.getContentPane().setBackground(Color.black);

		multimediaController = new MultimediaController();
		altaVideojuegoDesign = new AltaVideojuegoDesign(multimediaController);
		altaVideojuegoDesign.setVisible(true);
		altaVideojuegoDesign.setBounds(300, 100, 800, 500);
		altaVideojuegoDesign.getContentPane().setBackground(Color.blue);

		socioController = new SocioController();
		altaSocioDesign = new AltaSocioDesign(socioController);
		altaSocioDesign.setVisible(true);
		altaSocioDesign.setBounds(300, 100, 800, 500);
		altaSocioDesign.getContentPane().setBackground(Color.pink);
	}
}
