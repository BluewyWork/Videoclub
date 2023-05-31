package com.videoclub.view;

import com.videoclub.controller.CancionController;
import com.videoclub.controller.MultimediaController;
import com.videoclub.model.Cancion;
import com.videoclub.model.Constantes;
import com.videoclub.model.Disco;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * La clase ListadoCancionDesign representa una ventana de GUI para mostrar un listado de canciones de un disco,
 * ordenadas por duración.
 */
@SuppressWarnings("JoinDeclarationAndAssignmentJava")
public class ListadoCancionDesign extends JFrame implements ActionListener
{
	private ArrayList<Disco> discos;
	private GridLayout grdLayout;
	private JComboBox<String> cmboBoxOptions;
	private JLabel lblDisco;
	private JButton btnSeleccionar;
	private JTable tblResults;
	private MemberTableModel tblModel;
	private final MultimediaController multimediaController;
	private final CancionController cancionController;
	private JPanel mainPanel;
	private JScrollPane scrollPane;

	/**
	 * Crea una instancia de ListadoCancionDesign.
	 *
	 * @param multimediaController El controlador de multimedia.
	 * @param cancionController    El controlador de canciones.
	 */
	public ListadoCancionDesign(MultimediaController multimediaController, CancionController cancionController)
	{
		this.multimediaController = multimediaController;
		this.cancionController = cancionController;

		initComponents();
		configComponents();
	}

	/**
	 * Acción realizada cuando se dispara un evento.
	 *
	 * @param actionEvent El evento que se ha disparado.
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent)
	{
		if (actionEvent.getSource().equals(btnSeleccionar))
			refreshTable();
	}

	/**
	 * Inicializa los componentes de la interfaz de usuario.
	 */
	public void initComponents()
	{
		grdLayout = new GridLayout();
		mainPanel = new JPanel();
		cmboBoxOptions = new JComboBox<>();
		lblDisco = new JLabel();
		btnSeleccionar = new JButton();
		tblModel = new MemberTableModel();
		tblResults = new JTable(tblModel);
		scrollPane = new JScrollPane(tblResults);
	}

	/**
	 * Configura los componentes de la interfaz de usuario.
	 */
	public void configComponents()
	{
		setLayout(grdLayout);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(Constantes.POSITION_X_WINDOWS, Constantes.POSITION_Y_WINDOWS, Constantes.BOUNDS_WIDTH_WINDOWS, Constantes.BOUNDS_HEIGHT_WINDOWS);
		setTitle("Listado canciones de un disco ordenados por duracion");

		lblDisco.setText("Selecciona un disco");

		cmboBoxOptions = new JComboBox(multimediaController.obtenerDiscosTitulo());

		btnSeleccionar.setText("Seleccionar");
		btnSeleccionar.addActionListener(this);

		ArrayList<Cancion> listCanciones = new ArrayList<>();
		String[] columnNames = {"Nombre", "Duracion"};

		tblModel.setData(listCanciones);
		tblModel.setColumnNames(columnNames);

		tblModel.fireTableDataChanged();
		tblModel.fireTableStructureChanged();

		mainPanel.add(lblDisco);
		mainPanel.add(cmboBoxOptions);
		mainPanel.add(btnSeleccionar);

		add(mainPanel);
		add(scrollPane);
	}

	/**
	 * Actualiza la tabla de canciones.
	 */
	public void refreshTable()
	{
		try
		{
			tblModel.setData(cancionController.obtenerCancionesPorDuracion(multimediaController.filtroDiscoPorTitulo(cmboBoxOptions.getSelectedItem().toString())));
			tblModel.fireTableDataChanged();
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "No existe ningun disco",
					"ERROR", JOptionPane.ERROR_MESSAGE
			);
			e.printStackTrace();
		}
	}

	/**
	 * Actualiza el combo box de discos.
	 */
	public void refreshComboBox()
	{
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(multimediaController.obtenerDiscosTitulo());
		cmboBoxOptions.setModel(model);
	}

	/**
	 * La clase MemberTableModel es una implementación de AbstractTableModel utilizada para la tabla de canciones.
	 */
	class MemberTableModel extends AbstractTableModel
	{
		private ArrayList<Cancion> data;
		private String[] columnNames;

		/**
		 * Crea una instancia de MemberTableModel con valores predeterminados.
		 */
		public MemberTableModel()
		{
			data = new ArrayList<>();
			columnNames = new String[]{"Column1", "Column2"};
		}

		/**
		 * Crea una instancia de MemberTableModel con los datos y nombres de columna especificados.
		 *
		 * @param listCanciones Los datos de las canciones.
		 * @param columnNames   Los nombres de las columnas.
		 */
		public MemberTableModel(ArrayList<Cancion> listCanciones, String[] columnNames)
		{
			this.data = listCanciones;
			this.columnNames = columnNames;
		}

		/**
		 * Obtiene el número de filas en la tabla.
		 *
		 * @return El número de filas.
		 */
		@Override
		public int getRowCount()
		{
			return data.size();
		}

		/**
		 * Obtiene el número de columnas en la tabla.
		 *
		 * @return El número de columnas.
		 */
		@Override
		public int getColumnCount()
		{
			return columnNames.length;
		}

		/**
		 * Obtiene el valor en la posición de fila y columna especificada.
		 *
		 * @param row    La posición de fila.
		 * @param column La posición de columna.
		 * @return El valor en la posición dada.
		 */
		@Override
		public Object getValueAt(int row, int column)
		{
			Cancion cancion = data.get(row);

			if (column == 0)
			{
				return cancion.getNombre();
			}
			else if (column == 1)
			{
				return cancion.getDuracion();
			}

			return null;
		}

		/**
		 * Obtiene el nombre de la columna en la posición especificada.
		 *
		 * @param column La posición de columna.
		 * @return El nombre de la columna.
		 */
		@Override
		public String getColumnName(int column)
		{
			return columnNames[column];
		}

		/**
		 * Establece los datos en la tabla.
		 *
		 * @param data Los nuevos datos de la tabla.
		 */
		public void setData(ArrayList<Cancion> data)
		{
			this.data = data;
		}

		/**
		 * Establece los nombres de las columnas en la tabla.
		 *
		 * @param columnNames Los nuevos nombres de las columnas.
		 */
		public void setColumnNames(String[] columnNames)
		{
			this.columnNames = columnNames;
		}
	}
}
