package com.videoclub.view.old;

import com.videoclub.controller.AlquilerController;
import com.videoclub.controller.MultimediaController;
import com.videoclub.controller.SocioController;

import javax.swing.*;

public class ListarView extends JPanel
{
	SocioController socioController;
	MultimediaController multimediaController;
	AlquilerController alquilerController;

	public ListarView(SocioController socioController, MultimediaController multimediaController, AlquilerController alquilerController)
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
