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
import java.util.ArrayList;

@SuppressWarnings("JoinDeclarationAndAssignmentJava")
public class ListadoAlquilerSocioDesign extends JFrame implements ActionListener
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

	private JLabel lblNSocio;
	private JLabel lblNombreSocio;
	private JLabel lblDniSocio;
	private JTextField txtFieldNSocio;
	private JTextField txtFieldNombreSocio;
	private JTextField txtFieldDniSocio;

	/**
	 * Constructor de la clase ListadoAlquilerSocioDesign.
	 *
	 * @param socioController      controlador de socio
	 * @param multimediaController controlador de multimedia
	 * @param alquilerController   controlador de alquiler
	 */
	public ListadoAlquilerSocioDesign(SocioController socioController, MultimediaController multimediaController, AlquilerController alquilerController)
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
				JOptionPane.showMessageDialog(null, "Socio encontrado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
				txtFieldNombreSocio.setText(socio.getNombre());
				txtFieldDniSocio.setText(socio.getNif());
				tblModel.setData(alquilerController.listarAlquileresSocio(nif));
				tblModel.fireTableDataChanged();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "NIF no válido", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Inicializa los componentes de la interfaz gráfica.
	 */
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
		txtFieldNSocio = new JTextField();
		txtFieldNombreSocio = new JTextField();
		txtFieldDniSocio = new JTextField();
		tblResults = new JTable(tblModel);
		scrollPane = new JScrollPane(tblResults);
	}

	/**
	 * Configura los componentes de la interfaz gráfica.
	 */
	public void configComponents()
	{
		setLayout(grdLayout);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(Constantes.POSITION_X_WINDOWS, Constantes.POSITION_Y_WINDOWS, Constantes.BOUNDS_WIDTH_WINDOWS, Constantes.BOUNDS_HEIGHT_WINDOWS);
		setTitle("Listado alquileres de un socio");

		txtFieldPrompt.setPreferredSize(new Dimension(200, 30));

		cmboBoxOptions.addItem("Buscar por NIF");
		cmboBoxOptions.addItem("Buscar por Nombre");

		lblNombreSocio.setText("Socio: ");

		lblNSocio.setText("DNI: ");

		btnFind.setText("Buscar");
		btnFind.addActionListener(this);

		ArrayList<Alquiler> listarAlquileresSocio = alquilerController.listarAlquileresSocio(txtFieldPrompt.getText());
		String[] columnNames = {"Título", "Autor", "Formato", "Año"};

		tblModel.setData(listarAlquileresSocio);
		tblModel.setColumnNames(columnNames);

		tblModel.fireTableDataChanged();
		tblModel.fireTableStructureChanged();

		mainPanel.add(cmboBoxOptions);
		mainPanel.add(txtFieldPrompt);
		mainPanel.add(btnFind);

		add(mainPanel);
		add(scrollPane);
	}

	/**
	 * Clase interna que implementa el modelo de tabla para los alquileres de los socios.
	 */
	class MemberTableModel extends AbstractTableModel
	{
		private ArrayList<Alquiler> data;
		private String[] columnNames;

		/**
		 * Constructor de la clase MemberTableModel.
		 */
		public MemberTableModel()
		{
			data = new ArrayList<>();
			columnNames = new String[]{"Columna1", "Columna2", "Columna3", "Columna4"};
		}

		/**
		 * Constructor de la clase MemberTableModel.
		 *
		 * @param listAlquileresSocio lista de alquileres de un socio
		 * @param columnNames         nombres de las columnas
		 */
		public MemberTableModel(ArrayList<Alquiler> listAlquileresSocio, String[] columnNames)
		{
			this.data = listAlquileresSocio;
			this.columnNames = columnNames;
		}

		/**
		 * Obtiene el objeto Alquiler en una posición específica de la tabla.
		 *
		 * @param x posición del objeto en la tabla
		 * @return el objeto Alquiler en la posición dada
		 */
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
				return alquiler.getMultimedia().getTitulo();
			}
			else if (column == 1)
			{
				return alquiler.getMultimedia().getAutor();
			}
			else if (column == 2)
			{
				return alquiler.getMultimedia().getFormat().toString();
			}
			else if (column == 3)
			{
				return alquiler.getMultimedia().getAnio();
			}

			return null;
		}

		@Override
		public String getColumnName(int column)
		{
			return columnNames[column];
		}

		/**
		 * Establece los datos de la tabla.
		 *
		 * @param data los nuevos datos de la tabla
		 */
		public void setData(ArrayList<Alquiler> data)
		{
			this.data = data;
		}

		/**
		 * Establece los nombres de las columnas de la tabla.
		 *
		 * @param columnNames los nuevos nombres de las columnas
		 */
		public void setColumnNames(String[] columnNames)
		{
			this.columnNames = columnNames;
		}
	}
}
