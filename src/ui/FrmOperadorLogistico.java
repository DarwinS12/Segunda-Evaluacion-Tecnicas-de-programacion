package ui;

import modelos.TipoEnvio;
import servicios.EnvioServicio;
import servicios.UtilServicio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FrmOperadorLogistico extends JFrame {

    private JTable tblEnvios;
    private JTextField txtNumero, txtCliente, txtPeso, txtDistancia;
    private JComboBox<TipoEnvio> cmbTipo;
    private JButton btnAgregar, btnQuitar, btnGuardar, btnCancelar;

    public FrmOperadorLogistico() {
        configurarVentana();
        inicializarComponentes();
        EnvioServicio.mostrar(tblEnvios);
    }

    private void configurarVentana() {
        setTitle("Operador Logístico");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(850, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void inicializarComponentes() {
        add(crearToolbar(), BorderLayout.NORTH);
        add(crearPanelCentral(), BorderLayout.CENTER);
    }

    private JPanel crearToolbar() {
        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);

        int iconSize = 65; 
        btnAgregar = crearBotonConIcono("/img/agregar.png", iconSize);
        btnQuitar = crearBotonConIcono("/img/quitar.png", iconSize);

        toolbar.add(btnAgregar);
        toolbar.add(btnQuitar);

        // Eventos
        btnAgregar.addActionListener(e -> btnGuardar.doClick());
        btnQuitar.addActionListener(e -> quitarEnvio());

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(toolbar, BorderLayout.WEST);
        return panel;
    }

    private JPanel crearPanelCentral() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(crearFormulario(), BorderLayout.NORTH);
        panel.add(crearTabla(), BorderLayout.CENTER);
        return panel;
    }

    private JPanel crearFormulario() {
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 8, 4, 8);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;

        txtNumero = new JTextField(10);
        txtCliente = new JTextField(15);
        txtPeso = new JTextField(10);
        txtDistancia = new JTextField(10);
        cmbTipo = new JComboBox<>(TipoEnvio.values());

        int fila = 0;
        // primera fila
        agregarCampo(formPanel, gbc, fila++, "Número", txtNumero, "Tipo", cmbTipo);
        // segunda fila
        agregarCampo(formPanel, gbc, fila++, "Cliente", txtCliente, "Distancia en Km", txtDistancia);
        // tercera fila
        agregarCampo(formPanel, gbc, fila++, "Peso", txtPeso, " ", crearBotonesFormulario());

        // 🔹 mueve todo el formulario a la izquierda
        JPanel alineado = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        alineado.add(formPanel);
        return alineado;
    }

    private void agregarCampo(JPanel panel, GridBagConstraints gbc, int fila,
                              String label1, Component campo1, String label2, Component campo2) {
        gbc.gridx = 0; gbc.gridy = fila; panel.add(new JLabel(label1), gbc);
        gbc.gridx = 1; panel.add(campo1, gbc);
        gbc.gridx = 2; panel.add(new JLabel(label2), gbc);
        gbc.gridx = 3; panel.add(campo2, gbc);
    }

    private JPanel crearBotonesFormulario() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");
        panel.add(btnGuardar);
        panel.add(btnCancelar);

        btnGuardar.addActionListener(e -> guardarEnvio());
        btnCancelar.addActionListener(e -> limpiarCampos());
        return panel;
    }

    private JScrollPane crearTabla() {
        tblEnvios = new JTable(new DefaultTableModel(EnvioServicio.encabezados, 0));
        tblEnvios.getTableHeader().setReorderingAllowed(false);
        tblEnvios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
        JScrollPane scroll = new JScrollPane(tblEnvios);
        return scroll;
    }

    private void guardarEnvio() {
        try {
            String codigo = txtNumero.getText().trim();
            String cliente = txtCliente.getText().trim();
            double peso = UtilServicio.leerReal(txtPeso.getText().trim());
            double distancia = UtilServicio.leerReal(txtDistancia.getText().trim());
            TipoEnvio tipo = (TipoEnvio) cmbTipo.getSelectedItem();

            if (codigo.isEmpty() || cliente.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos.");
                return;
            }

            EnvioServicio.agregar(codigo, cliente, tipo, peso, distancia);
            EnvioServicio.mostrar(tblEnvios);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void quitarEnvio() {
        int fila = tblEnvios.getSelectedRow();
        if (fila >= 0) {
            EnvioServicio.quitar(fila);
            EnvioServicio.mostrar(tblEnvios);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un envío para eliminar.");
        }
    }

    private void limpiarCampos() {
        txtNumero.setText("");
        txtCliente.setText("");
        txtPeso.setText("");
        txtDistancia.setText("");
        cmbTipo.setSelectedIndex(0);
    }

    private JButton crearBotonConIcono(String ruta, int size) {
        ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
        Image img = icono.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH);
        JButton boton = new JButton(new ImageIcon(img));
        boton.setBorderPainted(false);
        boton.setContentAreaFilled(false);
        return boton;
    }
}
