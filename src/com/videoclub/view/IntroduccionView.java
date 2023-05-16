package com.videoclub.view;

import javax.swing.*;
import java.awt.*;

public class IntroduccionView extends JPanel
{
	private JLabel lblHomePage;
	private JTextArea txtArea;
	private JScrollPane scrollPane;

	public IntroduccionView()
	{
		initComponents();
	}

	public void initComponents()
	{
		lblHomePage = new JLabel();
		lblHomePage.setIcon(new ImageIcon("ImagenPrincipal.jpg")); //Sets the image to be displayed as an icon
		Dimension size = lblHomePage.getPreferredSize(); //Gets the size of the image
		lblHomePage.setBounds(50, 30, size.width, size.height); //Sets the location of the image
		add(lblHomePage);

		txtArea = new JTextArea();
		txtArea.setPreferredSize(new Dimension(320, 180));
		scrollPane = new JScrollPane(txtArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(txtArea);
		add(scrollPane);
	}
}
