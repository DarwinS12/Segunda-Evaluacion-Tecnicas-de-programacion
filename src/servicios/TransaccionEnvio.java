package servicios;

import java.time.LocalDateTime;

public class TransaccionEnvio {
    private String codigoEnvio;
    private String tipoOperacion; // "AGREGADO", "ELIMINADO"
    private LocalDateTime fechaHora;
    private double tarifa;

    public TransaccionEnvio(String codigoEnvio, String tipoOperacion, double tarifa) {
        this.codigoEnvio = codigoEnvio;
        this.tipoOperacion = tipoOperacion;
        this.tarifa = tarifa;
        this.fechaHora = LocalDateTime.now();
    }

    public String getCodigoEnvio() {
        return codigoEnvio;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public double getTarifa() {
        return tarifa;
    }

    @Override
    public String toString() {
        return tipoOperacion + " - " + codigoEnvio + " - $" + tarifa + " [" + fechaHora + "]";
    }
}
