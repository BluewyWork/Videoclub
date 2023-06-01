package com.videoclub.view;

import com.videoclub.controller.SocioController;
import com.videoclub.model.Constantes;
import com.videoclub.util.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase `AltaSocioDesign` es una clase que representa la interfaz gráfica para agregar un socio en un videoclub.
 * Extiende la clase `JFrame` para crear una ventana.
 */
public class AltaSocioDesign extends JFrame
{
	private AltaSocioView secondPanel;
	private final SocioController socioController;
	private JPanel firstPanel;

	/**
	 * Crea una instancia de `AltaSocioDesign`.
	 *
	 * @param socio el controlador de socio
	 */
	public AltaSocioDesign(SocioController socio)
	{
		socioController = socio;
		initComponents();
	}

	/**
	 * Inicializa y configura los componentes de la interfaz gráfica.
	 */
	public void initComponents()
	{
		firstPanel = new JPanel();
		firstPanel.setPreferredSize(new Dimension(350, 400));
		firstPanel.setBackground(Color.pink);

		secondPanel = new AltaSocioView(socioController);
		secondPanel.setPreferredSize(new Dimension(350, 450));

		setLayout(new FlowLayout());
		add(firstPanel);
		add(secondPanel);
		pack();

		getContentPane().setBackground(Color.pink);
		setBounds(Constantes.POSITION_X_WINDOWS, Constantes.POSITION_Y_WINDOWS,
				Constantes.BOUNDS_WIDTH_WINDOWS, Constantes.BOUNDS_HEIGHT_WINDOWS
		);
		setTitle("Alta Socio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * La clase `AltaSocioView` es una clase interna que representa el panel de la interfaz gráfica para agregar un
	 * socio. Extiende la clase `JPanel` e implementa la interfaz `ActionListener` para manejar eventos de botones.
	 */
	public class AltaSocioView extends JPanel implements ActionListener
	{
		private JTextField txtNombre;
		private JTextField txtNIF;
		private JTextField txtFechaNacimiento;
		private JTextField txtPoblacion;
		private SocioController socioController;
		private JButton btnDarAlta;

		/**
		 * Crea una instancia de `AltaSocioView`.
		 *
		 * @param socio el controlador de socio
		 */
		public AltaSocioView(SocioController socio)
		{
			socioController = socio;
			initComponents();
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			accionDarAltaSocio();
			Logger.log("Socio Creado");
		}

		/**
		 * Inicializa y configura los componentes del panel.
		 */
		public void initComponents()
		{
			// Configuración de la ventana
			setSize(300, 200);

			// Creación de los componentes visuales
			JLabel lblNombre = new JLabel("Nombre:");
			txtNombre = new JTextField(20);

			JLabel lblNIF = new JLabel("NIF:");
			txtNIF = new JTextField(10);

			JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento:");
			txtFechaNacimiento = new JTextField(10);

			JLabel lblPoblacion = new JLabel("Poblacion:");
			txtPoblacion = new JTextField(20);

			btnDarAlta = new JButton("Dar alta socio");

			// Configuración del diseño de la ventana
			setLayout(new GridLayout(5, 2));
			add(lblNombre);
			add(txtNombre);
			add(lblNIF);
			add(txtNIF);
			add(lblFechaNacimiento);
			add(txtFechaNacimiento);
			add(lblPoblacion);
			add(txtPoblacion);
			add(new JPanel());
			add(btnDarAlta);

			// Asignar el ActionListener al botón de guardar
			btnDarAlta.addActionListener(this);
		}

		/**
		 * Realiza la acción de dar de alta un socio, obteniendo los valores de los campos de entrada y llamando al
		 * controlador de socio para agregar al socio.
		 */
		public void accionDarAltaSocio()
		{
			// Obtener los datos ingresados por el usuario
			String nif = txtNIF.getText();
			String nombre = txtNombre.getText();
			String fechaNacimientoText = txtFechaNacimiento.getText();
			String poblacion = txtPoblacion.getText();

			// Validar que los campos no estén vacíos
			if (nif.isEmpty() || nombre.isEmpty() || fechaNacimientoText.isEmpty() || poblacion.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos",
						"ERROR", JOptionPane.ERROR_MESSAGE
				);
				return;
			}
			else if (socioController.encontrarSocio(nif) != null)
			{
				JOptionPane.showMessageDialog(null, "Ya existe un socio con ese nif",
						"ERROR", JOptionPane.ERROR_MESSAGE
				);
				return;
			}

			// Llamar al método para agregar el socio en el controlador de socio
			socioController.registrarSocio(nif, nombre, fechaNacimientoText, poblacion);

			// Mostrar un mensaje de éxito
			JOptionPane.showMessageDialog(null, "Socio agregado correctamente");

			// Limpiar los campos de texto
			txtNIF.setText("");
			txtNombre.setText("");
			txtFechaNacimiento.setText("");
			txtPoblacion.setText("");
		}
	}
}
