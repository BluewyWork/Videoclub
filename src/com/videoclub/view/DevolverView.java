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

public class DevolverView extends JPanel implements ActionListener
{

	private JTextField niftextField;
	private JTextField idNumericField;
	private JButton comprobarNifButton;
	private JComboBox<String> comboBoxTitulos;
	private JButton devolverButton;
	private MultimediaController multimediaController;
	private AlquilerController alquilerController;
	private SocioController socioController;

	public DevolverView(SocioController socioController, MultimediaController multimediaController, AlquilerController alquilerController)
	{
		this.socioController = socioController;
		this.multimediaController = multimediaController;
		this.alquilerController = alquilerController;

		initComponents();
	}

	public void initComponents()
	{
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(400, 200));

		JPanel nifPanel = new JPanel();
		niftextField = new JTextField(10);
		comprobarNifButton = new JButton("Comprobar NIF");
		nifPanel.add(new JLabel("NIF:"));
		nifPanel.add(niftextField);
		nifPanel.add(comprobarNifButton);

		// Panel central
		JPanel tituloPanel = new JPanel();
		comboBoxTitulos = new JComboBox<>();
		comboBoxTitulos.setEnabled(false);
		tituloPanel.add(new JLabel("Título:"));
		tituloPanel.add(comboBoxTitulos);

		// Panel inferior
		JPanel alquilarPanel = new JPanel();
		devolverButton = new JButton("Devolver");
		alquilarPanel.add(devolverButton);

		// Agregar paneles a la ventana
		add(nifPanel, BorderLayout.NORTH);
		add(tituloPanel, BorderLayout.CENTER);
		add(alquilarPanel, BorderLayout.SOUTH);

		devolverButton.addActionListener(this);
		comprobarNifButton.addActionListener(this);
	}

	public void actualizarInterfazGrafica()
	{
		// Obtener la lista de títulos desde el gestor de multimedia
		ArrayList<String> titulosDisponibles = alquilerController.devolverStringAlquileres(niftextField.getText());

		// Actualizar la lista de títulos disponibles en el combo box
		comboBoxTitulos.removeAllItems();

		for (String titulo : titulosDisponibles)
		{
			comboBoxTitulos.addItem(titulo);
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == devolverButton)
		{
			//int id = Integer.parseInt(idNumericField.getText());
			String tituloAutor = comboBoxTitulos.getSelectedItem().toString();
			String[] partes = tituloAutor.split("\\|\\|");
			String id = partes[0].trim();
			//String titulo = partes[1].trim();

			alquilerController.delvolverAlquiler(Integer.parseInt(id));

			// Realizar la lógica de alquiler del multimedia al socio
			// Socio socio = socioController.encontrarSocio(nifTextField.getText());
			// alquilerController.delvolverAlquiler(id);

			// Mostrar mensaje de éxito
			JOptionPane.showMessageDialog(null, "Multimedia alquilada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == comprobarNifButton)
		{

			comboBoxTitulos.setEnabled(true);

			String nif = niftextField.getText();

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
