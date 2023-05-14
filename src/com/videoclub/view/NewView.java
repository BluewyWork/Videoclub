package com.videoclub.view;

import com.videoclub.controller.GUI;

import javax.swing.*;
import java.awt.*;

public class NewView extends JPanel
{
	private JTextArea txtAreaOutput;
	private JScrollPane scrollPane;
	private JButton btnAltaASocio;
	private JButton btnAltaPelicula;
	private JButton btnAltaVideojuego;

	public NewView()
	{
		initComponents();
	}

	public JTextArea getTxtAreaOutput()
	{
		return txtAreaOutput;
	}

	public JScrollPane getScrollPane()
	{
		return scrollPane;
	}

	public JButton getBtnAltaASocio()
	{
		return btnAltaASocio;
	}

	public JButton getBtnAltaPelicula()
	{
		return btnAltaPelicula;
	}

	public JButton getBtnAltaVideojuego()
	{
		return btnAltaVideojuego;
	}

	public void initComponents()
	{
		setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.weighty = 1.0;
		c.anchor = GridBagConstraints.NORTH;
		c.fill = GridBagConstraints.HORIZONTAL;

		txtAreaOutput = new JTextArea();
		txtAreaOutput.setPreferredSize(new Dimension(320, 180));
		scrollPane = new JScrollPane(txtAreaOutput);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		add(scrollPane, c);

		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 1.0;
		c.insets = new Insets(10, 10, 10, 10);
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.HORIZONTAL;

		btnAltaASocio = new JButton("Alta a Socio");
		add(btnAltaASocio, c);

		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 1;
		c.weightx = 1.0;
		c.insets = new Insets(10, 10, 10, 10);
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.HORIZONTAL;

		btnAltaPelicula = new JButton("Alta a Pelicula");
		add(btnAltaPelicula, c);

		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 1;
		c.weightx = 1.0;
		c.insets = new Insets(10, 10, 10, 10);
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.HORIZONTAL;

		btnAltaVideojuego = new JButton("Alta a Videojuego");
		add(btnAltaVideojuego, c);
	}
}