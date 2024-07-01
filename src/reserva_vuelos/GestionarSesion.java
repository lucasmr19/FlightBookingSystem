package reserva_vuelos;

public class GestionarSesion {
    private boolean sesionIniciada = false; 

    protected GestionarSesion() {
        this.sesionIniciada = false;
    }

    // Getters:
    protected boolean isSesionIniciada() {
        return sesionIniciada;
    }

    protected void iniciarSesion(Cliente cliente, String correo_electronico, String contrasena) throws IllegalStateException {
        if (sesionIniciada) {
            throw new IllegalStateException("Ya tiene una sesión iniciada.");
        } 

        // Verificar si el correo electrónico y la contraseña coinciden con el usuario almacenado
        if (cliente.getCorreoElectronico().equals(correo_electronico) && cliente.getContrasena().equals(contrasena)) {
            sesionIniciada = true;
        } else {
            throw new IllegalStateException("Correo electrónico o contraseña incorrectos.");
        }
    }

    protected void cerrarSesion() {
        if (!sesionIniciada) {
            throw new IllegalStateException("No puede cerrar una sesión ya que no hay ninguna iniciada.");
        } 
        sesionIniciada = false;
    }
}