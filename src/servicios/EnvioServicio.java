package servicios;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.*;

public class EnvioServicio {

    public static String[] encabezados = {
        "Tipo", "Código", "Cliente", "Peso (kg)", "Distancia (km)", "Tarifa (COP)"
    };

    private static List<Envio> listaEnvios = new ArrayList<>();

    public static Envio agregar(String codigo, String cliente, TipoEnvio tipo,
                                double peso, double distancia) {
        Envio envio = null;
        switch (tipo) {
            case TERRESTRE:
                envio = new Terrestre(codigo, cliente, peso, distancia);
                break;
            case AEREO:
                envio = new Aereo(codigo, cliente, peso, distancia);
                break;
            case MARITIMO:
                envio = new Maritimo(codigo, cliente, peso, distancia);
                break;
        }
        listaEnvios.add(envio);
        return envio;
    }

    public static void quitar(int posicion) {
        if (posicion >= 0 && posicion < listaEnvios.size()) {
            listaEnvios.remove(posicion);
        }
    }

    public static void mostrar(JTable tabla) {
        String[][] datos = new String[listaEnvios.size()][encabezados.length];
        for (int i = 0; i < listaEnvios.size(); i++) {
            datos[i] = listaEnvios.get(i).mostrarDatos();
        }
        DefaultTableModel modelo = new DefaultTableModel(datos, encabezados);
        tabla.setModel(modelo);
    }

    public static Envio getEnvio(int idx) {
        return listaEnvios.get(idx);
    }
}
