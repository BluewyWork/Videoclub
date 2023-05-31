package com.videoclub.view;

import com.videoclub.controller.MultimediaController;
import com.videoclub.model.Cancion;
import com.videoclub.model.Constantes;
import com.videoclub.model.Formato;
import com.videoclub.util.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * La clase `AltaDiscoDesign` es una clase que representa la interfaz gráfica para agregar un disco en un videoclub.
 * Extiende la clase `JFrame` para crear una ventana.
 */
public class AltaDiscoDesign extends JFrame
{
	private AltaDiscoView firstPanel;
	private final MultimediaController multimediaController;
	private JPanel secondPanel;

	/**
	 * Crea una instancia de `AltaDiscoDesign`.
	 *
	 * @param multimedia el controlador multimedia
	 */
	public AltaDiscoDesign(MultimediaController multimedia)
	{
		multimediaController = multimedia;
		initComponents();
	}

	/**
	 * Inicializa y configura los componentes de la interfaz gráfica.
	 */
	public void initComponents()
	{
		firstPanel = new AltaDiscoView(multimediaController);
		firstPanel.setPreferredSize(new Dimension(350, 450));

		secondPanel = new JPanel();
		secondPanel.setPreferredSize(new Dimension(350, 400));
		secondPanel.setBackground(Color.yellow);

		setLayout(new FlowLayout());
		add(firstPanel);
		add(secondPanel);
		pack();

		getContentPane().setBackground(Color.yellow);
		setBounds(Constantes.POSITION_X_WINDOWS, Constantes.POSITION_Y_WINDOWS,
				Constantes.BOUNDS_WIDTH_WINDOWS, Constantes.BOUNDS_HEIGHT_WINDOWS
		);
		setTitle("Alta disco");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * La clase `AltaDiscoView` es una clase interna que representa el panel de la interfaz gráfica para agregar un
	 * disco. Extiende la clase `JPanel` e implementa la interfaz `ActionListener` para manejar eventos de botones.
	 */
	class AltaDiscoView extends JPanel implements ActionListener
	{
		private JLabel lblTitulo, lblAutor, lblFormato, lblAnyo, lblDuracion;
		private JTextField txtTitulo, txtAutor, txtDuracion;
		private JSpinner txtAnyo;
		private JButton btnDarAlta;
		private JComboBox<Formato> listFormato;

		private SpinnerNumberModel modelAnyo;
		private final MultimediaController multimediaController;

		/**
		 * Crea una instancia de `AltaDiscoView`.
		 *
		 * @param multimedia el controlador multimedia
		 */
		public AltaDiscoView(MultimediaController multimedia)
		{
			multimediaController = multimedia;
			initComponents();
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			accionDarAltaDisco();
			Logger.log("Disco Creada");
		}

		/**
		 * Inicializa y configura los componentes del panel.
		 */
		public void initComponents()
		{
			setSize(400, 300);

			lblTitulo = new JLabel("Título:");
			txtTitulo = new JTextField(20);

			lblAutor = new JLabel("Autor:");
			txtAutor = new JTextField(30);

			lblFormato = new JLabel("Formato:");
			Formato[] formatos = Formato.values();
			listFormato = new JComboBox<>(formatos);

			lblAnyo = new JLabel("Año lanzamiento:");
			modelAnyo = new SpinnerNumberModel(2023, 1890, 2023, 1);
			txtAnyo = new JSpinner(modelAnyo);
			btnDarAlta = new JButton("Dar alta disco");

			setLayout(new GridLayout(5, 2));
			add(lblTitulo);
			add(txtTitulo);
			add(lblAutor);
			add(txtAutor);
			add(lblFormato);
			add(listFormato);
			add(lblAnyo);
			add(txtAnyo);
			add(new JPanel()); // Espacio en blanco
			add(btnDarAlta);

			btnDarAlta.addActionListener(this);
		}

		/**
		 * Realiza la acción de dar de alta un disco, obteniendo los valores de los campos de entrada y llamando al
		 * controlador multimedia para agregar el disco.
		 */
		public void accionDarAltaDisco()
		{
			String titulo = txtTitulo.getText();
			String autor = txtAutor.getText();
			String formato = listFormato.getSelectedItem().toString();
			int anyo = (int) txtAnyo.getValue();
			ArrayList<Cancion> listCancion = new ArrayList<>();

			if (titulo.isEmpty() || autor.isEmpty() || formato.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos,",
						"ERROR", JOptionPane.ERROR_MESSAGE
				);
				return;
			}

			multimediaController.altaDisco(titulo, autor, formato, anyo, listCancion);

			JOptionPane.showMessageDialog(null, "Disco agregado correctamente");

			txtTitulo.setText("");
			txtAutor.setText("");
			listFormato.setSelectedIndex(0);
			txtAnyo.setValue(2023);
		}
	}
}
