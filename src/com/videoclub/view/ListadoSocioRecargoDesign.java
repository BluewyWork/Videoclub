package com.videoclub.view;

import com.videoclub.controller.AlquilerController;
import com.videoclub.controller.MultimediaController;
import com.videoclub.controller.SocioController;
import com.videoclub.model.Alquiler;
import com.videoclub.model.Constantes;
import com.videoclub.model.Socio;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@SuppressWarnings("JoinDeclarationAndAssignmentJava")
public class ListadoSocioRecargoDesign extends JFrame implements ActionListener
{
	private final SocioController socioController;
	private final MultimediaController multimediaController;
	private final AlquilerController alquilerController;
	private GridLayout grdLayout;
	private JComboBox<String> cmboBoxOptions;
	private JButton btnFind;
	private JTable tblResults;
	private JTextField txtFieldPrompt;
	private MemberTableModel tblModel;
	private JPanel mainPanel;
	private JScrollPane scrollPane;

	/**
	 * Constructor de la clase ListadoSocioRecargoDesign.
	 *
	 * @param socioController      controlador de socios
	 * @param multimediaController controlador de multimedia
	 * @param alquilerController   controlador de alquileres
	 */
	public ListadoSocioRecargoDesign(SocioController socioController, MultimediaController multimediaController, AlquilerController alquilerController)
	{
		this.socioController = socioController;
		this.multimediaController = multimediaController;
		this.alquilerController = alquilerController;

		initComponents();
		configComponents();
	}

	/**
	 * Maneja los eventos de acción, como hacer clic en el botón de búsqueda.
	 *
	 * @param actionEvent el evento de acción
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent)
	{
		if (actionEvent.getSource().equals(btnFind))
		{
			updateTable();
		}
	}

	/**
	 * Inicializa los componentes de la interfaz de usuario.
	 */
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

	/**
	 * Configura los componentes de la interfaz de usuario y establece el diseño.
	 */
	public void configComponents()
	{
		//
		setLayout(grdLayout);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(Constantes.POSITION_X_WINDOWS, Constantes.POSITION_Y_WINDOWS, Constantes.BOUNDS_WIDTH_WINDOWS, Constantes.BOUNDS_HEIGHT_WINDOWS);
		setTitle("Listado socios con recargo");

		//
		txtFieldPrompt.setPreferredSize(new Dimension(200, 30));

		//
		cmboBoxOptions.addItem("Sin filtro");
		cmboBoxOptions.addItem("Buscar por NIF");
		cmboBoxOptions.addItem("Buscar por nombre");

		//
		btnFind.setText("Buscar");
		btnFind.addActionListener(this);

		//
		ArrayList<Socio> listSocio = listSocioRecargo();
		String[] columnNames = {"NIF", "Nombre", "Fecha Nacimiento", "Poblacion"};

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

	/**
	 * Actualiza la tabla de resultados según la opción de búsqueda seleccionada y el texto ingresado.
	 */
	public void updateTable()
	{
		String userInputText = txtFieldPrompt.getText();

		if (cmboBoxOptions.getSelectedItem().equals("Buscar por NIF"))
		{
			tblModel.setData(socioController.filtroPorNIF(userInputText));
		}
		else if (cmboBoxOptions.getSelectedItem().equals("Buscar por nombre"))
		{
			tblModel.setData(socioController.filtroPorNombre(userInputText));
		}
		else if (cmboBoxOptions.getSelectedItem().equals("Sin filtro"))
		{
			tblModel.setData(listSocioRecargo());
		}

		tblModel.fireTableDataChanged();
	}

	/**
	 * Obtiene la lista de socios con recargo.
	 *
	 * @return lista de socios con recargo
	 */
	public ArrayList<Socio> listSocioRecargo()
	{
		ArrayList<Socio> listSocioRecargo = new ArrayList<>();
		ArrayList<Alquiler> listAlquilerAux = alquilerController.listarSocioRecargo();
		for (Alquiler alquiler : listAlquilerAux)
		{
			listSocioRecargo.add(socioController.encontrarSocio(alquiler.getNif()));
		}

		return listSocioRecargo;
	}

	/**
	 * Modelo de tabla personalizado para mostrar los datos de los socios.
	 */
	class MemberTableModel extends AbstractTableModel
	{
		private ArrayList<Socio> data;
		private String[] columnNames;

		public MemberTableModel()
		{
			data = new ArrayList<>();
			columnNames = new String[]{"NIF", "Nombre", "Fecha Nacimiento", "Poblacion"};
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
