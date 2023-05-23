package com.videoclub.controller;

import com.videoclub.view.AltaPeliculaMainView;
import com.videoclub.view.AltaVideojuegoMainView;

import java.awt.*;

public class Test
{
	AltaPeliculaMainView altaPeliculaMainView;
	AltaVideojuegoMainView altaVideojuegoMainView;
	MultimediaController multimediaController;

	public static void main(String[] args)
	{
		Test gui = new Test();
		gui.run();
	}

	public void run()
	{
		multimediaController = new MultimediaController();
		altaPeliculaMainView = new AltaPeliculaMainView(multimediaController);
		altaPeliculaMainView.setVisible(true);
		altaPeliculaMainView.setBounds(300, 100, 800, 500);
		altaPeliculaMainView.getContentPane().setBackground(Color.black);

		multimediaController = new MultimediaController();
		altaVideojuegoMainView = new AltaVideojuegoMainView(multimediaController);
		altaVideojuegoMainView.setVisible(true);
		altaVideojuegoMainView.setBounds(300, 100, 800, 500);
		altaVideojuegoMainView.getContentPane().setBackground(Color.blue);
	}
}
