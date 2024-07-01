package reserva_vuelos;

import java.time.LocalDate;
import java.time.Period;

// Por simplicidad añadimos solo los datos necesarios para el sistema
public class DocumentoIdentidad {
    private String numeroIdentificacion;
    private LocalDate fechaNacimiento;
    protected final String nombre;
    protected final String apellido1;
    protected final String apellido2; 

    public DocumentoIdentidad(String numeroIdentificacion, LocalDate fechaNacimiento, String nombre, String apellido1, String apellido2) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getEdad() {
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, ahora);
        return periodo.getYears();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    @Override
    public String toString() {
        return "DocumentoIdentidad(" +
                "numeroIdentificacion = " + numeroIdentificacion +
                ", fechaNacimiento = " + fechaNacimiento +
                ", nombre = " + nombre +
                ", apellido1 = " + apellido1 +
                ", apellido2 = " + apellido2 +
                ")";
    }
}
