package com.videoclub.view;

import com.videoclub.controller.AlquilerController;
import com.videoclub.controller.MultimediaController;
import com.videoclub.controller.SocioController;
import com.videoclub.model.Alquiler;
import com.videoclub.model.Multimedia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DevolverView extends JPanel implements ActionListener
{
	SocioController socioController;
	MultimediaController multimediaController;
	AlquilerController alquilerController;

	private JComboBox<String> cbMultimedias;
	private JButton btnDevolver;

	public DevolverView(SocioController socioController, MultimediaController multimediaController, AlquilerController alquilerController)
	{
		this.socioController = socioController;
		this.multimediaController = multimediaController;
		this.alquilerController = alquilerController;

		initComponents();
	}

	public void initComponents()
	{
		setLayout(new GridLayout(2, 2));

		cbMultimedias = new JComboBox<>();
		btnDevolver = new JButton();

		add(cbMultimedias);
		add(btnDevolver);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		int id = 0;

		Alquiler alquiler = alquilerController.delvolverAlquiler(id);

		Multimedia multimedia = alquiler.getMultimedia();

		multimediaController.guardarMultimedia(multimedia);
	}
}
