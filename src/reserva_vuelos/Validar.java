package reserva_vuelos;

import java.util.regex.Pattern;

// Clase con métodos de validación utilizados en difrentes partes del código
public class Validar {

    protected static void validarContrasena(String contrasena) {
        // Checkear que contrasena sea de minimo 8 carácteres y máximo 16 y contenga al menos 1 mayus, 1 minus, 1 numero y 1 caracter especial
        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=_])(?=\\S+$).{8,16}$";
        if (!contrasena.matches(passwordPattern)) {
            throw new IllegalArgumentException("La contraseña debe tener entre 8 y 16 caracteres, y contener al menos una mayúscula, una minúscula, un número y un caracter especial.");
        }
    }

    protected static void validarCorreo(String correo) throws IllegalArgumentException {
        // Expresión regular para validar direcciones de correo electrónico
        String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        
        // Verificar si la dirección de correo electrónico cumple con el patrón
        if (!correo.matches(emailPattern)) {
            throw new IllegalArgumentException("El correo electrónico no es válido.");
        }
    }

    protected static void validarIdentificacion(String identificacion) throws IllegalArgumentException {
        // Expresión regular para el formato de la identificación
        String regex = "\\d{8}[A-Z]";
        
        // Verificar si la identificación coincide con el formato
        if (!Pattern.matches(regex, identificacion)) {
            throw new IllegalArgumentException("El número de identificación es con 8 números y una letra mayúscula");
        }
    }

    protected static void validarNombresYApellidos(DocumentoIdentidad id_usuario) throws IllegalArgumentException {
        String namePattern = "[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+";
        if (!id_usuario.getNombre().matches(namePattern) || !id_usuario.getApellido1().matches(namePattern) || !id_usuario.getApellido2().matches(namePattern)) {
            throw new IllegalArgumentException("Los nombres y apellidos deben contener solo letras, con la primera en mayúscula y las demás en minúscula.");
        }
    }

}
