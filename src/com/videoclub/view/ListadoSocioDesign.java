package com.videoclub.view;

import com.videoclub.controller.AlquilerController;
import com.videoclub.controller.MultimediaController;
import com.videoclub.controller.SocioController;
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
public class ListadoSocioDesign extends JFrame implements ActionListener
{
	private final SocioController socioController;
	private final MultimediaController multimediaController;
	private final AlquilerController alquilerController;
	private GridLayout grdLayout;
	private JComboBox<String> cmboBoxOptions;
	private JButton btnFind;
	private JButton btnDelete;
	private JTable tblResults;
	private JTextField txtFieldPrompt;
	private MemberTableModel tblModel;
	private JPanel mainPanel;
	private JScrollPane scrollPane;

	/**
	 * Crea una instancia de ListadoSocioDesign.
	 *
	 * @param socioController      El controlador de socios.
	 * @param multimediaController El controlador de multimedia.
	 * @param alquilerController   El controlador de alquileres.
	 */
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
		else if (actionEvent.getSource().equals(btnDelete))
		{
			eliminarSocio();
		}
	}

	/**
	 * Inicializa los componentes de la interfaz.
	 */
	public void initComponents()
	{
		grdLayout = new GridLayout();
		mainPanel = new JPanel();
		cmboBoxOptions = new JComboBox<>();
		btnFind = new JButton();
		btnDelete = new JButton();
		txtFieldPrompt = new JTextField();
		tblModel = new MemberTableModel();
		tblResults = new JTable(tblModel);
		scrollPane = new JScrollPane(tblResults);
	}

	/**
	 * Configura los componentes de la interfaz.
	 */
	public void configComponents()
	{
		setLayout(grdLayout);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(Constantes.POSITION_X_WINDOWS, Constantes.POSITION_Y_WINDOWS, Constantes.BOUNDS_WIDTH_WINDOWS, Constantes.BOUNDS_HEIGHT_WINDOWS);
		setTitle("Listado socios");

		txtFieldPrompt.setPreferredSize(new Dimension(200, 30));

		cmboBoxOptions.addItem("Sin filtro");
		cmboBoxOptions.addItem("Buscar por NIF");
		cmboBoxOptions.addItem("Buscar por nombre");

		btnFind.setText("Buscar");
		btnFind.addActionListener(this);

		btnDelete.setText("Eliminar");
		btnDelete.addActionListener(this);

		ArrayList<Socio> listSocio = socioController.todosLosSocios();
		String[] columnNames = {"NIF", "Nombre", "Fecha Nacimiento", "Población"};

		tblModel.setData(listSocio);
		tblModel.setColumnNames(columnNames);

		tblModel.fireTableDataChanged();
		tblModel.fireTableStructureChanged();

		mainPanel.add(cmboBoxOptions);
		mainPanel.add(txtFieldPrompt);
		mainPanel.add(btnFind);
		mainPanel.add(btnDelete);

		add(mainPanel);
		add(scrollPane);
	}

	/**
	 * Actualiza la tabla de resultados según el filtro seleccionado.
	 */
	public void updateTable()
	{
		String userInputText = txtFieldPrompt.getText();

		if (cmboBoxOptions.getSelectedItem().equals("Buscar por NIF"))
		{
			if (userInputText.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Por favor, introduzca el NIF que quiere buscar",
						"ERROR", JOptionPane.ERROR_MESSAGE
				);
				return;
			}
			else
			{
				tblModel.setData(socioController.filtroPorNIF(userInputText));
			}
		}
		else if (cmboBoxOptions.getSelectedItem().equals("Buscar por nombre"))
		{
			if (userInputText.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Por favor, introduzca el nombre que quiere buscar",
						"ERROR", JOptionPane.ERROR_MESSAGE
				);
				return;
			}
			else
			{
				tblModel.setData(socioController.filtroPorNombre(userInputText));
			}
		}
		else if (cmboBoxOptions.getSelectedItem().equals("Sin filtro"))
		{
			tblModel.setData(socioController.todosLosSocios());
		}

		tblModel.fireTableDataChanged();
	}

	/**
	 * Elimina el socio seleccionado de la tabla y actualiza los datos.
	 */
	public void eliminarSocio()
	{
		int columnaNif = 0;
		try
		{
			int filaSeleccionada = tblResults.getSelectedRow();

			String nif = tblResults.getValueAt(filaSeleccionada, columnaNif).toString();

			socioController.darBajaSocio(nif);

			tblModel.setData(socioController.todosLosSocios());
			tblModel.fireTableDataChanged();

			JOptionPane.showMessageDialog(null, "Socio eliminado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "Seleccione un socio para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Clase interna que define el modelo de tabla para los socios.
	 */
	class MemberTableModel extends AbstractTableModel
	{
		private ArrayList<Socio> data;
		private String[] columnNames;

		public MemberTableModel()
		{
			data = new ArrayList<>();
			columnNames = new String[]{"Columna1", "Columna2", "Columna3", "Columna4"};
		}

		/**
		 * Crea una instancia de MemberTableModel con datos y nombres de columna especificados.
		 *
		 * @param listSocio   Los datos de los socios.
		 * @param columnNames Los nombres de las columnas.
		 */
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