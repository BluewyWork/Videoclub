package com.videoclub.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Applicacion extends JFrame implements ActionListener {

	private JMenuBar menuBar;

	private JMenu group1;
	private JMenuItem menuItemSalir;

	PantallaPrincipal panelPP;
	AltasDesign panelAltas;

	public Applicacion() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		group1 = new JMenu("Options");
		menuBar.add(group1);

		menuItemSalir = new JMenuItem("Salir");
		menuItemSalir.addActionListener(this);
		group1.add(menuItemSalir);

		// add panel here !
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(menuItemSalir)) {
			System.exit(0);
		}
	}
	
}
