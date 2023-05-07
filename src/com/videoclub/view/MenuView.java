package com.videoclub.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuView extends JFrame implements ActionListener
{
	private final JPanel contentPane;
	private final CardLayout cardLayout;
	private final JButton buttonAltas;
	private final JButton buttonAlquilarMultimediaASocio;
	private final JButton buttonDevolverMultimedia;
	private final JButton buttonListar;
	AltasView panelAltas;

	public MenuView()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);

		contentPane = new JPanel();
		cardLayout = new CardLayout();
		contentPane.setLayout(cardLayout);

		panelAltas = new AltasView();
		panelAltas.setName("panelAltas");
		contentPane.add(panelAltas, "panelAltas");

		AlquilarMultiMediaSocioView panelAlquilarMultimediaASocio = new AlquilarMultiMediaSocioView();
		panelAlquilarMultimediaASocio.setName("panelAlquilarMultimediaASocio");
		contentPane.add(panelAlquilarMultimediaASocio, "panelAlquilarMultimediaASocio");

		DevolverMultimediaView panelDevolverMultimediaView = new DevolverMultimediaView();
		panelDevolverMultimediaView.setName("panelDevolverMultimediaView");
		contentPane.add(panelDevolverMultimediaView, "panelDevolverMultimediaView");

		ListarView panelListarView = new ListarView();
		panelListarView.setName("panelListarView");
		contentPane.add(panelListarView, "panelListarView");

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

	public AltasView getPanelAltas()
	{
		return panelAltas;
	}
}