package reserva_vuelos;

// Representa un Cliente GENERAL del sistema.
public class Cliente {
    protected String correo_electronico;
    protected String contrasena;
    protected GestionarSesion gestionarSesion = new GestionarSesion();

    // Se define el constructor como protected, la idea es que solo se pueda crear un objeto Cliente mediante la clase Registro.
    // Una vez creado, para poder realizar/modificar/cancelar una reserva, deberá de estar con la Sesión Iniciada y como Pasajero.

    // Constructor para una persona mayor de edad
    protected Cliente(String correo_electronico, String contrasena) {
        this.correo_electronico = correo_electronico;
        this.contrasena = contrasena;
    }

    // Constructor para una persona menor (para utilizar en la clas hija Pasajero sin necesidad de correo y contrasena)
    protected Cliente() {
        this.correo_electronico = "No establecido";
        this.contrasena = "No establecida";
    }


    // Getters para acceder a los atributos

    public String getCorreoElectronico() {
        return this.correo_electronico;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    protected GestionarSesion getGestionarSesion() {
        return this.gestionarSesion;
    }

    // Método para actualizar la contraseña
    public void actualizarContrasena(String contrasena, String nuevaContrasena) throws IllegalArgumentException {
        if (!contrasena.equals(this.contrasena)) {
            throw new IllegalArgumentException("Para cambiar su contraseña, debe introducir correctamente la contraseña actual para verificar su identidad.");
        }
        Validar.validarContrasena(nuevaContrasena);
        this.contrasena = nuevaContrasena;
    }

    public void iniciarSesion(String correo_electronico, String contrasena) throws IllegalStateException {
        gestionarSesion.iniciarSesion(this, correo_electronico, contrasena);
        //System.out.println("\nSesión Iniciada Correctamente para " + this + "\n");
    }

    public void cerrarSesion() throws IllegalStateException {
        gestionarSesion.cerrarSesion();
        //System.out.println("\nSesión Cerrada Correctamente para " + this + "\n");
    }

    @Override
    public String toString() {
        return "Cliente(" +
                ", correo_electronico = " + correo_electronico +
                //", contrasena = " + contrasena + // Mostrar o no según privacidad del sistema
                ')';
    }
}
