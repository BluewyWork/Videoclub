package com.videoclub.view;

import javax.swing.*;
import java.awt.*;

public class AltasView extends JPanel
{
	private JTextArea textAreaOutput;
	private JScrollPane scrollPane;
	private JButton buttonAltaASocio;
	private JButton buttonAltaPelicula;
	private JButton buttonAltaVideojuego;

	public AltasView()
	{
		initComponents();
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

		textAreaOutput = new JTextArea();
		textAreaOutput.setPreferredSize(new Dimension(320, 180));
		scrollPane = new JScrollPane(textAreaOutput);
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

		buttonAltaASocio = new JButton("Alta a Socio");
		add(buttonAltaASocio, c);

		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 1;
		c.weightx = 1.0;
		c.insets = new Insets(10, 10, 10, 10);
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.HORIZONTAL;

		buttonAltaPelicula = new JButton("Alta a Pelicula");
		add(buttonAltaPelicula, c);

		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 1;
		c.weightx = 1.0;
		c.insets = new Insets(10, 10, 10, 10);
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.HORIZONTAL;

		buttonAltaVideojuego = new JButton("Alta a Videojuego");
		add(buttonAltaVideojuego, c);
	}

	public JTextArea getTextAreaOutput()
	{
		return textAreaOutput;
	}

	public JScrollPane getScrollPane()
	{
		return scrollPane;
	}

	public JButton getButtonAltaASocio()
	{
		return buttonAltaASocio;
	}

	public JButton getButtonAltaPelicula()
	{
		return buttonAltaPelicula;
	}

	public JButton getButtonAltaVideojuego()
	{
		return buttonAltaVideojuego;
	}
}