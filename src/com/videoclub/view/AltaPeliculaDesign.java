package com.videoclub.view;

import com.videoclub.controller.MultimediaController;
import com.videoclub.model.Constantes;
import com.videoclub.model.Formato;
import com.videoclub.util.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase `AltaPeliculaDesign` es una clase que representa la interfaz gráfica para agregar una película en un
 * videoclub. Extiende la clase `JFrame` para crear una ventana.
 */
public class AltaPeliculaDesign extends JFrame
{
	private AltaPeliculaView firstPanel;
	private final MultimediaController multimediaController;
	private JPanel secondPanel;

	/**
	 * Crea una instancia de `AltaPeliculaDesign`.
	 *
	 * @param multimedia el controlador multimedia
	 */
	public AltaPeliculaDesign(MultimediaController multimedia)
	{
		multimediaController = multimedia;
		initComponents();
	}

	/**
	 * Inicializa y configura los componentes de la interfaz gráfica.
	 */
	public void initComponents()
	{
		firstPanel = new AltaPeliculaView(multimediaController);
		firstPanel.setPreferredSize(new Dimension(350, 450));

		secondPanel = new JPanel();
		secondPanel.setPreferredSize(new Dimension(350, 400));
		secondPanel.setBackground(Color.black);

		setLayout(new FlowLayout());
		add(firstPanel);
		add(secondPanel);
		pack();

		getContentPane().setBackground(Color.black);
		setBounds(Constantes.POSITION_X_WINDOWS, Constantes.POSITION_Y_WINDOWS,
				Constantes.BOUNDS_WIDTH_WINDOWS, Constantes.BOUNDS_HEIGHT_WINDOWS
		);
		setTitle("Alta película");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * La clase `AltaPeliculaView` es una clase interna que representa el panel de la interfaz gráfica para agregar una
	 * película. Extiende la clase `JPanel` e implementa la interfaz `ActionListener` para manejar eventos de botones.
	 */
	class AltaPeliculaView extends JPanel implements ActionListener
	{
		private JLabel lblTitulo, lblAutor, lblFormato, lblAnyo, lblDuracion, lblActor, lblActriz;
		private JTextField txtTitulo, txtAutor, txtActor, txtActriz;
		private JSpinner txtAnyo, txtDuracion;
		private JButton btnDarAlta;
		private JComboBox<Formato> listFormato;
		private SpinnerNumberModel modelAnyo, modelDuracion;
		private final MultimediaController multimediaController;

		/**
		 * Crea una instancia de `AltaPeliculaView`.
		 *
		 * @param multimedia el controlador multimedia
		 */
		public AltaPeliculaView(MultimediaController multimedia)
		{
			multimediaController = multimedia;
			initComponents();
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			accionDarAltaPelicula();
			Logger.log("Pelicula Creada");
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

			lblDuracion = new JLabel("Duración:");
			modelDuracion = new SpinnerNumberModel(0, 0, 3000, 1);
			txtDuracion = new JSpinner(modelDuracion);

			lblActor = new JLabel("Actor:");
			txtActor = new JTextField(20);

			lblActriz = new JLabel("Actriz:");
			txtActriz = new JTextField(20);

			btnDarAlta = new JButton("Dar alta película");

			setLayout(new GridLayout(8, 2));
			add(lblTitulo);
			add(txtTitulo);
			add(lblAutor);
			add(txtAutor);
			add(lblFormato);
			add(listFormato);
			add(lblAnyo);
			add(txtAnyo);
			add(lblDuracion);
			add(txtDuracion);
			add(lblActor);
			add(txtActor);
			add(lblActriz);
			add(txtActriz);
			add(new JPanel());
			add(btnDarAlta);

			btnDarAlta.addActionListener(this);
		}

		/**
		 * Realiza la acción de dar de alta una película, obteniendo los valores de los campos de entrada y llamando al
		 * controlador multimedia para agregar la película.
		 */
		public void accionDarAltaPelicula()
		{
			String titulo = txtTitulo.getText();
			String autor = txtAutor.getText();
			String formato = listFormato.getSelectedItem().toString();
			int anyo = (int) txtAnyo.getValue();
			int duracion = (int) txtDuracion.getValue();
			String actor = txtActor.getText();
			String actriz = txtActriz.getText();

			if (titulo.isEmpty() || autor.isEmpty() || actor.isEmpty() || actriz.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos",
						"ERROR", JOptionPane.ERROR_MESSAGE
				);
				return;
			}

			multimediaController.altaPelicula(titulo, autor, formato, anyo, duracion, actor, actriz);

			JOptionPane.showMessageDialog(null, "Película agregada correctamente");

			txtTitulo.setText("");
			txtAutor.setText("");
			txtActor.setText("");
			txtActriz.setText("");
			listFormato.setSelectedIndex(0);
			txtAnyo.setValue(2023);
			txtDuracion.setValue(0);
		}
	}
}
