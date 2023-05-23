package com.videoclub.controller;

import com.videoclub.view.AltaPeliculaMainView;

import java.awt.*;

public class Test
{
	AltaPeliculaMainView altaPeliculaMainView;
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
	}
}
