package com.videoclub.view;

import com.videoclub.controller.MultimediaController;
import com.videoclub.model.Formato;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltaPeliculaDesign extends JFrame implements ActionListener
{
	private MultimediaController multimediaController;
	AltaPeliculaView firstPanel;
	private JPanel secondPanel;

	public AltaPeliculaDesign(MultimediaController multimedia)
	{
		multimediaController = multimedia;
		initComponents();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

	}

	public void initComponents()
	{
		firstPanel = new AltaPeliculaView(multimediaController);
		firstPanel.setPreferredSize(new Dimension(350, 450));

		secondPanel = new JPanel();
		secondPanel.setPreferredSize(new Dimension(350, 400));

		secondPanel.setBackground(Color.black);
		setLayout(new FlowLayout());
		add(firstPanel);
		add(secondPanel);
		pack();

		setVisible(true);
		setTitle("Alta pelicula");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public class ImagePanel extends JComponent
	{
		private Image image;

		public ImagePanel(Image image)
		{
			this.image = image;
		}

		@Override
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
		}
	}

	class AltaPeliculaView extends JPanel implements ActionListener
	{
		private JLabel lblTitulo, lblAutor, lblFormato, lblAnyo, lblDuracion, lblActor, lblActriz;
		private JTextField txtTitulo, txtAutor, txtActor, txtActriz;
		private JSpinner txtAnyo, txtDuracion;
		private JButton btnDarAlta;
		private JComboBox listFormato;
		private SpinnerNumberModel modelAnyo, modelDuracion;
		private MultimediaController multimediaController;

		public AltaPeliculaView(MultimediaController multimedia)
		{
			multimediaController = multimedia;
			initComponents();
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == btnDarAlta)
			{
				accionDarAltaPelicula();
			}
		}

		public void initComponents()
		{
			multimediaController = new MultimediaController();

			lblTitulo = new JLabel("Título:");
			txtTitulo = new JTextField(20);

			lblAutor = new JLabel("Autor:");
			txtAutor = new JTextField(30);

			lblFormato = new JLabel("Formato:");
			Formato[] formatos = Formato.values();
			listFormato = new JComboBox(formatos);

			lblAnyo = new JLabel("Año lanzamiento:");
			modelAnyo = new SpinnerNumberModel(2023, 1890, 2023, 1);
			txtAnyo = new JSpinner(modelAnyo);

			lblDuracion = new JLabel("Duración:");
			modelDuracion = new SpinnerNumberModel(0, 0, 3000, 1);
			txtDuracion = new JSpinner(modelDuracion);

			lblActor = new JLabel("Actor:");
			txtActor = new JTextField(20);

			lblActriz = new JLabel("Actriz:");
			txtActriz = new JTextField(20);

			btnDarAlta = new JButton("Dar alta película");

			setSize(400, 300);
			setLayout(new GridLayout(8, 2));
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
			add(btnDarAlta);

			btnDarAlta.addActionListener(this);
		}

		public void accionDarAltaPelicula()
		{
			String titulo = txtTitulo.getText();
			String autor = txtAutor.getText();
			String formato = listFormato.getSelectedItem().toString();
			int anyo = (int) txtAnyo.getValue();
			int duracion = (int) txtDuracion.getValue();
			String actor = txtActor.getText();
			String actriz = txtActriz.getText();

			if (titulo.isEmpty() || autor.isEmpty() || formato.isEmpty() || actor.isEmpty() || actriz.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
				return;
			}

			multimediaController.altaPelicula(titulo, autor, formato, anyo, duracion, actor, actriz);

			JOptionPane.showMessageDialog(null, "Pelicula agregada correctamente");

			txtTitulo.setText("");
			txtAutor.setText("");
			txtActriz.setText("");
			txtActor.setText("");
			listFormato.setSelectedIndex(0);
			txtAnyo.setValue(2003);
			txtDuracion.setValue("0");
		}
	}
}