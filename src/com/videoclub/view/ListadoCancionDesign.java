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
	private MultimediaController multimediaController;
	private CancionController cancionController;
	private JPanel mainPanel;
	private JScrollPane scrollPane;

	public ListadoCancionDesign(MultimediaController multimediaController, CancionController cancionController)
	{
		this.multimediaController = multimediaController;
		this.cancionController = cancionController;

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
		cmboBoxOptions = new JComboBox(multimediaController.obtenerDiscosTitulo());

		//
		btnSeleccionar.setText("Seleccionar");
		btnSeleccionar.addActionListener(this);

		//
		ArrayList<Cancion> listCanciones = new ArrayList<>();
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
		}
	}

	public void refreshComboBox()
	{
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(multimediaController.obtenerDiscosTitulo());
		cmboBoxOptions.setModel(model);
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
