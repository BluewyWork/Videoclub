package com.videoclub.view.old;

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
	private JButton comprobarNifButton;
	private JComboBox<Alquiler> comboBoxTitulos;
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

		// Set custom renderer for the JComboBox
		comboBoxTitulos.setRenderer(new AlquilerListCellRenderer());
	}

	public void actualizarAlquilerListDeSocio()
	{
		String nif = niftextField.getText();
		ArrayList<Alquiler> alquilerList = alquilerController.returnStuff(nif);
		comboBoxTitulos.removeAllItems(); // Clear the combo box before adding items
		for (Alquiler alquiler : alquilerList)
		{
			comboBoxTitulos.addItem(alquiler);
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == devolverButton)
		{
			Alquiler alquiler = (Alquiler) comboBoxTitulos.getSelectedItem();
			int id = alquiler.getContador();
			alquilerController.delvolverAlquiler(id);
			multimediaController.guardarMultimedia(alquiler.getMultimedia()); // Call the method to handle the multimedia return

			JOptionPane.showMessageDialog(null, "Multimedia devuelto correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == comprobarNifButton)
		{
			comboBoxTitulos.setEnabled(true);

			String nif = niftextField.getText();
			Socio socio = socioController.encontrarSocio(nif);

			if (socio != null)
			{
				actualizarAlquilerListDeSocio();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "NIF no válido", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	// Custom ListCellRenderer to control the displayed string in the JComboBox
	private class AlquilerListCellRenderer extends DefaultListCellRenderer
	{
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus)
		{
			super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			if (value instanceof Alquiler)
			{
				Alquiler alquiler = (Alquiler) value;
				Multimedia multimedia = alquiler.getMultimedia();
				setText(multimedia.getTitulo());
			}
			return this;
		}
	}
}
