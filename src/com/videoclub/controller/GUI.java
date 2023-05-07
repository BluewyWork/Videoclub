package com.videoclub.controller;

import com.videoclub.view.MenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		mv.setBounds(300, 300, 900, 900);

		mv.getPanelAltas().getButtonAltaASocio();
	}
}
