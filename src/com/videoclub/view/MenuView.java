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
	NewView newView;
	RentView rentView;
	ReleaseRentView releaseRentView;
	ListView listView;

	public MenuView()
	{
	    initComponents();
	}

	public MenuView(NewView nv, RentView rv, ReleaseRentView rrv, ListView lv)
	{
		newView = nv;
		rentView = rv;
		releaseRentView = rrv;
		listView = lv;

		initComponents();
	}

	public void initComponents()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);

		contentPane = new JPanel();
		cardLayout = new CardLayout();
		contentPane.setLayout(cardLayout);

		newView.setName("newView");
		contentPane.add(newView, "newView");

		rentView.setName("rentView");
		contentPane.add(rentView, "rentView");

		releaseRentView.setName("releaseRentView");
		contentPane.add(releaseRentView, "releaseRentView");

		listView.setName("listView");
		contentPane.add(listView, "listView");

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
		else if (e.getSource() == buttonAltas)
		{
			panelName = "panelAlquilarMultimediaASocio";
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
}