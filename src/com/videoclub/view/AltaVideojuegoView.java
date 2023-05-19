package com.videoclub.view;

import com.videoclub.controller.MultimediaController;
import com.videoclub.model.Formato;
import com.videoclub.model.Plataforma;
import com.videoclub.model.Videojuego;
import com.videoclub.util.Serializador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltaVideojuegoView extends JFrame implements ActionListener
{
	private JLabel lblTitulo, lblAutor, lblFormato, lblAnyo, lblPlataforma;
	private JTextField txtTitulo, txtAutor;
	private JButton btnDarAlta;
	private JComboBox listFormato, listPlataforma;
	private SpinnerNumberModel modelAnyo;
	private JSpinner txtAnyo;
	private MultimediaController multimediaController;

	public AltaVideojuegoView(MultimediaController mc)
	{
		multimediaController = mc;
		initComponents();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		accionDarAltaVideojuego();
	}

	public void initComponents()
	{
		setSize(400, 300);

		lblTitulo = new JLabel("- Título -");
		lblAutor = new JLabel("- Autor -");
		lblFormato = new JLabel("- Formato -");
		lblAnyo = new JLabel("- Año lanzamiento -");
		lblPlataforma = new JLabel("- Plataforma -");
		txtTitulo = new JTextField("Escriba el título aquí");
		txtAutor = new JTextField("Escriba el autor aquí");
		modelAnyo = new SpinnerNumberModel(2023, 1950, 2023, 1);
		txtAnyo = new JSpinner(modelAnyo);
		btnDarAlta = new JButton("Dar alta videojuego");
		Formato[] formatos = Formato.values();
		listFormato = new JComboBox(formatos);
		Plataforma[] plataformas = Plataforma.values();
		listPlataforma = new JComboBox(plataformas);

		setLayout(new GridLayout(6, 2));
		add(lblTitulo);
		add(txtTitulo);
		add(lblAutor);
		add(txtAutor);
		add(lblFormato);
		add(listFormato);
		add(lblAnyo);
		add(txtAnyo);
		add(lblPlataforma);
		add(listPlataforma);
		add(btnDarAlta);

		btnDarAlta.addActionListener(this);
		setVisible(true);
	}

	public void accionDarAltaVideojuego()
	{
		String titulo = txtTitulo.getText();
		String autor = txtAutor.getText();
		String formato = listFormato.getSelectedItem().toString();
		int anyo = Integer.parseInt(txtAnyo.getValue().toString());
		String plataforma = listPlataforma.getSelectedItem().toString();

		if (titulo.isEmpty() || autor.isEmpty() || formato.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
			return;
		}

		multimediaController.altaVideojuego(titulo, autor, formato, anyo, plataforma);

		JOptionPane.showMessageDialog(null, "videojuego agregada correctamente");

		txtTitulo.setText("");
		txtAutor.setText("");
		listFormato.setSelectedIndex(0);
		txtAnyo.setValue(2023);
		listPlataforma.setSelectedIndex(0);
	}
}
