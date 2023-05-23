package com.videoclub.view;

import com.videoclub.controller.AlquilerController;
import com.videoclub.controller.MultimediaController;
import com.videoclub.controller.SocioController;
import com.videoclub.model.Socio;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@SuppressWarnings("JoinDeclarationAndAssignmentJava")
public class ListadoSocioDesign extends JFrame implements ActionListener
{
	private GridLayout grdLayout;
	private JComboBox<String> cmboBoxOptions;
	private JButton btnFind;
	private JTable tblResults;
	private JTextField txtFieldPrompt;
	private MemberTableModel tblModel;
	private SocioController socioController;
	private MultimediaController multimediaController;
	private AlquilerController alquilerController;
	private JPanel mainPanel;
	private JScrollPane scrollPane;

	public ListadoSocioDesign(SocioController socioController, MultimediaController multimediaController, AlquilerController alquilerController)
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
		if (actionEvent.getSource().equals(btnFind))
		{
			updateTable();
		}
	}

	public void initComponents()
	{
		grdLayout = new GridLayout();
		mainPanel = new JPanel();
		cmboBoxOptions = new JComboBox<>();
		btnFind = new JButton();
		txtFieldPrompt = new JTextField();
		tblModel = new MemberTableModel();
		tblResults = new JTable(tblModel);
		scrollPane = new JScrollPane(tblResults);

	}

	public void configComponents()
	{
		//
		setLayout(grdLayout);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//
		txtFieldPrompt.setPreferredSize(new Dimension(200, 30));

		//
		cmboBoxOptions.addItem("Buscar por NIF");
		cmboBoxOptions.addItem("Buscar por Nombre");

		//
		btnFind.setText("Find");
		btnFind.addActionListener(this);

		//
		ArrayList<Socio> listSocio = socioController.todosLosSocios();
		String[] columnNames = {"NIF", "Nombre", "Fecha Naciemiento", "Poblacion"};

		tblModel.setData(listSocio);
		tblModel.setColumnNames(columnNames);

		tblModel.fireTableDataChanged();
		tblModel.fireTableStructureChanged();

		//
		mainPanel.add(cmboBoxOptions);
		mainPanel.add(txtFieldPrompt);
		mainPanel.add(btnFind);

		//
		add(mainPanel);
		add(scrollPane);
	}

	public void updateTable()
	{
		String userInputText = txtFieldPrompt.getText();

		if (cmboBoxOptions.getSelectedItem().equals("Buscar por NIF"))
		{
			tblModel.setData(socioController.filtroPorNombre(userInputText));
		}
		else if (cmboBoxOptions.getSelectedItem().equals("Buscar por Nombre"))
		{
			tblModel.setData(socioController.filtroPorNIF(userInputText));
		}

		tblModel.fireTableDataChanged();
	}

	class MemberTableModel extends AbstractTableModel
	{
		private ArrayList<Socio> data;
		private String[] columnNames;

		public MemberTableModel()
		{
			data = new ArrayList<>();
			columnNames = new String[]{"Column1", "Column2", "Column3", "Column4"};
		}

		public MemberTableModel(ArrayList<Socio> listSocio, String[] columnNames)
		{
			this.data = listSocio;
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
			Socio socio = data.get(row);

			if (column == 0)
			{
				return socio.getNif();
			}
			else if (column == 1)
			{
				return socio.getNombre();
			}
			else if (column == 2)
			{
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String formattedDate = socio.getFechaNacimiento().format(formatter);

				return formattedDate;
			}
			else if (column == 3)
			{
				return socio.getPoblacion();
			}

			return null;
		}

		@Override
		public String getColumnName(int column)
		{
			return columnNames[column];
		}

		public void setData(ArrayList<Socio> data)
		{
			this.data = data;
		}

		public void setColumnNames(String[] columnNames)
		{
			this.columnNames = columnNames;
		}
	}
}