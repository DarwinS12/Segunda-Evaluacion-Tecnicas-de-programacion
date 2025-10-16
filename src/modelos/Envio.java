package modelos;

public abstract class Envio {
    private String codigo;
    private String cliente;
    private double peso;
    private double distancia;

    public Envio(String codigo, String cliente, double peso, double distancia) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.peso = peso;
        this.distancia = distancia;
    }

    public String getCodigo() { return codigo; }
    public String getCliente() { return cliente; }
    public double getPeso() { return peso; }
    public double getDistancia() { return distancia; }

    public abstract double calcularTarifa();

    public String[] mostrarDatos() {
        return new String[] {
            this.getClass().getSimpleName(),
            codigo,
            cliente,
            String.format("%.2f", peso),
            String.format("%.2f", distancia),
            String.format("$%,.2f", calcularTarifa())
        };
    }
}
