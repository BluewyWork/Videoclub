package com.videoclub.view;

import com.videoclub.controller.AlquilerController;
import com.videoclub.controller.MultimediaController;
import com.videoclub.controller.SocioController;
import com.videoclub.model.Socio;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@SuppressWarnings("JoinDeclarationAndAssignmentJava")
public class LookUpDesign extends JFrame implements ActionListener
{
	JTable memberLookUp;
	private SocioController socioController;
	private MultimediaController multimediaController;
	private AlquilerController alquilerController;

	private JPanel jPanel;
	public LookUpDesign(SocioController socioController, MultimediaController multimediaController, AlquilerController alquilerController)
	{
		this.socioController = socioController;
		this.multimediaController = multimediaController;
		this.alquilerController = alquilerController;

		initComponents();
	}

	public static void main(String[] args)
	{
		SocioController sc = new SocioController();
		MultimediaController mc = new MultimediaController();
		AlquilerController ac = new AlquilerController();
		LookUpDesign pd = new LookUpDesign(sc, mc, ac);
		pd.setVisible(true);
		pd.setBounds(100, 100, 900, 900);
	}

	public void initComponents()
	{
		setLayout(new GridLayout());

		jPanel = new JPanel();

		add(jPanel);

		// TESTING AREA!

		socioController.registrarSocio("23y9u4ul20", "Jett", "10/10/2000", "Alicante");

		String[] columnNames = {"Name", "Number", "Email"};
		MemberTableModel tableModel = new MemberTableModel(new ArrayList<>(), columnNames);

		JTable table = new JTable(tableModel);

		JScrollPane scrollPane = new JScrollPane(table);

		add(scrollPane);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent)
	{

	}

	class MemberTableModel extends AbstractTableModel
	{
		private ArrayList<Socio> data;
		private String[] columnNames;

		public MemberTableModel(ArrayList<Socio> listSocio, String[] columnNames)
		{
			this.data = socioController.stuff();
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

				// Format the LocalDate object to a string
				String formattedDate = socio.getFechaNacimiento().format(formatter);

				return formattedDate;
			}

			return null;
		}

		@Override
		public String getColumnName(int column)
		{
			return columnNames[column];
		}
	}
}
