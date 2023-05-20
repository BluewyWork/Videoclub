package com.videoclub.view;

import com.videoclub.controller.MultimediaController;
import com.videoclub.controller.SocioController;

import javax.swing.*;
import java.awt.*;

public class IntroduccionView extends JPanel
{
	SocioController socioController;
	MultimediaController multimediaController;
	private JTextArea txtAreaOutput;
	private JScrollPane scrollPane;

	public IntroduccionView(SocioController socioController, MultimediaController multimediaController)
	{
		this.socioController = socioController;
		this.multimediaController = multimediaController;

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

		txtAreaOutput = new JTextArea();
		txtAreaOutput.setPreferredSize(new Dimension(850, 180));
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

		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 1;
		c.weightx = 1.0;
		c.insets = new Insets(10, 10, 10, 10);
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.HORIZONTAL;

		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 1;
		c.weightx = 1.0;
		c.insets = new Insets(10, 10, 10, 10);
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.HORIZONTAL;
	}
}
