package com.videoclub.view;

import com.videoclub.controller.SocioController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class AltaSocioView extends JFrame implements ActionListener
{
	private JTextField txtNombre;
	private JTextField txtNIF;
	private JTextField txtFechaNacimiento;
	private JTextField txtPoblacion;
	private SocioController socioController;

	public AltaSocioView(SocioController socio)
	{
		// Configuración de la ventana
		setTitle("Alta de Socio");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Creación de los componentes visuales
		JLabel lblNombre = new JLabel("Nombre:");
		txtNombre = new JTextField(20);

		JLabel lblNIF = new JLabel("NIF:");
		txtNIF = new JTextField(10);

		JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento:");
		txtFechaNacimiento = new JTextField(10);

		JLabel lblPoblacion = new JLabel("Poblacion:");
		txtPoblacion = new JTextField(20);

		JButton btnGuardar = new JButton("Guardar");

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
		add(new JPanel()); // Espacio en blanco
		add(btnGuardar);

		// Mostrar la ventana
		setVisible(true);

		// Asignar el ActionListener al botón de guardar
		btnGuardar.addActionListener(this);
}
	public void actionPerformed(ActionEvent e)
	{
		// Obtener los datos ingresados por el usuario
		String nif = txtNIF.getText();
		String nombre = txtNombre.getText();
		String fechaNacimientoText = txtFechaNacimiento.getText();
		String poblacion = txtPoblacion.getText();

		// Validar que los campos no estén vacíos
		if (nif.isEmpty() || nombre.isEmpty() || fechaNacimientoText.isEmpty() || poblacion.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
			return;
		}


		// Llamar al método para agregar el socio en GestorSocioController
		socioController = new SocioController();
		socioController.registrarSocio(nif, nombre, fechaNacimientoText, poblacion);

		// Mostrar un mensaje de éxito
		JOptionPane.showMessageDialog(null, "Socio agregado correctamente");

		// Limpiar los campos de texto
		txtNIF.setText("");
		txtNombre.setText("");
		txtFechaNacimiento.setText("");
		txtPoblacion.setText("");
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

