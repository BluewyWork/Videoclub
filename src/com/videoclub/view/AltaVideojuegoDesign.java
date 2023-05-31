package com.videoclub.view;

import com.videoclub.controller.MultimediaController;
import com.videoclub.model.Constantes;
import com.videoclub.model.Formato;
import com.videoclub.model.Plataforma;
import com.videoclub.util.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase `AltaVideojuegoDesign` es una clase que representa la interfaz gráfica para agregar un videojuego en un
 * videoclub. Extiende la clase `JFrame` para crear una ventana.
 */
public class AltaVideojuegoDesign extends JFrame
{
	private AltaVideojuegoView firstPanel;
	private final MultimediaController multimediaController;
	private JPanel secondPanel;

	/**
	 * Crea una instancia de `AltaVideojuegoDesign`.
	 *
	 * @param multimedia el controlador multimedia
	 */
	public AltaVideojuegoDesign(MultimediaController multimedia)
	{
		multimediaController = multimedia;
		initComponents();
	}

	/**
	 * Inicializa y configura los componentes de la interfaz gráfica.
	 */
	public void initComponents()
	{
		firstPanel = new AltaVideojuegoView(multimediaController);
		firstPanel.setPreferredSize(new Dimension(350, 450));

		secondPanel = new JPanel();
		secondPanel.setPreferredSize(new Dimension(350, 400));
		secondPanel.setBackground(Color.blue);

		setLayout(new FlowLayout());
		add(firstPanel);
		add(secondPanel);
		pack();

		getContentPane().setBackground(Color.blue);
		setBounds(Constantes.POSITION_X_WINDOWS, Constantes.POSITION_Y_WINDOWS,
				Constantes.BOUNDS_WIDTH_WINDOWS, Constantes.BOUNDS_HEIGHT_WINDOWS
		);
		setTitle("Alta videojuego");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * La clase `AltaVideojuegoView` es una clase interna que representa el panel de la interfaz gráfica para agregar un
	 * videojuego. Extiende la clase `JPanel` e implementa la interfaz `ActionListener` para manejar eventos de
	 * botones.
	 */
	class AltaVideojuegoView extends JPanel implements ActionListener
	{
		private final MultimediaController multimediaController;
		private JLabel lblTitulo, lblAutor, lblFormato, lblAnyo, lblPlataforma;
		private JTextField txtTitulo, txtAutor;
		private JButton btnDarAlta;
		private JComboBox<Formato> listFormato;
		private SpinnerNumberModel modelAnyo;
		private JSpinner txtAnyo;
		private JComboBox<Plataforma> listPlataforma;

		/**
		 * Crea una instancia de `AltaVideojuegoView`.
		 *
		 * @param mc el controlador multimedia
		 */
		public AltaVideojuegoView(MultimediaController mc)
		{
			multimediaController = mc;
			initComponents();
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			accionDarAltaVideojuego();
			Logger.log("VideoJuego Creado");
		}

		/**
		 * Inicializa y configura los componentes del panel.
		 */
		public void initComponents()
		{
			setSize(400, 300);

			lblTitulo = new JLabel("- Título -");
			txtTitulo = new JTextField("");

			lblAutor = new JLabel("- Autor -");
			txtAutor = new JTextField("");

			lblFormato = new JLabel("- Formato -");
			Formato[] formatos = Formato.values();
			listFormato = new JComboBox<>(formatos);

			lblAnyo = new JLabel("- Año lanzamiento -");
			modelAnyo = new SpinnerNumberModel(2023, 1950, 2023, 1);
			txtAnyo = new JSpinner(modelAnyo);

			lblPlataforma = new JLabel("- Plataforma -");
			Plataforma[] plataformas = Plataforma.values();
			listPlataforma = new JComboBox<>(plataformas);

			btnDarAlta = new JButton("Dar alta videojuego");

			setLayout(new GridLayout(6, 2));
			add(lblTitulo);
			add(txtTitulo);
			add(lblAutor);
			add(txtAutor);
			add(lblFormato);
			add(listFormato);
			add(lblAnyo);
			add(txtAnyo);
			add(lblPlataforma);
			add(listPlataforma);
			add(new JPanel());
			add(btnDarAlta);

			btnDarAlta.addActionListener(this);
		}

		/**
		 * Realiza la acción de dar de alta un videojuego, obteniendo los valores de los campos de entrada y llamando al
		 * controlador multimedia para agregar el videojuego.
		 */
		public void accionDarAltaVideojuego()
		{
			String titulo = txtTitulo.getText();
			String autor = txtAutor.getText();
			String formato = listFormato.getSelectedItem().toString();
			int anyo = (int) txtAnyo.getValue();
			String plataforma = listPlataforma.getSelectedItem().toString();

			if (titulo.isEmpty() || autor.isEmpty() || formato == null)
			{
				JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos",
						"ERROR", JOptionPane.ERROR_MESSAGE
				);
				return;
			}

			multimediaController.altaVideojuego(titulo, autor, formato, anyo, plataforma);

			JOptionPane.showMessageDialog(null, "Videojuego agregado correctamente");

			txtTitulo.setText("");
			txtAutor.setText("");
			listFormato.setSelectedIndex(0);
			txtAnyo.setValue(2023);
			listPlataforma.setSelectedIndex(0);
		}
	}
}
