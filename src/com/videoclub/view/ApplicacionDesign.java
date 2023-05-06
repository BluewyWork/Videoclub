package com.videoclub.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.videoclub.view.*;

public class ApplicacionDesign extends JFrame {

	private JMenuBar menuBar;

	private JMenu group1;
	private JMenuItem menuItemSalir;

	MenuDesign panelMenu;
	AltasDesign panelAltas;

	public ApplicacionDesign() {
		initComponents();
	}

	public void initComponents() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		group1 = new JMenu("Options");
		menuBar.add(group1);

		menuItemSalir = new JMenuItem("Salir");
		group1.add(menuItemSalir);

		// add panel here !
		panelMenu = new MenuDesign();
		add(panelMenu);
		
	}
}