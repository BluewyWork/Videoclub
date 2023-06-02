package com.videoclub.view;

import com.videoclub.controller.AlquilerController;
import com.videoclub.controller.MultimediaController;
import com.videoclub.controller.SocioController;
import com.videoclub.model.Constantes;
import com.videoclub.model.Videojuego;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * La clase ListadoVideojuegoDesign es una ventana que muestra un listado de videojuegos ordenados por año. Utiliza un
 * JTable para mostrar los datos y se actualiza al hacer clic en un botón.
 */
public class ListadoVideojuegoDesign extends JFrame implements ActionListener
{
	private JTable tblResults;
	private MemberTableModel tblModel;
	private final SocioController socioController;
	private final MultimediaController multimediaController;
	private final AlquilerController alquilerController;
	private JPanel mainPanel;
	private JScrollPane scrollPane;

	/**
	 * Crea una instancia de ListadoVideojuegoDesign.
	 *
	 * @param socioController      el controlador de socios
	 * @param multimediaController el controlador de multimedia
	 * @param alquilerController   el controlador de alquileres
	 */
	public ListadoVideojuegoDesign(SocioController socioController, MultimediaController multimediaController, AlquilerController alquilerController)
	{
		this.socioController = socioController;
		this.multimediaController = multimediaController;
		this.alquilerController = alquilerController;

		initComponents();
		configComponents();
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent)
	{
		updateTable();
	}

	/**
	 * Inicializa los componentes de la ventana.
	 */
	public void initComponents()
	{
		mainPanel = new JPanel();
		tblModel = new MemberTableModel();
		tblResults = new JTable(tblModel);
		scrollPane = new JScrollPane(tblResults);
	}

	/**
	 * Actualiza la tabla con los datos de videojuegos obtenidos del controlador de multimedia.
	 */
	public void refreshTable()
	{
		tblModel.setData(multimediaController.obtenerVideojuegosOrdenadosPorAnio());
		tblModel.fireTableDataChanged();
	}

	/**
	 * Configura los componentes de la ventana.
	 */
	public void configComponents()
	{
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(Constantes.POSITION_X_WINDOWS, Constantes.POSITION_Y_WINDOWS, Constantes.BOUNDS_WIDTH_WINDOWS, Constantes.BOUNDS_HEIGHT_WINDOWS);
		setTitle("Listado videojuegos ordenados por año");

		ArrayList<Videojuego> listVideojuego = multimediaController.obtenerVideojuegosOrdenadosPorAnio();
		String[] columnNames = {"Título", "Autor", "Formato", "Año", "Plataforma"};

		tblModel.setData(listVideojuego);
		tblModel.setColumnNames(columnNames);

		tblModel.fireTableDataChanged();
		tblModel.fireTableStructureChanged();

		add(mainPanel);
		add(scrollPane);
	}

	/**
	 * Actualiza la tabla.
	 */
	public void updateTable()
	{
		tblModel.fireTableDataChanged();
	}

	/**
	 * La clase MemberTableModel es un modelo de tabla personalizado que contiene los datos de los videojuegos.
	 */
	class MemberTableModel extends AbstractTableModel
	{
		private ArrayList<Videojuego> data;
		private String[] columnNames;

		/**
		 * Crea una instancia de MemberTableModel con valores predeterminados.
		 */
		public MemberTableModel()
		{
			data = new ArrayList<>();
			columnNames = new String[]{"Column1", "Column2", "Column3", "Column4", "Column5"};
		}

		/**
		 * Crea una instancia de MemberTableModel con los datos y nombres de columna especificados.
		 *
		 * @param listVideojuego la lista de videojuegos
		 * @param columnNames    los nombres de las columnas
		 */
		public MemberTableModel(ArrayList<Videojuego> listVideojuego, String[] columnNames)
		{
			this.data = listVideojuego;
			this.columnNames = columnNames;
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
			Videojuego videojuego = data.get(row);

			if (column == 0)
			{
				return videojuego.getTitulo();
			}
			else if (column == 1)
			{
				return videojuego.getAutor();
			}
			else if (column == 2)
			{
				return videojuego.getFormat();
			}
			else if (column == 3)
			{
				return videojuego.getAnio();
			}
			else if (column == 4)
			{
				return videojuego.getPlatform();
			}

			return null;
		}

		@Override
		public String getColumnName(int column)
		{
			return columnNames[column];
		}

		/**
		 * Establece los datos del modelo de tabla.
		 *
		 * @param data los datos de los videojuegos
		 */
		public void setData(ArrayList<Videojuego> data)
		{
			this.data = data;
		}

		/**
		 * Establece los nombres de las columnas del modelo de tabla.
		 *
		 * @param columnNames los nombres de las columnas
		 */
		public void setColumnNames(String[] columnNames)
		{
			this.columnNames = columnNames;
		}
	}
}
