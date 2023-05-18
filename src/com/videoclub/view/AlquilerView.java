package com.videoclub.view;

import com.videoclub.controller.AlquilerController;
import com.videoclub.controller.MultimediaController;
import com.videoclub.controller.SocioController;
import com.videoclub.model.Alquiler;
import com.videoclub.model.Multimedia;
import com.videoclub.model.Socio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AlquilerView extends JPanel implements ActionListener
{
	private JTextField nifTextField;
	private JButton comprobarNifButton;
	private JComboBox<String> comboBoxTitulos;
	private JButton alquilarButton;
	private MultimediaController multimediaController;
	private AlquilerController alquilerController;
	private SocioController socioController;

	public AlquilerView(SocioController sc, MultimediaController mc, AlquilerController ac)
	{
		multimediaController = mc;
		alquilerController = ac;
		socioController = sc;

		initComponents();
	}

	public void initComponents()
	{
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(400, 200));

		JPanel nifPanel = new JPanel();
		nifTextField = new JTextField(10);
		comprobarNifButton = new JButton("Comprobar NIF");
		nifPanel.add(new JLabel("NIF:"));
		nifPanel.add(nifTextField);
		nifPanel.add(comprobarNifButton);

		// Panel central
		JPanel tituloPanel = new JPanel();
		comboBoxTitulos = new JComboBox<>();
		comboBoxTitulos.setEnabled(false);
		tituloPanel.add(new JLabel("Título:"));
		tituloPanel.add(comboBoxTitulos);

		// Panel inferior
		JPanel alquilarPanel = new JPanel();
		alquilarButton = new JButton("Alquilar");
		alquilarPanel.add(alquilarButton);

		// Agregar paneles a la ventana
		add(nifPanel, BorderLayout.NORTH);
		add(tituloPanel, BorderLayout.CENTER);
		add(alquilarPanel, BorderLayout.SOUTH);

		alquilarButton.addActionListener(this);
		comprobarNifButton.addActionListener(this);
	}

	public void actualizarInterfazGrafica()
	{
		// Obtener la lista de títulos desde el gestor de multimedia
		HashMap<Integer, Multimedia> hashMap = multimediaController.test();

		for (Multimedia multimedia : hashMap.values())
		{
			comboBoxTitulos.addItem(multimedia.getTitulo());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == alquilarButton)
		{
			HashMap<Integer, Multimedia> hashMap = multimediaController.test();
			int index = comboBoxTitulos.getSelectedIndex();
			String titulo = hashMap.get(index).getTitulo();
			String autor = hashMap.get(index).getAutor();

			Multimedia multimedia = multimediaController.recuperarMultimedias(titulo, autor);

			// Realizar la lógica de alquiler del multimedia al socio
			//Socio socio = socioController.encontrarSocio(nifTextField.getText());
			alquilerController.alquilarMultimedia(nifTextField.getText(), multimedia);

			// Mostrar mensaje de éxito
			JOptionPane.showMessageDialog(null, "Multimedia alquilada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == comprobarNifButton)
		{

			comboBoxTitulos.setEnabled(true);

			String nif = nifTextField.getText();

			// Utiliza el gestor de socios para buscar el socio por el NIF
			Socio socio = socioController.encontrarSocio(nif);

			if (socio != null)
			{
				// El socio existe, mostrar las multimedia disponibles
				actualizarInterfazGrafica();
			}
			else
			{
				// El socio no existe, mostrar mensaje de error
				JOptionPane.showMessageDialog(null, "NIF no válido", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}

