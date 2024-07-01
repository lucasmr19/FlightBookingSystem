package reserva_vuelos;

public class Paypal extends MetodoPago {
    private final String correo_paypal;
    private final String contrasena_paypal;

    // Constructor
    public Paypal(String correo_paypal, String contrasena_paypal) throws IllegalArgumentException {
        
        // Checkear que el correo electronico es una direccion válida
        Validar.validarCorreo(correo_paypal);

        // Validar la contraseña
        Validar.validarContrasena(contrasena_paypal);

        this.correo_paypal = correo_paypal;
        this.contrasena_paypal = contrasena_paypal;
    }

    // Getters
    public String getCorreoPaypal() {
        return correo_paypal;
    }

    public String getContrasenaPaypal() {
        return contrasena_paypal;
    }

    // Método toString para imprimir la información
    @Override
    public String toString() {
        return "Paypal(" +
                "correo_paypal = " + correo_paypal +
                // ", contrasena_paypal = " + contrasena_paypal +
                ", Saldo disponible=" + saldoDisponible +
                ")";
    }
}