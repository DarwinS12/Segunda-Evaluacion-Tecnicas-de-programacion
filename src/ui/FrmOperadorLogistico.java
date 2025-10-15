package ui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.TipoEnvio;

public class FrmOperadorLogistico extends JFrame {

    private JTable tblEnvios;
    private JPanel pnlEditar;
    private JTextField txtNumero, txtCliente, txtPeso, txtDistancia;
    private JComboBox<TipoEnvio> cmbTipo;

<<<<<<< HEAD
=======
    /**
     * 
     */
>>>>>>> mauricio
    public FrmOperadorLogistico() {
        setTitle("Operador Logístico");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 650);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);
        JButton btnAgregar = iconButton("/icons/truckPlusIcon.png", "Agregar");
        JButton btnQuitar = iconButton("/icons/truckLessIcon.png", "Quitar");
        toolbar.add(btnAgregar);
        toolbar.add(btnQuitar);

        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //TODO: AGREGAR
            }
        });

        btnQuitar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //TODO: QUITAR
            }
        });

        JPanel pnlMain = new JPanel();
        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));

        pnlEditar = new JPanel(null);
        pnlEditar.setPreferredSize(new Dimension(0, 110));
        pnlEditar.setBorder(BorderFactory.createEmptyBorder(8, 12, 4, 12));

        addLabel(pnlEditar, "Número", 10, 10, 80, 25);
        txtNumero = addText(pnlEditar, 90, 10, 130, 25);

        addLabel(pnlEditar, "Cliente", 10, 45, 80, 25);
        txtCliente = addText(pnlEditar, 90, 45, 230, 25);

        addLabel(pnlEditar, "Peso", 10, 80, 80, 25);
        txtPeso = addText(pnlEditar, 90, 80, 130, 25);

        addLabel(pnlEditar, "Tipo", 400, 10, 80, 25);
        cmbTipo = addCombo(pnlEditar, 440, 10, 150, 25);

        addLabel(pnlEditar, "Distancia (Km)", 340, 45, 100, 25);
        txtDistancia = addText(pnlEditar, 440, 45, 150, 25);

        JButton btnGuardar = addButton(pnlEditar, "Guardar", 345, 80, 120, 26);
        JButton btnCancelar = addButton(pnlEditar, "Cancelar", 470, 80, 120, 26);
<<<<<<< HEAD
=======
        
>>>>>>> mauricio

        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //TODO: GUARDAR
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //TODO: CANCELAR
            }
        });

        cmbTipo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //TODO: CAMBIO DE TIPO
            }
        });

        // Tabla
        String[] cols = {"Tipo", "Código", "Cliente", "Peso", "Distancia", "Costo"};
        DefaultTableModel model = new DefaultTableModel(cols, 0) {
            @Override
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        };

        tblEnvios = new JTable(model);
        tblEnvios.setRowHeight(22);
        tblEnvios.getTableHeader().setReorderingAllowed(false);
        fixColumns(tblEnvios, 120);

        JScrollPane spTabla = new JScrollPane(tblEnvios);

        pnlMain.add(pnlEditar);
        pnlMain.add(spTabla);
        getContentPane().add(toolbar, BorderLayout.NORTH);
        getContentPane().add(pnlMain, BorderLayout.CENTER);
    }

<<<<<<< HEAD
=======
    private JButton addButton(JPanel pnlEditar2, String name, String string, int i, int j, int k, int l) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addButton'");
    }

>>>>>>> mauricio
    private JButton iconButton(String resourcePath, String tooltip) {
        Image img = new ImageIcon(getClass().getResource(resourcePath))
                .getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
        JButton b = new JButton(new ImageIcon(img));
        b.setToolTipText(tooltip);
        b.setFocusable(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return b;
    }

    private void addLabel(JPanel p, String text, int x, int y, int w, int h) {
        JLabel lbl = new JLabel(text);
        lbl.setBounds(x, y, w, h);
        p.add(lbl);
    }

    private JTextField addText(JPanel p, int x, int y, int w, int h) {
        JTextField t = new JTextField();
        t.setBounds(x, y, w, h);
        p.add(t);
        return t;
    }

    private JComboBox<TipoEnvio> addCombo(JPanel p, int x, int y, int w, int h) {
        JComboBox<TipoEnvio> c = new JComboBox<>(TipoEnvio.values());
        c.setBounds(x, y, w, h);
        p.add(c);
        return c;
    }

    private JButton addButton(JPanel p, String text, int x, int y, int w, int h) {
        JButton b = new JButton(text);
        b.setBounds(x, y, w, h);
        p.add(b);
        return b;
    }

    private void fixColumns(JTable table, int prefWidth) {
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            TableColumn col = table.getColumnModel().getColumn(i);
            col.setResizable(false);
            col.setPreferredWidth(prefWidth);
        }
    }
<<<<<<< HEAD
}
=======
        public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrmOperadorLogistico().setVisible(true));
    }
}
>>>>>>> mauricio
private void listarEnvios() {
    DefaultTableModel model = (DefaultTableModel) tblEnvios.getModel();
    model.setRowCount(0);
    
    for (Envio envio : logistica.getEnvios()) {
        String tipo = "";
        if (envio instanceof Terrestre) tipo = "Terrestre";
        else if (envio instanceof Aereo) tipo = "Aéreo";
        else if (envio instanceof Maritimo) tipo = "Marítimo";
        
        model.addRow(new Object[]{
            tipo,
            envio.getCodigo(),
            envio.getCliente(),
            envio.getPeso(),
            envio.getDistancia(),
            envio.calcularTarifa()
        });
    }
}