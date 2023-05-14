package com.videoclub.controller;

import com.videoclub.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class GUI implements ActionListener
{
	private static NewView newView;
	private static RentView rentView;
	private static ReleaseRentView releaseRentView;
	private static ListView listView;

	private MemberController memberControllear = new MemberController();

	public static void main(String[] args)
	{
		GUI gui = new GUI();
		gui.run();
	}
	public void run()
	{
		newView = new NewView();

		newView.getBtnAltaASocio().addActionListener(this);
		newView.getBtnAltaPelicula().addActionListener(this);
		newView.getBtnAltaVideojuego().addActionListener(this);

		rentView = new RentView();

		releaseRentView = new ReleaseRentView();

		listView = new ListView();

		MenuView menuView = new MenuView(newView, rentView, releaseRentView, listView);

		menuView.setVisible(true);
		menuView.setBounds(100, 100, 900, 900);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource().equals(newView.getBtnAltaASocio()))
		{
			memberControllear.registerMember("minecraft", "minecraft", "03/10/2003", "minecraft");
		}
		else if (e.getSource().equals(newView.getBtnAltaPelicula()))
		{

		}
		else if (e.getSource().equals(newView.getBtnAltaVideojuego()))
		{

		}
	}
}
