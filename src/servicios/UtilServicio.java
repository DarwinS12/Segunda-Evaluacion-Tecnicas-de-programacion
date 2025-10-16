package servicios;

public class UtilServicio {

    public static double leerReal(String texto) {
        if (texto == null || texto.isBlank()) {
            return 0;
        }
        try {
            return Double.parseDouble(texto);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Valor numérico real no válido: " + texto);
        }
    }

    public static int leerEntero(String texto) {
        if (texto == null || texto.isBlank()) {
            return 0;
        }
        try {
            return Integer.parseInt(texto);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Valor numérico entero no válido: " + texto);
        }
    }
}