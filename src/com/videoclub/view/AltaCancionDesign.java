package com.videoclub.view;

import com.videoclub.controller.CancionController;
import com.videoclub.model.Constantes;
import com.videoclub.util.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * La clase `AltaCancionDesign` es una clase que representa la interfaz gráfica para agregar una canción en un
 * videoclub. Extiende la clase `JFrame` para crear una ventana.
 */
public class AltaCancionDesign extends JFrame
{
	private AltaCancionView firstPanel;
	private final CancionController cancionController;
	private JPanel secondPanel;

	/**
	 * Crea una instancia de `AltaCancionDesign`.
	 *
	 * @param cancionController el controlador de canciones
	 */
	public AltaCancionDesign(CancionController cancionController)
	{
		this.cancionController = cancionController;
		initComponents();
	}

	/**
	 * Inicializa y configura los componentes de la interfaz gráfica.
	 */
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
		setBounds(Constantes.POSITION_X_WINDOWS, Constantes.POSITION_Y_WINDOWS,
				Constantes.BOUNDS_WIDTH_WINDOWS, Constantes.BOUNDS_HEIGHT_WINDOWS
		);
		setTitle("Alta cancion");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * La clase `AltaCancionView` es una clase interna que representa el panel de la interfaz gráfica para agregar una
	 * canción. Extiende la clase `JPanel` e implementa la interfaz `ActionListener` para manejar eventos de botones.
	 */
	class AltaCancionView extends JPanel implements ActionListener
	{
		private JLabel lblNombre, lblDuracion;
		private JTextField txtNombre;
		private JSpinner txtDuracion;
		private JButton btnDarAlta;
		private SpinnerNumberModel modelDuracion;
		private final CancionController cancionController;

		/**
		 * Crea una instancia de `AltaCancionView`.
		 *
		 * @param cancionController el controlador de canciones
		 */
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

		/**
		 * Inicializa y configura los componentes del panel.
		 */
		public void initComponents()
		{
			setSize(400, 300);

			lblNombre = new JLabel("Nombre:");
			txtNombre = new JTextField(20);

			lblDuracion = new JLabel("Duración:");
			//modelDuracion = new SpinnerNumberModel(0.0, 0.0, 3000.0, 0.1);
			SpinnerNumberModel model = new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.1);
			JSpinner spinner = new JSpinner(model);

			JSpinner.NumberEditor editor = new JSpinner.NumberEditor(spinner, "0.0");
			DecimalFormat format = editor.getFormat();
			format.setMinimumFractionDigits(1);
			spinner.setEditor(editor);
			txtDuracion = spinner;

			btnDarAlta = new JButton("Dar alta Cancion");

			setLayout(new GridLayout(3, 2));
			add(lblNombre);
			add(txtNombre);
			add(lblDuracion);
			add(txtDuracion);
			add(btnDarAlta);

			btnDarAlta.addActionListener(this);
		}

		/**
		 * Realiza la acción de dar de alta una canción.
		 */
		public void accionDarAltaCancion()
		{
			String nombre = txtNombre.getText();
			double duracion2 = (double) txtDuracion.getValue();
			float duracion = (float) duracion2;

			if (nombre.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos",
						"ERROR", JOptionPane.ERROR_MESSAGE
				);
				return;
			}
			if (duracion == 0.0)
			{
				JOptionPane.showMessageDialog(null, "La duracion de la cancion no puede ser 0",
						"ERROR", JOptionPane.ERROR_MESSAGE
				);
			}
			else
			{
				cancionController.altaCancion(nombre, duracion);

				JOptionPane.showMessageDialog(null, "Cancion agregada correctamente");

				txtNombre.setText("");
				txtDuracion.setValue(0.0);
			}
		}
	}
}
