package com.videoclub.view;

import com.videoclub.controller.AlquilerController;
import com.videoclub.controller.MultimediaController;
import com.videoclub.controller.SocioController;
import com.videoclub.model.Multimedia;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PrincipalDesign extends JFrame implements ActionListener
{
	private JMenuBar menuBar;
	private JMenu menuSocio, menuMultimedia, menuListar, menuAlquilar, menuDevolver;
	private JMenuItem altaSocio, altaPelicula, altaVideojuego, alquilar, devolver;
	private JMenuItem listarMultimedia, listarPelicula, listarCancion, listarVideojuego, listarAlquiler, listarSocio;
	AltaSocioDesign altaSocioDesign;
	AltaPeliculaDesign altaPeliculaDesign;
	AltaVideojuegoDesign altaVideojuegoDesign;

	AlquilerDesign alquilerDesign;

	SocioController socioController;
	MultimediaController multimediaController;
	AlquilerController alquilerController;

	public PrincipalDesign(SocioController sc, MultimediaController mc, AlquilerController ac)
	{
		socioController = sc;
		multimediaController = mc;
		alquilerController = ac;

		initComponents();
	}

	public void initComponents()
	{
		altaSocioDesign = new AltaSocioDesign(socioController);
		altaPeliculaDesign = new AltaPeliculaDesign(multimediaController);
		altaVideojuegoDesign = new AltaVideojuegoDesign(multimediaController);

		alquilerDesign = new AlquilerDesign(socioController, multimediaController, alquilerController);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setTitle("JAMA Videoclub");
		initMenuBar();
	}

	public void initMenuBar()
	{
		menuBar = new JMenuBar();
		menuSocio = new JMenu("Socio");
		menuMultimedia = new JMenu("Multimedia");
		menuAlquilar = new JMenu("Alquilar");
		menuDevolver = new JMenu("Devolver");

		alquilar = new JMenuItem("Alquilar multimedia a socio");
		devolver = new JMenuItem("Devolver multimedia de socio");
		altaSocio = new JMenuItem("Alta de socio");
		altaPelicula = new JMenuItem("Alta de pelicula");
		altaVideojuego = new JMenuItem("Alta de videojuego");

		altaSocio.addActionListener(this);
		altaPelicula.addActionListener(this);
		altaVideojuego.addActionListener(this);

		alquilar.addActionListener(this);

		menuSocio.add(altaSocio);

		menuMultimedia.add(altaPelicula);
		menuMultimedia.add(altaVideojuego);

		menuAlquilar.add(alquilar);
		menuDevolver.add(devolver);

		menuListar = new JMenu("Listados");
		listarMultimedia = new JMenuItem("Todos los objetos multimedia");
		listarPelicula = new JMenuItem("Todas las peliculas ordenados por título");
		listarCancion = new JMenuItem("Todas las canciones de un disco por duración");
		listarVideojuego = new JMenuItem("Todos los videojuegos ordenados por año");
		listarAlquiler = new JMenuItem("Los alquileres actuales de un socio");
		listarSocio = new JMenuItem("Los socios con recargos pendientes");

		menuListar.add(listarMultimedia);
		menuListar.add(listarPelicula);
		menuListar.add(listarCancion);
		menuListar.add(listarVideojuego);
		menuListar.add(listarAlquiler);
		menuListar.add(listarSocio);

		menuBar.add(menuSocio);
		menuBar.add(menuMultimedia);
		menuBar.add(menuAlquilar);
		menuBar.add(menuDevolver);
		menuBar.add(menuListar);

		setJMenuBar(menuBar);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource().equals(altaSocio))
		{
			altaSocioDesign.setVisible(true);
		}
		else if (e.getSource().equals(altaPelicula))
		{
			altaPeliculaDesign.setVisible(true);
		}
		else if (e.getSource().equals(altaVideojuego))
		{
			altaVideojuegoDesign.setVisible(true);
		}
		else if (e.getSource().equals(alquilar))
		{
			alquilerDesign.setVisible(true);
		}
	}

	class TableDesignMultimedia extends JFrame
	{
		private JTable tblResults;
		private MemberTableModel tblModel;
		private SocioController socioController;
		private MultimediaController multimediaController;
		private AlquilerController alquilerController;

		public TableDesignMultimedia(SocioController socioController, MultimediaController multimediaController,
		                             AlquilerController alquilerController, ArrayList<Multimedia> listaMultimedia)
		{
			this.socioController = socioController;
			this.multimediaController = multimediaController;
			this.alquilerController = alquilerController;

			initComponents();
			configComponents(listaMultimedia);
		}

		public void initComponents()
		{
			tblModel = new MemberTableModel();
			tblResults = new JTable(tblModel);
		}

		public void configComponents(ArrayList<Multimedia> listaMultimedia)
		{
			//
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);

			//
			String[] columnNames = {"Titulo", "Autor", "Formato", "Año"};

			tblModel.setData(listaMultimedia);
			tblModel.setColumnNames(columnNames);

			tblModel.fireTableDataChanged();
			tblModel.fireTableStructureChanged();
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
}
