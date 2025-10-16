package servicios;

import modelos.Envio;
import modelos.TipoEnvio;

import java.util.List;

public interface IEnvioServicio {
    Envio agregar(String codigo, String cliente, TipoEnvio tipo, double peso, double distancia);
    void quitar(int posicion);
    List<Envio> listar();
    Envio obtener(int posicion);
}

