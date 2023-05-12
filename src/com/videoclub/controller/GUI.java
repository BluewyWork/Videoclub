package com.videoclub.controller;

import com.videoclub.view.MenuView;

public class GUI
{
	GestorSocioController gsc;
	GestorItems iv;
	MenuView mv;

	public GUI()
	{
		gsc = new GestorSocioController();
		iv = new GestorItems();
	}

	public void run()
	{
		mv = new MenuView();
		mv.setVisible(true);
		mv.setBounds(350, 25, 900, 775);
	}
}