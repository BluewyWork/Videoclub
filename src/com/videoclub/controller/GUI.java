package com.videoclub.controller;

import com.videoclub.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener
{
	private static AltasView altasView;
	private static AlquilerView alquilerView;
	private static DevolverView devolverView;
	private static ListarView listarView;
	private static AltaSocioView altaSocioView;

	private SocioController memberController = new SocioController();

	public static void main(String[] args)
	{
		GUI gui = new GUI();
		gui.run();
	}

	public void run()
	{
		altasView = new AltasView();

		altasView.getBtnAltaASocio().addActionListener(this);
		altasView.getBtnAltaPelicula().addActionListener(this);
		altasView.getBtnAltaVideojuego().addActionListener(this);

		alquilerView = new AlquilerView();

		devolverView = new DevolverView();

		listarView = new ListarView();

		MenuView menuView = new MenuView(altasView, alquilerView, devolverView, listarView);

		menuView.setVisible(true);
		menuView.setBounds(100, 100, 900, 900);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource().equals(altasView.getBtnAltaASocio()))
		{
			//memberControllear.registrarMiembros("minecraft", "minecraft", "03/10/2003", "minecraft");
			altaSocioView = new AltaSocioView(memberController);
		}
		else if (e.getSource().equals(altasView.getBtnAltaPelicula()))
		{

		}
		else if (e.getSource().equals(altasView.getBtnAltaVideojuego()))
		{

		}
	}
}
