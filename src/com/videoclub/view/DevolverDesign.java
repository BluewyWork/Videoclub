package com.videoclub.view;

import com.videoclub.controller.AlquilerController;
import com.videoclub.controller.MultimediaController;
import com.videoclub.controller.SocioController;
import com.videoclub.model.Alquiler;
import com.videoclub.model.Constantes;
import com.videoclub.model.Socio;
import com.videoclub.util.Logger;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * La clase DevolverDesign representa la interfaz gráfica de usuario para devolver elementos multimedia alquilados por
 * un socio. Proporciona funcionalidad para buscar un socio por su NIF y mostrar los elementos multimedia alquilados
 * asociados a ese socio. También permite al usuario seleccionar y devolver un elemento multimedia específico.
 */
public class DevolverDesign extends JFrame implements ActionListener
{
	private GridLayout grdLayout;
	private JComboBox<String> cmboBoxOptions;
	private JButton btnFind;
	private JTable tblResults;
	private JTextField txtFieldPrompt;
	private MemberTableModel tblModel;
	private final SocioController socioController;
	private final MultimediaController multimediaController;
	private final AlquilerController alquilerController;
	private JPanel mainPanel;
	private JScrollPane scrollPane;

	private JLabel lblNSocio;
	private JLabel lblNombreSocio;
	private JLabel lblDniSocio;
	private TextField txtFieldNSocio;
	private TextField txtFieldNombreSocio;
	private TextField txtFieldDniSocio;
	private JButton btnDevolver;

	/**
	 * Construye un objeto DevolverDesign con los controladores especificados para Socio, Multimedia y Alquiler.
	 *
	 * @param socioController      el controlador para las operaciones de Socio
	 * @param multimediaController el controlador para las operaciones de Multimedia
	 * @param alquilerController   el controlador para las operaciones de Alquiler
	 */
	public DevolverDesign(SocioController socioController, MultimediaController multimediaController, AlquilerController alquilerController)
	{
		this.socioController = socioController;
		this.multimediaController = multimediaController;
		this.alquilerController = alquilerController;

		initComponents();
		configComponents();
	}

	/**
	 * Maneja las acciones realizadas por el usuario.
	 *
	 * @param actionEvent el objeto ActionEvent que representa la acción del usuario
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent)
	{
		if (actionEvent.getSource().equals(btnFind))
		{
			String nif = txtFieldPrompt.getText();

			Socio socio = socioController.encontrarSocio(nif);

			if (socio != null)
			{
				JOptionPane.showMessageDialog(null, "Socio encontrado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
				txtFieldNombreSocio.setText(socio.getNombre());
				txtFieldDniSocio.setText(socio.getNif());
				ArrayList<Alquiler> listMultimediasAlquiladas = alquilerController.returnStuff(nif);
				tblModel.setData(listMultimediasAlquiladas);
				tblModel.fireTableDataChanged();
				tblModel.fireTableStructureChanged();

				Logger.log("Multimedia Devuelto");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "NIF no válido", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (actionEvent.getSource().equals(btnDevolver))
		{
			int filaSeleccionada = tblResults.getSelectedRow();
			String nif = txtFieldPrompt.getText();
			Socio socio = socioController.encontrarSocio(nif);

			if (filaSeleccionada != -1 && socio != null)
			{
				Alquiler alquiler = tblModel.getObjectAt(filaSeleccionada);
				alquilerController.delvolverAlquiler(alquiler.getContador());
				multimediaController.guardarMultimedia(alquiler.getMultimedia());
				//multimediaController.(multimedia.getTitulo(), multimedia.getAutor());
				tblModel.fireTableDataChanged();
				JOptionPane.showMessageDialog(null, "Multimedia devuelta", "Éxito", JOptionPane.INFORMATION_MESSAGE);
				ArrayList<Alquiler> listMultimediasAlquiladas = alquilerController.returnStuff(nif);
				tblModel.setData(listMultimediasAlquiladas);
				tblModel.fireTableDataChanged();
			}
			else if (filaSeleccionada == -1)
			{
				JOptionPane.showMessageDialog(null, "Seleccione una multimedia para devolver", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "NIF no válido", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Inicializa los componentes de la clase DevolverDesign.
	 */
	public void initComponents()
	{
		grdLayout = new GridLayout();
		mainPanel = new JPanel();
		cmboBoxOptions = new JComboBox<>();
		btnFind = new JButton();
		txtFieldPrompt = new JTextField();
		tblModel = new DevolverDesign.MemberTableModel();
		lblNombreSocio = new JLabel();
		lblDniSocio = new JLabel();
		lblNSocio = new JLabel();
		txtFieldNSocio = new TextField();
		txtFieldNombreSocio = new TextField();
		txtFieldDniSocio = new TextField();
		btnDevolver = new JButton();
		tblResults = new JTable(tblModel);
		scrollPane = new JScrollPane(tblResults);
	}

	/**
	 * Configura los componentes y el diseño de la clase DevolverDesign.
	 */
	public void configComponents()
	{
		//
		setLayout(grdLayout);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(Constantes.POSITION_X_WINDOWS, Constantes.POSITION_Y_WINDOWS, Constantes.BOUNDS_WIDTH_WINDOWS, Constantes.BOUNDS_HEIGHT_WINDOWS);
		setTitle("Devolver multimedia de un socio");

		//
		txtFieldPrompt.setPreferredSize(new Dimension(200, 30));

		//
		cmboBoxOptions.addItem("Buscar por NIF");
		cmboBoxOptions.addItem("Buscar por nombre");

		//
		lblNombreSocio.setText("Socio: ");

		//
		lblNSocio.setText("DNI: ");

		//
		btnFind.setText("Buscar");
		btnFind.addActionListener(this);

		//
		btnDevolver.setText("Devolver");
		btnDevolver.addActionListener(this);

		//
		String[] columnNames = {"Contador", "DNI socio", "Título", "Autor"};

		tblModel.setColumnNames(columnNames);
		tblModel.fireTableDataChanged();
		tblModel.fireTableStructureChanged();

		//
		mainPanel.add(cmboBoxOptions);
		mainPanel.add(txtFieldPrompt);
		mainPanel.add(btnFind);
		mainPanel.add(btnDevolver);

		//
		add(mainPanel);
		add(scrollPane);
	}

	/**
	 * La clase MemberTableModel es una implementación de AbstractTableModel utilizada para mostrar los datos de los
	 * elementos multimedia alquilados en una tabla.
	 */
	class MemberTableModel extends AbstractTableModel
	{
		private ArrayList<Alquiler> data;
		private String[] columnNames;

		/**
		 * Construye un objeto MemberTableModel vacío con nombres de columnas predeterminados.
		 */
		public MemberTableModel()
		{
			data = new ArrayList<>();
			columnNames = new String[]{"Columna1", "Columna2", "Columna3", "Columna4"};
		}

		/**
		 * Construye un objeto MemberTableModel con los datos y los nombres de columnas especificados.
		 *
		 * @param alquilers   los datos de los elementos multimedia alquilados
		 * @param columnNames los nombres de las columnas de la tabla
		 */
		public MemberTableModel(ArrayList<Alquiler> alquilers, String[] columnNames)
		{
			this.data = alquilers;
			this.columnNames = columnNames;
		}

		/**
		 * Devuelve el objeto Alquiler en la fila especificada.
		 *
		 * @param x el índice de la fila
		 * @return el objeto Alquiler en la fila especificada
		 */
		public Alquiler getObjectAt(int x)
		{
			return data.get(x);
		}

		@Override
		public int getRowCount()
		{
			return data.size();
		}

		@Override
		public int getColumnCount()
		{
			return columnNames.length;
		}

		@Override
		public Object getValueAt(int row, int column)
		{
			Alquiler alquiler = data.get(row);

			if (column == 0)
			{
				return alquiler.getContador();
			}
			else if (column == 1)
			{
				return alquiler.getNif();
			}
			else if (column == 2)
			{
				return alquiler.getMultimedia().getTitulo();
			}
			else if (column == 3)
			{
				return alquiler.getMultimedia().getAutor();
			}

			return null;
		}

		@Override
		public String getColumnName(int column)
		{
			return columnNames[column];
		}

		/**
		 * Establece los datos para el modelo de tabla.
		 *
		 * @param data los nuevos datos para el modelo de tabla
		 */
		public void setData(ArrayList<Alquiler> data)
		{
			this.data = data;
		}

		/**
		 * Establece los nombres de las columnas para el modelo de tabla.
		 *
		 * @param columnNames los nuevos nombres de las columnas para el modelo de tabla
		 */
		public void setColumnNames(String[] columnNames)
		{
			this.columnNames = columnNames;
		}
	}
}
