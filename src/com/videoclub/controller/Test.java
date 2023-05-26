package com.videoclub.controller;

import com.videoclub.util.Logger;
import com.videoclub.view.AltaPeliculaDesign;
import com.videoclub.view.AltaSocioDesign;
import com.videoclub.view.AltaVideojuegoDesign;

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
		Logger.log("hitler");
	}
}
