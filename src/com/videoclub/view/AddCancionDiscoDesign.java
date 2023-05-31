package com.videoclub.view;

import com.videoclub.controller.CancionController;
import com.videoclub.controller.MultimediaController;
import com.videoclub.model.Cancion;
import com.videoclub.model.Constantes;
import com.videoclub.model.Disco;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Esta clase representa una interfaz de usuario para agregar canciones a un disco en un videoclub.
 */
public class AddCancionDiscoDesign extends JFrame implements ActionListener
{

	/**
	 * Declaración de controllers
	 */
	MultimediaController multimediaController;
	CancionController cancionController;
	/**
	 * Declaración de atributos
	 */
	private JPanel panel;
	private JLabel lblSelectDisco;
	private JLabel lblSelectCancion;
	private JButton btnAdd;
	private JComboBox cboxDisco;
	private JComboBox cboxCancion;
	private final ArrayList<Cancion> listCanciones;
	private ArrayList<Disco> listDiscos;

	/**
	 * Inicializa una instancia de la clase AddCancionDiscoDesign.
	 *
	 * @param mc el controlador de multimedia
	 * @param cc el controlador de canciones
	 */
	public AddCancionDiscoDesign(MultimediaController mc, CancionController cc)
	{
		multimediaController = mc;
		cancionController = cc;
		listCanciones = cancionController.returnCancion();

		initComponents();
		configComponents();
	}

	/**
	 * Inicializa los atributos de la clase.
	 */
	public void initComponents()
	{
		panel = new JPanel();
		lblSelectDisco = new JLabel();
		lblSelectCancion = new JLabel();
		btnAdd = new JButton();
		cboxDisco = new JComboBox<>();
		cboxCancion = new JComboBox<>();
	}

	/**
	 * Configura los componentes de la interfaz gráfica.
	 */
	public void configComponents()
	{
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(Constantes.POSITION_X_WINDOWS, Constantes.POSITION_Y_WINDOWS, Constantes.BOUNDS_WIDTH_WINDOWS, Constantes.BOUNDS_HEIGHT_WINDOWS);
		setTitle("Agregar canciones a disco");

		lblSelectDisco.setText("Selecciona un disco: ");
		lblSelectCancion.setText("Selecciona una cancion: ");

		cboxDisco = new JComboBox(multimediaController.obtenerDiscosTitulo());
		cboxCancion = new JComboBox(cancionController.obtenerCancionesNombre());

		btnAdd.setText("Añadir");
		btnAdd.addActionListener(this);

		panel.add(lblSelectDisco);
		panel.add(cboxDisco);
		panel.add(lblSelectCancion);
		panel.add(cboxCancion);
		panel.add(btnAdd);

		add(panel);
	}

	/**
	 * Actualiza los ComboBox de disco y canción.
	 */
	public void refreshComboBox()
	{
		DefaultComboBoxModel<String> modelDisco = new DefaultComboBoxModel<>(multimediaController.obtenerDiscosTitulo());
		cboxDisco.setModel(modelDisco);
		DefaultComboBoxModel<String> modelCancion = new DefaultComboBoxModel<>(cancionController.obtenerCancionesNombre());
		cboxCancion.setModel(modelCancion);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			multimediaController.aniadirCancionToDisco(
					cancionController.filtroCancionPorNombre(cboxCancion.getSelectedItem().toString()),
					multimediaController.filtroDiscoPorTitulo(cboxDisco.getSelectedItem().toString())
			);
			Cancion cancion = cancionController.filtroCancionPorNombre(cboxCancion.getSelectedItem().toString());
			cancionController.darBajaCancion(cancion.getNombre(), cancion.getDuracion());
			JOptionPane.showMessageDialog(null, "Cancion agregada al disco correctamente");
			DefaultComboBoxModel<String> modelCancion = new DefaultComboBoxModel<>(cancionController.obtenerCancionesNombre());
			cboxCancion.setModel(modelCancion);
		}
		catch (Exception exception)
		{
			JOptionPane.showMessageDialog(null, "Fallo al añadir cancion al disco",
					"ERROR", JOptionPane.ERROR_MESSAGE
			);
		}
	}
}
