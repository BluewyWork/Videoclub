package com.videoclub.view;

import com.videoclub.controller.AlquilerController;
import com.videoclub.controller.MultimediaController;
import com.videoclub.controller.SocioController;
import com.videoclub.model.Constantes;
import com.videoclub.model.Pelicula;
import com.videoclub.model.Videojuego;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("JoinDeclarationAndAssignmentJava")
public class ListadoVideojuegoDesign extends JFrame implements ActionListener
{
	private JTable tblResults;
	private MemberTableModel tblModel;
	private SocioController socioController;
	private MultimediaController multimediaController;
	private AlquilerController alquilerController;
	private JPanel mainPanel;
	private JScrollPane scrollPane;

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

	public void initComponents()
	{
		mainPanel = new JPanel();
		tblModel = new MemberTableModel();
		tblResults = new JTable(tblModel);
		scrollPane = new JScrollPane(tblResults);
	}

	public void refreshTable()
	{
		tblModel.setData(multimediaController.obtenerVideojuegosOrdenadosPorAnio());
		tblModel.fireTableDataChanged();
	}

	public void configComponents()
	{
		//
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(Constantes.POSITION_X_WINDOWS, Constantes.POSITION_Y_WINDOWS, Constantes.BOUNDS_WIDTH_WINDOWS, Constantes.BOUNDS_HEIGHT_WINDOWS);
		setTitle("Listado peliculas ordenados por titulo");

		//
		ArrayList<Videojuego> listVideojuego = multimediaController.obtenerVideojuegosOrdenadosPorAnio();
		String[] columnNames = {"Titulo", "Autor", "Formato", "Año", "Plataforma"};

		tblModel.setData(listVideojuego);
		tblModel.setColumnNames(columnNames);

		tblModel.fireTableDataChanged();
		tblModel.fireTableStructureChanged();

		//
		add(mainPanel);
		add(scrollPane);
	}

	public void updateTable()
	{
		tblModel.fireTableDataChanged();
	}

	class MemberTableModel extends AbstractTableModel
	{
		private ArrayList<Videojuego> data;
		private String[] columnNames;

		public MemberTableModel()
		{
			data = new ArrayList<>();
			columnNames = new String[]{"Column1", "Column2", "Column3", "Column4", "Column5"};
		}

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

		public void setData(ArrayList<Videojuego> data)
		{
			this.data = data;
		}

		public void setColumnNames(String[] columnNames)
		{
			this.columnNames = columnNames;
		}
	}
}

