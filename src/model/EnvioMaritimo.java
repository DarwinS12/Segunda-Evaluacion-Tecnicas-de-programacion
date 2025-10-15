package model;

public class EnvioMaritimo extends Envio {
    private static final double TARIFA_KM = 800;
    private static final double RECARGO_KG = 1000;

    public EnvioMaritimo(String codigo, String cliente, double peso, double distancia) {
        super(codigo, cliente, peso, distancia);
    }

    @Override
    public double calcularTarifa() {
        return (getDistancia() * TARIFA_KM) + (getPeso() * RECARGO_KG);
    }
}
