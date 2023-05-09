package com.videoclub.controller;

import com.videoclub.view.MenuView;

public class GUI
{
	GestorSocioController gsc;
	InventarioController iv;
	MenuView mv;

	public GUI()
	{
		gsc = new GestorSocioController();
		iv = new InventarioController();
	}

	public void run()
	{
		mv = new MenuView();
		mv.setVisible(true);
		mv.setBounds(350, 25, 900, 775);

		mv.getPanelAltas().getButtonAltaASocio();
	}
}
