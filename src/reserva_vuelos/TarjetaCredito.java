package reserva_vuelos;

import java.util.regex.Pattern;

public class TarjetaCredito extends MetodoPago {
    private final String numeroTarjeta;
    private final int cvv;
    private final String fechaExpiracion;

    // Constructor
    public TarjetaCredito(String numeroTarjeta, int cvv, String fechaExpiracion, double saldoDisponible) throws IllegalArgumentException {
        // Quitar guiones y espacios en blanco del número de tarjeta si los hubiese
        String numeroTarjetaFormateado = numeroTarjeta.replaceAll("[\\s-]+", "");

        // Validar el número de tarjeta (debe ser un número de 16 dígitos)
        if (!Pattern.matches("\\d{16}", numeroTarjetaFormateado)) {
            throw new IllegalArgumentException("El número de tarjeta debe tener 16 dígitos.");
        }
        this.numeroTarjeta = numeroTarjetaFormateado;

        // Validar el CVV (debe ser un número de 3 dígitos)
        if (!Pattern.matches("\\d{3}", String.valueOf(cvv))) {
            throw new IllegalArgumentException("El CVV debe tener 3 dígitos.");
        }
        this.cvv = cvv;

        // Validar el formato de la fecha de expiración (debe seguir el formato MM/YY)
        if (!Pattern.matches("\\d{2}/\\d{2}", fechaExpiracion)) {
            throw new IllegalArgumentException("El formato de la fecha de expiración debe ser MM/YY.");
        }

        // Extraer el mes y el año de la fecha de expiración
        String[] partesFecha = fechaExpiracion.split("/");
        int mes = Integer.parseInt(partesFecha[0]);
        int ano = Integer.parseInt(partesFecha[1]);

        // Validar que el mes sea válido (01-12)
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("El mes de expiración debe estar entre 01 y 12!");
        }

        // Validar que el año sea válido (mayor o igual a 24)
        if (ano < 24){
            throw new IllegalArgumentException("La tarjeta está caducada!");
        }

        this.fechaExpiracion = fechaExpiracion;
        this.saldoDisponible = saldoDisponible;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }
    
    public int getCVV() {
        return cvv;
    }
    
    public String getFechaExpiracion() {
        return fechaExpiracion;
    }
    
    @Override
    public String toString() {
        return "Tarjeta de crédito(" +
                "Número = " + numeroTarjeta +
                //", CVV = " + cvv +
                ", Fecha de expiración = " + fechaExpiracion +
                ", Saldo disponible=" + saldoDisponible +
                ")";
    }
}
