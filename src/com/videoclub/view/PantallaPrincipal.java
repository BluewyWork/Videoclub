package com.videoclub.view;

import javax.swing.*;

public class PantallaPrincipal extends JPanel {

	private JButton buttonAltas;
	private JButton buttonAlquilarMultimediaASocio;
	private JButton buttonDevolverMultimedia;
	private JButton buttonListar;

	public PantallaPrincipal() {

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
