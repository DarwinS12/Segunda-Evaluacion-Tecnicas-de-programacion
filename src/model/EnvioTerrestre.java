package model;

public class EnvioTerrestre extends Envio {
    private static final double TARIFA_KM = 1500;
    private static final double RECARGO_KG = 2000;

    public EnvioTerrestre(String codigo, String cliente, double peso, double distancia) {
        super(codigo, cliente, peso, distancia);
    }

    @Override
    public double calcularTarifa() {
        return (getDistancia() * TARIFA_KM) + (getPeso() * RECARGO_KG);
    }
}



