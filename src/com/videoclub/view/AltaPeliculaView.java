package com.videoclub.view;

import com.videoclub.controller.MultimediaController;
import com.videoclub.model.Constantes;
import com.videoclub.model.Formato;
import com.videoclub.model.Pelicula;
import com.videoclub.util.Serializador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltaPeliculaView extends JPanel implements ActionListener
{
	private JLabel lblTitulo, lblAutor, lblFormato, lblAnyo, lblDuracion, lblActor, lblActriz;
	private JTextField txtTitulo, txtAutor, txtActor, txtActriz;
	private JSpinner txtAnyo, txtDuracion;
	private JButton btnIniciar, btnDarAlta;
	private JComboBox listFormato;
	private SpinnerNumberModel modelAnyo, modelDuracion;
	private MultimediaController multimediaController;

	public AltaPeliculaView(MultimediaController multimedia)
	{
		initComponents();
	}

	public void initComponents()
	{
		multimediaController = new MultimediaController();

		lblTitulo = new JLabel("- Título -");
		lblAutor = new JLabel("- Autor -");
		lblFormato = new JLabel("- Formato -");
		lblAnyo = new JLabel("- Año lanzamiento -");
		lblDuracion = new JLabel("- Duración -");
		lblActor = new JLabel("- Actor -");
		lblActriz = new JLabel("- Actriz -");
		txtTitulo = new JTextField("Escriba el título aquí");
		txtAutor = new JTextField("Escriba el autor aquí");
		modelAnyo = new SpinnerNumberModel(2023, 1890, 2023, 1);
		modelDuracion = new SpinnerNumberModel(0, 0, 3000, 1);
		txtAnyo = new JSpinner(modelAnyo);
		txtDuracion = new JSpinner(modelDuracion);
		txtActor = new JTextField("Escriba un actor aquí");
		txtActriz = new JTextField("Escriba una actriz aquí");
		btnIniciar = new JButton("Reniciar valores");
		btnDarAlta = new JButton("Dar alta película");
		Formato[] formatos = Formato.values();
		listFormato = new JComboBox(formatos);

		setSize(400, 300);
		setLayout(new GridLayout(8, 8));
		add(lblTitulo);
		add(txtTitulo);
		add(lblAutor);
		add(txtAutor);
		add(lblFormato);
		add(listFormato);
		add(lblAnyo);
		add(txtAnyo);
		add(lblDuracion);
		add(txtDuracion);
		add(lblActor);
		add(txtActor);
		add(lblActriz);
		add(txtActriz);
		add(btnIniciar);
		add(btnDarAlta);

		btnIniciar.addActionListener(this);
		btnDarAlta.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == btnDarAlta)
		{
			Pelicula pelicula = new Pelicula(
					txtTitulo.getText(), txtAutor.getText(),
					Formato.valueOf(listFormato.getSelectedItem().toString()),
					(int) txtAnyo.getValue(), (int) txtDuracion.getValue(),
					txtActor.getText(), txtActriz.getText()
			);
			Serializador.serializar(pelicula, "pelicula.ser");
		}
		else if (e.getSource() == btnIniciar)
		{

		}
	}
}
