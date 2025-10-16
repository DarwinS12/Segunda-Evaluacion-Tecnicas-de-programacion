import ui.FrmOperadorLogistico;
import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrmOperadorLogistico().setVisible(true));
    }
}