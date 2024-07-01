package reserva_vuelos;

public class NecesidadEspecial {
    private final int id_necesidad_especial;
    private final String nombre_necesidad_especial;
    private final String descripcion_necesidad_especial;

    // Constructor
    public NecesidadEspecial(int id_necesidad_especial, String nombre_necesidad_especial, String descripcion_necesidad_especial) {
        this.id_necesidad_especial = id_necesidad_especial;
        this.nombre_necesidad_especial = nombre_necesidad_especial;
        this.descripcion_necesidad_especial = descripcion_necesidad_especial;
    }

    // Getters
    public int getId() {
        return id_necesidad_especial;
    }

    public String getDescripcion() {
        return descripcion_necesidad_especial;
    }

    public String getNombre() {
        return nombre_necesidad_especial;
    }

    // Método toString
    @Override
    public String toString() {
        return "NecesidadEspecial(" +
                "id = " + id_necesidad_especial +
                ", nombre = " + nombre_necesidad_especial +
                ", descripcion = " + descripcion_necesidad_especial +
                ')';
    }
}
