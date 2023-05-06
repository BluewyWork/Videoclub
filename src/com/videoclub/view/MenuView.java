package com.videoclub.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuView extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private CardLayout cardLayout;
	private JButton buttonAltas;
	private JButton buttonAlquilarMultimediaASocio;
	private JButton buttonDevolverMultimedia;
	private JButton buttonListar;

	public MenuView()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);

		contentPane = new JPanel();
		cardLayout = new CardLayout();
		contentPane.setLayout(cardLayout);

		AltasView panelAltas = new AltasView();
		panelAltas.setName("panelAltas");
		contentPane.add(panelAltas, "panelAltas");

		JPanel panelAlquilarMultimediaASocio = new JPanel();
		JLabel label1 = new JLabel("This is panelAlquilarMultimediaASocio");
		panelAlquilarMultimediaASocio.add(label1);
		panelAlquilarMultimediaASocio.setName("panelAlquilarMultimediaASocio");
		contentPane.add(panelAlquilarMultimediaASocio, "panelAlquilarMultimediaASocio");

		JPanel panelDevolverMultimedia = new JPanel();
		JLabel label2 = new JLabel("This is panelDevolverMultimedia");
		panelDevolverMultimedia.add(label2);
		panelDevolverMultimedia.setName("panelDevolverMultimedia");
		contentPane.add(panelDevolverMultimedia, "panelDevolverMultimedia");

		JPanel panelListar = new JPanel();
		JLabel label3 = new JLabel("This is panelListar");
		panelListar.add(label3);
		panelListar.setName("panelListar");
		contentPane.add(panelListar, "panelListar");

		buttonAltas = new JButton("Altas");
		buttonAltas.addActionListener(this);

		buttonAlquilarMultimediaASocio = new JButton("Alquilar Multimedia\na Socio");
		buttonAlquilarMultimediaASocio.addActionListener(this);

		buttonDevolverMultimedia = new JButton("Delvolver Multimedia");
		buttonDevolverMultimedia.addActionListener(this);

		buttonListar = new JButton("Listar");
		buttonListar.addActionListener(this);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(buttonAltas);
		buttonPanel.add(buttonAlquilarMultimediaASocio);
		buttonPanel.add(buttonDevolverMultimedia);
		buttonPanel.add(buttonListar);

		add(contentPane, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e)
	{
		String panelName = "";

		if (e.getSource() == buttonAltas)
		{
			panelName = "panelAltas";
		}
		else if (e.getSource() == buttonAlquilarMultimediaASocio)
		{
			panelName = "panelAlquilarMultimediaASocio";
		}
		else if (e.getSource() == buttonDevolverMultimedia)
		{
			panelName = "panelDevolverMultimedia";
		}
		else if (e.getSource() == buttonListar)
		{
			panelName = "panelListar";
		}

		cardLayout.show(contentPane, panelName);
	}

	public static void main(String[] args)
	{
		MenuView frame = new MenuView();
		frame.setVisible(true);
	}
}