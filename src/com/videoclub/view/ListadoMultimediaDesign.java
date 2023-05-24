package com.videoclub.view;

import com.videoclub.controller.AlquilerController;
import com.videoclub.controller.MultimediaController;
import com.videoclub.controller.SocioController;
import com.videoclub.model.Constantes;
import com.videoclub.model.Multimedia;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("JoinDeclarationAndAssignmentJava")
public class ListadoMultimediaDesign extends JFrame implements ActionListener
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

	public ListadoMultimediaDesign(SocioController socioController, MultimediaController multimediaController, AlquilerController alquilerController)
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
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(Constantes.POSITION_X_WINDOWS, Constantes.POSITION_Y_WINDOWS, Constantes.BOUNDS_WIDTH_WINDOWS, Constantes.BOUNDS_HEIGHT_WINDOWS);

		//
		txtFieldPrompt.setPreferredSize(new Dimension(200, 30));

		//
		cmboBoxOptions.addItem("Sin filtro");
		cmboBoxOptions.addItem("Buscar por título");
		cmboBoxOptions.addItem("Buscar por autor");

		//
		btnFind.setText("Find");
		btnFind.addActionListener(this);

		//
		ArrayList<Multimedia> listMultimedia = multimediaController.returnStuff();
		String[] columnNames = {"Titulo", "Autor", "Formato", "Año"};

		tblModel.setData(listMultimedia);
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

		if (cmboBoxOptions.getSelectedItem().equals("Buscar por título"))
		{
			tblModel.setData(multimediaController.filtroPorTitulo(userInputText));
		}
		else if (cmboBoxOptions.getSelectedItem().equals("Buscar por autor"))
		{
			tblModel.setData(multimediaController.filtroPorAutor(userInputText));
		}
		else if (cmboBoxOptions.getSelectedItem().equals("Sin filtro"))
		{
			tblModel.setData(multimediaController.returnStuff());
		}

		tblModel.fireTableDataChanged();
	}

	class MemberTableModel extends AbstractTableModel
	{
		private ArrayList<Multimedia> data;
		private String[] columnNames;

		public MemberTableModel()
		{
			data = new ArrayList<>();
			columnNames = new String[]{"Column1", "Column2", "Column3", "Column4"};
		}

		public MemberTableModel(ArrayList<Multimedia> listMultimedia, String[] columnNames)
		{
			this.data = listMultimedia;
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
			Multimedia multimedia = data.get(row);

			if (column == 0)
			{
				return multimedia.getTitulo();
			}
			else if (column == 1)
			{
				return multimedia.getAutor();
			}
			else if (column == 2)
			{
				return multimedia.getFormat();
			}
			else if (column == 3)
			{
				return multimedia.getAnio();
			}

			return null;
		}

		@Override
		public String getColumnName(int column)
		{
			return columnNames[column];
		}

		public void setData(ArrayList<Multimedia> data)
		{
			this.data = data;
		}

		public void setColumnNames(String[] columnNames)
		{
			this.columnNames = columnNames;
		}
	}
}
