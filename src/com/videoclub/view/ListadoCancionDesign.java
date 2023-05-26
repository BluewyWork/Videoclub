package com.videoclub.view;

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

@SuppressWarnings("JoinDeclarationAndAssignmentJava")
public class ListadoCancionDesign extends JFrame implements ActionListener
{
	private String[] discoNameList;
	private ArrayList<Disco> discos;
	private GridLayout grdLayout;
	private JComboBox<String> cmboBoxOptions;
	private JLabel lblDisco;
	private JButton btnSeleccionar;
	private JTable tblResults;
	private MemberTableModel tblModel;
	private MultimediaController multimediaController;
	private JPanel mainPanel;
	private JScrollPane scrollPane;

	public ListadoCancionDesign(MultimediaController multimediaController)
	{
		this.multimediaController = multimediaController;

		initComponents();
		configComponents();
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent)
	{
		refreshTable();
	}

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

	public void configComponents()
	{
		//
		setLayout(grdLayout);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(Constantes.POSITION_X_WINDOWS, Constantes.POSITION_Y_WINDOWS, Constantes.BOUNDS_WIDTH_WINDOWS, Constantes.BOUNDS_HEIGHT_WINDOWS);
		setTitle("Listado canciones de un disco ordenados por duracion");

		//
		lblDisco.setText("Selecciona un disco");

		//
		ArrayList<Disco> discosAux = new ArrayList<>();

		for (int i = 0; i < multimediaController.returnStuff().size(); i++)
		{
			if (multimediaController.returnStuff().get(i) instanceof Disco)
			{
				discosAux.add((Disco) multimediaController.returnStuff().get(i));
			}
		}

		discos = discosAux;
		discoNameList = new String[discosAux.size()];

		for (int i = 0; i < discosAux.size(); i++)
		{
			discoNameList[i] = discosAux.get(i).getTitulo();
		}

		cmboBoxOptions = new JComboBox(discoNameList);

		//
		btnSeleccionar.setText("Seleccionar");
		btnSeleccionar.addActionListener(this);

		//
		ArrayList<Cancion> listCanciones = multimediaController.obtenerCancionesPorDuracion(getSelectedDisco());
		String[] columnNames = {"Nombre", "Duracion"};

		tblModel.setData(listCanciones);
		tblModel.setColumnNames(columnNames);

		tblModel.fireTableDataChanged();
		tblModel.fireTableStructureChanged();

		//
		mainPanel.add(lblDisco);
		mainPanel.add(cmboBoxOptions);
		mainPanel.add(btnSeleccionar);

		//
		add(mainPanel);
		add(scrollPane);
	}

	public void refreshTable()
	{
		tblModel.setData(multimediaController.obtenerCancionesPorDuracion(getSelectedDisco()));
		tblModel.fireTableDataChanged();
	}

	public Disco getSelectedDisco()
	{
		Disco discoSeleccionado = null;
		for (Disco disco : discos)
		{
			if (cmboBoxOptions.getSelectedItem().equals(disco.getTitulo()))
				discoSeleccionado = disco;
		}
		return discoSeleccionado;
	}

	class MemberTableModel extends AbstractTableModel
	{
		private ArrayList<Cancion> data;
		private String[] columnNames;

		public MemberTableModel()
		{
			data = new ArrayList<>();
			columnNames = new String[]{"Column1", "Column2"};
		}

		public MemberTableModel(ArrayList<Cancion> listCanciones, String[] columnNames)
		{
			this.data = listCanciones;
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

		@Override
		public String getColumnName(int column)
		{
			return columnNames[column];
		}

		public void setData(ArrayList<Cancion> data)
		{
			this.data = data;
		}

		public void setColumnNames(String[] columnNames)
		{
			this.columnNames = columnNames;
		}
	}
}
