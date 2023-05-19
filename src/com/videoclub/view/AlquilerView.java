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

public class AlquilerView extends JPanel implements ActionListener
{
	private JTextField nifTextField;
	private JButton comprobarNifButton;
	private JComboBox<Multimedia> comboBoxTitulos;
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

		comboBoxTitulos.setRenderer(new MultimediaListCellRenderer());
	}

	public void actualizarMultimediaListEnInventario()
	{
		ArrayList<Multimedia> listMultimedia = multimediaController.returnStuff();
		comboBoxTitulos.removeAllItems(); // Clear the combo box before adding items
		for (Multimedia multimedia : listMultimedia)
		{
			comboBoxTitulos.addItem(multimedia);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == alquilarButton)
		{
			Multimedia multimedia2 = (Multimedia) comboBoxTitulos.getSelectedItem();
			String titulo = multimedia2.getTitulo();
			String autor = multimedia2.getTitulo();

			multimediaController.recuperarMultimedias(titulo, autor);

			// Realizar la lógica de alquiler del multimedia al socio
			alquilerController.alquilarMultimedia(nifTextField.getText(), multimedia2);

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
				actualizarMultimediaListEnInventario();
			}
			else
			{
				// El socio no existe, mostrar mensaje de error
				JOptionPane.showMessageDialog(null, "NIF no válido", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private class MultimediaListCellRenderer extends DefaultListCellRenderer
	{
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus)
		{
			super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			if (value instanceof Multimedia)
			{
				Multimedia multimedia = (Multimedia) value;
				setText(multimedia.getTitulo());
			}
			return this;
		}
	}
}