package com.videoclub.view;

import com.videoclub.controller.AlquilerController;
import com.videoclub.controller.MultimediaController;
import com.videoclub.controller.SocioController;
import com.videoclub.model.Constantes;
import com.videoclub.model.Pelicula;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("JoinDeclarationAndAssignmentJava")
public class ListadoPeliculaDesign extends JFrame implements ActionListener
{
	private JTable tblResults;
	private MemberTableModel tblModel;
	private SocioController socioController;
	private MultimediaController multimediaController;
	private AlquilerController alquilerController;
	private JPanel mainPanel;
	private JScrollPane scrollPane;

	public ListadoPeliculaDesign(SocioController socioController, MultimediaController multimediaController, AlquilerController alquilerController)
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
		tblModel.setData(multimediaController.listarPeliculasTitulo());
		tblModel.fireTableDataChanged();
	}

	public void configComponents()
	{
		//
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(Constantes.POSITION_X_WINDOWS, Constantes.POSITION_Y_WINDOWS, Constantes.BOUNDS_WIDTH_WINDOWS, Constantes.BOUNDS_HEIGHT_WINDOWS);
		setTitle("Listados peliculas ordenados por titulo");

		//
		ArrayList<Pelicula> listPelicula = multimediaController.listarPeliculasTitulo();
		String[] columnNames = {"Titulo", "Autor", "Formato", "Año", "algo", "algo", "algo"};

		tblModel.setData(listPelicula);
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
		private ArrayList<Pelicula> data;
		private String[] columnNames;

		public MemberTableModel()
		{
			data = new ArrayList<>();
			columnNames = new String[]{"Column1", "Column2", "Column3", "Column4", "Column5", "Column6", "Column7"};
		}

		public MemberTableModel(ArrayList<Pelicula> listPelicula, String[] columnNames)
		{
			this.data = listPelicula;
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
			Pelicula pelicula = data.get(row);

			if (column == 0)
			{
				return pelicula.getTitulo();
			}
			else if (column == 1)
			{
				return pelicula.getAutor();
			}
			else if (column == 2)
			{
				return pelicula.getFormat();
			}
			else if (column == 3)
			{
				return pelicula.getAnio();
			}
			else if (column == 4)
			{
				return pelicula.getDuracion();
			}
			else if (column == 5)
			{
				return pelicula.getActorPrincipal();
			}
			else if (column == 6)
			{
				return pelicula.getActrizPrincipal();
			}

			return null;
		}

		@Override
		public String getColumnName(int column)
		{
			return columnNames[column];
		}

		public void setData(ArrayList<Pelicula> data)
		{
			this.data = data;
		}

		public void setColumnNames(String[] columnNames)
		{
			this.columnNames = columnNames;
		}
	}
}
