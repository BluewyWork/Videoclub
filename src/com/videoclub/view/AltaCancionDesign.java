package com.videoclub.view;

import com.videoclub.controller.CancionController;
import com.videoclub.model.Constantes;
import com.videoclub.util.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltaCancionDesign extends JFrame
{
	AltaCancionView firstPanel;
	private CancionController cancionController;
	private JPanel secondPanel;

	public AltaCancionDesign(CancionController cancionController)
	{
		this.cancionController = cancionController;
		initComponents();
	}

	public void initComponents()
	{
		firstPanel = new AltaCancionView(cancionController);
		firstPanel.setPreferredSize(new Dimension(350, 450));

		secondPanel = new JPanel();
		secondPanel.setPreferredSize(new Dimension(350, 400));
		secondPanel.setBackground(Color.red);

		setLayout(new FlowLayout());
		add(firstPanel);
		add(secondPanel);
		pack();

		getContentPane().setBackground(Color.red);
		setBounds(Constantes.POSITION_X_WINDOWS, Constantes.POSITION_Y_WINDOWS, Constantes.BOUNDS_WIDTH_WINDOWS, Constantes.BOUNDS_HEIGHT_WINDOWS);
		setTitle("Alta cancion");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	class AltaCancionView extends JPanel implements ActionListener
	{
		private JLabel lblNombre, lblDuracion;
		private JTextField txtNombre;
		private JSpinner txtDuracion;
		private JButton btnDarAlta;
		private SpinnerNumberModel modelDuracion;
		private CancionController cancionController;

		public AltaCancionView(CancionController cancionController)
		{
			this.cancionController = cancionController;
			initComponents();
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			accionDarAltaCancion();

			Logger.log("Cancion Creada");
		}

		public void initComponents()
		{
			setSize(400, 300);

			lblNombre = new JLabel("Nombre:");
			txtNombre = new JTextField(20);

			lblDuracion = new JLabel("Duración:");
			modelDuracion = new SpinnerNumberModel(0, 0, 3000, 1);
			txtDuracion = new JSpinner(modelDuracion);

			btnDarAlta = new JButton("Dar alta Cancion");

			setLayout(new GridLayout(3, 2));
			add(lblNombre);
			add(txtNombre);
			add(lblDuracion);
			add(txtDuracion);
			add(new JPanel()); // Espacio en blanco
			add(btnDarAlta);

			btnDarAlta.addActionListener(this);
		}

		public void accionDarAltaCancion()
		{
			String nombre = txtNombre.getText();
			int duracion = (int) txtDuracion.getValue();

			if (nombre.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos,",
						"ERROR", JOptionPane.ERROR_MESSAGE
				);
				return;
			}

			cancionController.altaCancion(nombre, duracion);

			JOptionPane.showMessageDialog(null, "Cancion agregada correctamente");

			txtNombre.setText("");
			txtDuracion.setValue(0);


		}
	}
}
