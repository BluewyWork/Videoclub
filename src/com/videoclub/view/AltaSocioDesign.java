package com.videoclub.view;

import com.videoclub.controller.SocioController;
import com.videoclub.model.Constantes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltaSocioDesign extends JFrame implements ActionListener
{
    private SocioController socioController;
    private JPanel firstPanel;
    AltaSocioView secondPanel;

    public AltaSocioDesign(SocioController socio)
    {
        socioController = socio;
        initComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }

    public void initComponents()
    {
        firstPanel = new JPanel();
        firstPanel.setPreferredSize(new Dimension(350, 400));
        firstPanel.setBackground(Color.pink);

        secondPanel = new AltaSocioView(socioController);
        secondPanel.setPreferredSize(new Dimension(350, 450));

        setLayout(new FlowLayout());
        add(firstPanel);
        add(secondPanel);
        pack();

        getContentPane().setBackground(Color.pink);
        setBounds(Constantes.POSITION_X_WINDOWS, Constantes.POSITION_Y_WINDOWS, Constantes.BOUNDS_WIDTH_WINDOWS, Constantes.BOUNDS_HEIGHT_WINDOWS);
        setTitle("Alta Socio");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public class AltaSocioView extends JPanel implements ActionListener
    {
        private JTextField txtNombre;
        private JTextField txtNIF;
        private JTextField txtFechaNacimiento;
        private JTextField txtPoblacion;
        private SocioController socioController;

        public AltaSocioView(SocioController socio)
        {
            socioController = socio;
            initComponents();
        }

        public void actionPerformed(ActionEvent e)
        {
            accionDarAltaSocio();
        }

        public void initComponents()
        {
            // Configuración de la ventana
            setSize(300, 200);

            // Creación de los componentes visuales
            JLabel lblNombre = new JLabel("Nombre:");
            txtNombre = new JTextField(20);

            JLabel lblNIF = new JLabel("NIF:");
            txtNIF = new JTextField(10);

            JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento:");
            txtFechaNacimiento = new JTextField(10);

            JLabel lblPoblacion = new JLabel("Poblacion:");
            txtPoblacion = new JTextField(20);

            JButton btnGuardar = new JButton("Guardar");

            // Configuración del diseño de la ventana
            setLayout(new GridLayout(5, 2));
            add(lblNombre);
            add(txtNombre);
            add(lblNIF);
            add(txtNIF);
            add(lblFechaNacimiento);
            add(txtFechaNacimiento);
            add(lblPoblacion);
            add(txtPoblacion);
            add(new JPanel()); // Espacio en blanco
            add(btnGuardar);

            // Asignar el ActionListener al botón de guardar
            btnGuardar.addActionListener(this);
        }

        public void accionDarAltaSocio()
        {
            // Obtener los datos ingresados por el usuario
            String nif = txtNIF.getText();
            String nombre = txtNombre.getText();
            String fechaNacimientoText = txtFechaNacimiento.getText();
            String poblacion = txtPoblacion.getText();

            // Validar que los campos no estén vacíos
            if (nif.isEmpty() || nombre.isEmpty() || fechaNacimientoText.isEmpty() || poblacion.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Llamar al método para agregar el socio en GestorSocioController
            socioController.registrarSocio(nif, nombre, fechaNacimientoText, poblacion);

            // Mostrar un mensaje de éxito
            JOptionPane.showMessageDialog(null, "Socio agregado correctamente");

            // Limpiar los campos de texto
            txtNIF.setText("");
            txtNombre.setText("");
            txtFechaNacimiento.setText("");
            txtPoblacion.setText("");
        }
    }
}
