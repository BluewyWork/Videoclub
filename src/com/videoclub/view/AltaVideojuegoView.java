package com.videoclub.view;

import com.videoclub.model.Formato;
import com.videoclub.model.Pelicula;
import com.videoclub.model.Plataforma;
import com.videoclub.model.Videojuego;
import com.videoclub.util.Serializador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltaVideojuegoView extends JPanel implements ActionListener
{
	private JLabel lblTitulo, lblAutor, lblFormato, lblAnyo, lblPlataforma;
	private JTextField txtTitulo, txtAutor;
	private JButton btnDarAlta;
	private JComboBox listFormato, listPlataforma;
	private SpinnerNumberModel modelAnyo;
	private JSpinner txtAnyo;

	public AltaVideojuegoView()
	{
		setSize(400, 300);

		lblTitulo = new JLabel("- Título -");
		lblAutor = new JLabel("- Autor -");
		lblFormato = new JLabel("- Formato -");
		lblAnyo = new JLabel("- Año lanzamiento -");
		txtTitulo = new JTextField("Escriba el título aquí");
		txtAutor = new JTextField("Escriba el autor aquí");
		modelAnyo = new SpinnerNumberModel(2023,1950 ,2023,1);
		txtAnyo = new JSpinner(modelAnyo);
		btnDarAlta = new JButton("Dar alta videojuego");
		Formato[] formatos = Formato.values();
		listFormato = new JComboBox(formatos);

		setLayout(new GridLayout(8,8));
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
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Videojuego videojuego = new Videojuego(
				txtTitulo.getText(), txtAutor.getText(),
				Formato.valueOf(listFormato.getSelectedItem().toString()),
				(int) txtAnyo.getValue(), Plataforma.valueOf(listPlataforma.getSelectedItem().toString()));
		Serializador.serializar(videojuego, "videojuego.ser");
	}
}
