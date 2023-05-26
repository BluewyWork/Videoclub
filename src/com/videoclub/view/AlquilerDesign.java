package com.videoclub.view;

import com.videoclub.controller.AlquilerController;
import com.videoclub.controller.MultimediaController;
import com.videoclub.controller.SocioController;
import com.videoclub.model.Constantes;
import com.videoclub.model.Multimedia;
import com.videoclub.model.Socio;
import com.videoclub.util.Logger;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("JoinDeclarationAndAssignmentJava")
public class AlquilerDesign extends JFrame implements ActionListener
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
	private JButton btnRent;

	public AlquilerDesign(SocioController socioController, MultimediaController multimediaController, AlquilerController alquilerController)
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
			}
			else
			{
				JOptionPane.showMessageDialog(null, "NIF no válido", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (actionEvent.getSource().equals(btnRent))
		{
			int filaSeleccionada = tblResults.getSelectedRow();
			String nif = txtFieldPrompt.getText();
			Socio socio = socioController.encontrarSocio(nif);

			if (filaSeleccionada != -1 && socio != null)
			{
				Multimedia multimedia = tblModel.getObjectAt(filaSeleccionada);
				alquilerController.alquilarMultimedia(nif, multimedia);
				multimediaController.eliminarMultimediaDisponible(multimedia.getTitulo(), multimedia.getAutor());
				tblModel.fireTableDataChanged();
				JOptionPane.showMessageDialog(null, "Multimedia alquilada", "Success", JOptionPane.INFORMATION_MESSAGE);

				Logger.log("Multimedia Alquilada");
			}
			else if (filaSeleccionada == -1)
			{
				JOptionPane.showMessageDialog(null, "Seleccione una multimedia para alquilar", "Error", JOptionPane.ERROR_MESSAGE);
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
		tblModel = new MemberTableModel();
		lblNombreSocio = new JLabel();
		lblDniSocio = new JLabel();
		lblNSocio = new JLabel();
		txtFieldNSocio = new TextField();
		txtFieldNombreSocio = new TextField();
		txtFieldDniSocio = new TextField();
		btnRent = new JButton();
		tblResults = new JTable(tblModel);
		scrollPane = new JScrollPane(tblResults);
	}

	public void configComponents()
	{
		//
		setLayout(grdLayout);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(Constantes.POSITION_X_WINDOWS, Constantes.POSITION_Y_WINDOWS, Constantes.BOUNDS_WIDTH_WINDOWS, Constantes.BOUNDS_HEIGHT_WINDOWS);
		setTitle("Alquilar multimedia a un socio");

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
		btnRent.setText("Rent");
		btnRent.addActionListener(this);

		//
		ArrayList<Multimedia> listMultimedias = multimediaController.returnStuff();
		String[] columnNames = {"Titulo", "Autor", "Formato", "Año"};

		tblModel.setData(listMultimedias);
		tblModel.setColumnNames(columnNames);

		tblModel.fireTableDataChanged();
		tblModel.fireTableStructureChanged();

		//
		mainPanel.add(cmboBoxOptions);
		mainPanel.add(txtFieldPrompt);
		mainPanel.add(btnFind);
		mainPanel.add(btnRent);

		//
		add(mainPanel);
		add(scrollPane);
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

		public MemberTableModel(ArrayList<Multimedia> listSocio, String[] columnNames)
		{
			this.data = listSocio;
			this.columnNames = columnNames;
		}

		public Multimedia getObjectAt(int x)
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
				return multimedia.getFormat().toString();
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