package com.videoclub.view;

import javax.swing.*;
import java.awt.*;

public class MenuDesign extends JPanel {

	private JButton buttonAltas;
	private JButton buttonAlquilarMultimediaASocio;
	private JButton buttonDevolverMultimedia;
	private JButton buttonListar;

	public MenuDesign() {
		initComponents();
	}

	public void initComponents() {
		setLayout(new GridLayout(2, 2));

		buttonAltas = new JButton("Altas");
		add(buttonAltas);

		buttonAlquilarMultimediaASocio = new JButton("Alquilar Multimedia\na Socio");
		add(buttonAlquilarMultimediaASocio);

		buttonDevolverMultimedia = new JButton("Delvolver Multimedia");
		add(buttonDevolverMultimedia);

		buttonListar = new JButton("Listar");
		add(buttonListar);
	}
}
