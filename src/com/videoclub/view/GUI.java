package com.videoclub.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
	
	private JMenuBar menuBar;

	private JMenu group1;
	private JMenuItem menuItemSalir;

	private JPanel panel;

	private JButton buttonAltas;
	private JButton buttonAlquilarMultimediaASocio;
	private JButton buttonDevolverMultimedia;
	private JButton buttonListar;

	public GUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// menu group1
		group1 = new JMenu("Options");
		menuBar.add(group1);

		// menu group1 subitems
		menuItemSalir = new JMenuItem("Salir");
		menuItemSalir.addActionListener(this);
		group1.add(menuItemSalir);

		// panel
		panel = new JPanel(new GridLayout(2, 2));
		add(panel);

		// panel subitems
		buttonAltas = new JButton("Altas");
		buttonAltas.addActionListener(this);
		panel.add(buttonAltas);

		buttonAlquilarMultimediaASocio = new JButton("Alquilar Multimedia\na Socio");
		buttonAlquilarMultimediaASocio.addActionListener(this);
		panel.add(buttonAlquilarMultimediaASocio);

		buttonDevolverMultimedia = new JButton("Delvolver Multimedia");
		buttonDevolverMultimedia.addActionListener(this);
		panel.add(buttonDevolverMultimedia);

		buttonListar = new JButton("Listar");
		buttonListar.addActionListener(this);
		panel.add(buttonListar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(menuItemSalir)) {
			System.exit(0);
		}
		else if (e.getSource().equals(buttonAltas)) {
			
		}
	}
}
