package com.videoclub.view;

import com.videoclub.controller.MultimediaController;
import com.videoclub.model.Constantes;
import com.videoclub.model.Formato;
import com.videoclub.model.Plataforma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltaVideojuegoDesign extends JFrame implements ActionListener
{
	private MultimediaController multimediaController;
	AltaVideojuegoView firstPanel;
	private JPanel secondPanel;

	public AltaVideojuegoDesign(MultimediaController multimedia)
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
		firstPanel = new AltaVideojuegoView(multimediaController);
		firstPanel.setPreferredSize(new Dimension(350, 450));

		secondPanel = new JPanel();
		secondPanel.setPreferredSize(new Dimension(350, 400));
		secondPanel.setBackground(Color.blue);

		setLayout(new FlowLayout());
		add(firstPanel);
		add(secondPanel);
		pack();

		getContentPane().setBackground(Color.blue);
		setBounds(Constantes.POSITION_X_WINDOWS, Constantes.POSITION_Y_WINDOWS, Constantes.BOUNDS_WIDTH_WINDOWS, Constantes.BOUNDS_HEIGHT_WINDOWS);
		setTitle("Alta videojuego");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	class AltaVideojuegoView extends JPanel implements ActionListener
	{
		private JLabel lblTitulo, lblAutor, lblFormato, lblAnyo, lblPlataforma;
		private JTextField txtTitulo, txtAutor;
		private JButton btnDarAlta;
		private JComboBox listFormato, listPlataforma;
		private SpinnerNumberModel modelAnyo;
		private JSpinner txtAnyo;
		private final MultimediaController multimediaController;

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
			txtTitulo = new JTextField("");

			lblAutor = new JLabel("- Autor -");
			txtAutor = new JTextField("");

			lblFormato = new JLabel("- Formato -");
			Formato[] formatos = Formato.values();
			listFormato = new JComboBox(formatos);

			lblAnyo = new JLabel("- Año lanzamiento -");
			modelAnyo = new SpinnerNumberModel(2023, 1950, 2023, 1);
			txtAnyo = new JSpinner(modelAnyo);

			lblPlataforma = new JLabel("- Plataforma -");
			Plataforma[] plataformas = Plataforma.values();
			listPlataforma = new JComboBox(plataformas);

			btnDarAlta = new JButton("Dar alta videojuego");

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
			add(new JPanel()); // Espacio en blanco
			add(btnDarAlta);

			btnDarAlta.addActionListener(this);
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
				JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos",
						"ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}

			multimediaController.altaVideojuego(titulo, autor, formato, anyo, plataforma);

			JOptionPane.showMessageDialog(null, "Videojuego agregada correctamente");

			txtTitulo.setText("");
			txtAutor.setText("");
			listFormato.setSelectedIndex(0);
			txtAnyo.setValue(2023);
			listPlataforma.setSelectedIndex(0);
		}
	}
}