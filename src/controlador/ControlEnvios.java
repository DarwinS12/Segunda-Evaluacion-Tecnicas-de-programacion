package controlador;

import java.util.ArrayList;
import model.Envio;

public class ControlEnvios {

    private ArrayList<Envio> listaEnvios = new ArrayList<>();

    public void agregarEnvio(Envio envio) {
        listaEnvios.add(envio);
    }

    public void eliminarEnvio(String codigo) {
        listaEnvios.removeIf(e -> e.getCodigo().equals(codigo));
    }

    public ArrayList<Envio> getEnvios() {
        return listaEnvios;
    }

    public Envio buscarEnvio(String codigo) {
        for (Envio e : listaEnvios) {
            if (e.getCodigo().equals(codigo)) {
                return e;
            }
        }
        return null;
    }
}

