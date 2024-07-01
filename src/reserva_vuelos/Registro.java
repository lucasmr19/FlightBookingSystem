package reserva_vuelos;

public class Registro {
    public static Cliente registrarCliente(String correo_electronico, String contrasena) throws IllegalArgumentException {
        // Checkear que el correo electronico es una direccion válida
        Validar.validarCorreo(correo_electronico);

        // Validar la contraseña
        Validar.validarContrasena(contrasena);

        // Crear y retornar un nuevo objeto Usuario
        return new Cliente(correo_electronico, contrasena);
    }


    public static PasajeroMayorEdad registrarPasajeroMayorEdad(DocumentoIdentidad id_pasajero, String correo_electronico, String contrasena) throws IllegalArgumentException {
        // Checkear la identificación del Usuario
        Validar.validarIdentificacion(id_pasajero.getNumeroIdentificacion());

        // Checkear que el campo de nombre, apellido1 y apellido2 sean solo letras (primera en mayus y resto en minusc)
        Validar.validarNombresYApellidos(id_pasajero);

        // Checkear que el correo electronico es una direccion válida
        Validar.validarCorreo(correo_electronico);

        // Validar la contraseña
        Validar.validarContrasena(contrasena);

        // Crear y retornar un nuevo objeto Usuario
        return new PasajeroMayorEdad(id_pasajero, correo_electronico, contrasena);
    }

    public static PasajeroMenorEdad registrarPasajeroMenorEdad(DocumentoIdentidad id_pasajero, PasajeroMayorEdad pasajero_a_cargo) throws IllegalArgumentException {
        // Checkear la identificación del Usuario
        Validar.validarIdentificacion(id_pasajero.getNumeroIdentificacion());

        // Checkear que el campo de nombre, apellido1 y apellido2 sean solo letras (primera en mayus y resto en minusc)
        Validar.validarNombresYApellidos(id_pasajero);

        // Crear y retornar un nuevo objeto Usuario
        return new PasajeroMenorEdad(id_pasajero, pasajero_a_cargo);
    }

    public static PasajeroBebe registrarPasajeroBebe(DocumentoIdentidad id_pasajero, PasajeroMayorEdad pasajero_a_cargo) throws IllegalArgumentException {
        // Checkear la identificación del Usuario
        Validar.validarIdentificacion(id_pasajero.getNumeroIdentificacion());

        // Checkear que el campo de nombre, apellido1 y apellido2 sean solo letras (primera en mayus y resto en minusc)
        Validar.validarNombresYApellidos(id_pasajero);

        // Crear y retornar un nuevo objeto Usuario
        return new PasajeroBebe(id_pasajero, pasajero_a_cargo);
    }
}
