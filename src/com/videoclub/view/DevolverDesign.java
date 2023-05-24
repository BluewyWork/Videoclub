package com.videoclub.view;

import com.videoclub.controller.AlquilerController;
import com.videoclub.controller.MultimediaController;
import com.videoclub.controller.SocioController;
import com.videoclub.model.Alquiler;
import com.videoclub.model.Multimedia;
import com.videoclub.model.Socio;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DevolverDesign extends JFrame implements ActionListener
{
	private GridLayout grdLayout;
	private JComboBox<String> cmboBoxOptions;
	private JButton btnFind;
	private JTable tblResults;
	private JTextField txtFieldPrompt;
	private DevolverDesign.MemberTableModel tblModel;
	private SocioController socioController;
	private MultimediaController multimediaController;
	private AlquilerController alquilerController;
	private JPanel mainPanel;
	private JScrollPane scrollPane;

	private JLabel lblNSocio;
	private JLabel lblNombreSocio;
	private JLabel lblDniSocio;
	private TextField txtFieldNSocio;
	private TextField txtFieldNombreSocio;
	private TextField txtFieldDniSocio;
	private JButton btnDevolver;

	public DevolverDesign(SocioController socioController, MultimediaController multimediaController, AlquilerController alquilerController)
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
			String nif = txtFieldPrompt.getText();

			Socio socio = socioController.encontrarSocio(nif);

			if (socio != null)
			{
				JOptionPane.showMessageDialog(null, "Socio encontrado", "Success", JOptionPane.INFORMATION_MESSAGE);
				txtFieldNombreSocio.setText(socio.getNombre());
				txtFieldDniSocio.setText(socio.getNif());
				ArrayList<Alquiler> listMultimediasAlquiladas = alquilerController.returnStuff(nif);
				tblModel.setData(listMultimediasAlquiladas);
				tblModel.fireTableDataChanged();
				tblModel.fireTableStructureChanged();

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
				JOptionPane.showMessageDialog(null, "Multimedia devuelta", "Success", JOptionPane.INFORMATION_MESSAGE);

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
		lblNombreSocio.setText("Socio: ");

		//
		lblNSocio.setText("DNI: ");

		//
		btnFind.setText("Find");
		btnFind.addActionListener(this);

		//
		btnDevolver.setText("Devolver");
		btnDevolver.addActionListener(this);

		//
		String[] columnNames = {"Contador", "DNI socio", "Titulo", "Autor"};

		tblModel.setColumnNames(columnNames);



		//
		mainPanel.add(cmboBoxOptions);
		mainPanel.add(txtFieldPrompt);
		mainPanel.add(btnFind);
		mainPanel.add(btnDevolver);

		//
		add(mainPanel);
		add(scrollPane);
	}

	class MemberTableModel extends AbstractTableModel
	{
		private ArrayList<Alquiler> data;
		private String[] columnNames;

		public MemberTableModel()
		{
			data = new ArrayList<>();
			columnNames = new String[]{"Column1", "Column2", "Column3", "Column4"};
		}

		public MemberTableModel(ArrayList<Alquiler> alquilers, String[] columnNames)
		{
			this.data = alquilers;
			this.columnNames = columnNames;
		}

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

		public void setData(ArrayList<Alquiler> data)
		{
			this.data = data;
		}

		public void setColumnNames(String[] columnNames)
		{
			this.columnNames = columnNames;
		}
	}
}
