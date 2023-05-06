package com.videoclub.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Applicacion extends JFrame implements ActionListener
{
	private JMenuBar menuBar;
	private JMenu group1;
	private JMenuItem menuItemSalir;
	private JPanel panelBlank;
	MenuView panelMenu;
	AltasView panelAltas;

	public Applicacion()
	{
		initComponents();
	}

	public void initComponents()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		CardLayout cardLayout = new CardLayout();
		setLayout(cardLayout);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		group1 = new JMenu("Options");
		menuBar.add(group1);

		menuItemSalir = new JMenuItem("Salir");
		group1.add(menuItemSalir);

		panelBlank = new JPanel();
		panelMenu = new MenuView();
		panelAltas = new AltasView();

		panelBlank.add(panelMenu, "panelMenu");
		panelBlank.add(panelAltas, "panelAltas");

		add(panelBlank);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource().equals(menuItemSalir))
		{
			System.exit(0);
		}
		else if (e.getSource().equals(null))
		{

		}
	}
}