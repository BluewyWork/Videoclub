package com.videoclub.view;

import com.videoclub.controller.MultimediaController;
import com.videoclub.model.Cancion;
import com.videoclub.model.Constantes;
import com.videoclub.model.Formato;
import com.videoclub.util.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AltaDiscoDesign extends JFrame
{
	AltaDiscoView firstPanel;
	private MultimediaController multimediaController;
	private JPanel secondPanel;

	public AltaDiscoDesign(MultimediaController multimedia)
	{
		multimediaController = multimedia;
		initComponents();
	}

	public void initComponents()
	{
		firstPanel = new AltaDiscoView(multimediaController);
		firstPanel.setPreferredSize(new Dimension(350, 450));

		secondPanel = new JPanel();
		secondPanel.setPreferredSize(new Dimension(350, 400));
		secondPanel.setBackground(Color.yellow);

		setLayout(new FlowLayout());
		add(firstPanel);
		add(secondPanel);
		pack();

		getContentPane().setBackground(Color.yellow);
		setBounds(Constantes.POSITION_X_WINDOWS, Constantes.POSITION_Y_WINDOWS, Constantes.BOUNDS_WIDTH_WINDOWS, Constantes.BOUNDS_HEIGHT_WINDOWS);
		setTitle("Alta disco");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	class AltaDiscoView extends JPanel implements ActionListener
	{
		private JLabel lblTitulo, lblAutor, lblFormato, lblAnyo, lblDuracion;
		private JTextField txtTitulo, txtAutor, txtDuracion;
		private JSpinner txtAnyo;
		private JButton btnDarAlta;
		private JButton btnVolver;
		private JComboBox listFormato;

		private SpinnerNumberModel modelAnyo;
		private MultimediaController multimediaController;

		public AltaDiscoView(MultimediaController multimedia)
		{
			multimediaController = multimedia;
			initComponents();
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource().equals(btnDarAlta))
			{
				accionDarAltaDisco();

				Logger.log("Disco Creada");
			}
			else if (e.getSource().equals(btnVolver))
			{
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		}

		public void initComponents()
		{
			setSize(400, 300);

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

			btnVolver = new JButton("Volver");
			btnDarAlta = new JButton("Dar alta disco");

			setLayout(new GridLayout(5, 2));
			add(lblTitulo);
			add(txtTitulo);
			add(lblAutor);
			add(txtAutor);
			add(lblFormato);
			add(listFormato);
			add(lblAnyo);
			add(txtAnyo);
			add(btnVolver);
			add(btnDarAlta);

			btnVolver.addActionListener(this);
			btnDarAlta.addActionListener(this);
		}

		public void accionDarAltaDisco()
		{
			String titulo = txtTitulo.getText();
			String autor = txtAutor.getText();
			String formato = listFormato.getSelectedItem().toString();
			int anyo = (int) txtAnyo.getValue();
			ArrayList<Cancion> listCancion = new ArrayList<>();

			if (titulo.isEmpty() || autor.isEmpty() || formato.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos,",
						"ERROR", JOptionPane.ERROR_MESSAGE
				);
				return;
			}

			multimediaController.altaDisco(titulo, autor, formato, anyo, listCancion);

			JOptionPane.showMessageDialog(null, "Disco agregada correctamente");

			txtTitulo.setText("");
			txtAutor.setText("");
			listFormato.setSelectedIndex(0);
			txtAnyo.setValue(2023);
		}
	}
}