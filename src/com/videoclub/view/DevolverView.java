package com.videoclub.view;

import com.videoclub.controller.AlquilerController;
import com.videoclub.controller.MultimediaController;
import com.videoclub.controller.SocioController;

import javax.swing.*;

public class DevolverView extends JPanel
{
	SocioController socioController;
	MultimediaController multimediaController;
	AlquilerController alquilerController;

	public DevolverView(SocioController socioController, MultimediaController multimediaController, AlquilerController alquilerController)
	{
		this.socioController = socioController;
		this.multimediaController = multimediaController;
		this.alquilerController = alquilerController;

		initComponents();
	}

	public void initComponents()
	{

	}
}
