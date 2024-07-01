package reserva_vuelos;

// Aquí se establecen unos precios fijos para cada tipo de clase
public enum IdBillete {
    PRIMERA_CLASE(200, "Primera Clase", "Clase Premium con servicios exclusivos"),
    BUSINESS(100, "Business", "Clase Ejecutiva con comodidades adicionales"),
    TURISTA(10, "Turista", "Clase Económica con servicios normales");
    
    // Tipo final ya que su valor es fijo para todos los atributos
    private final double precio;
    private final String nombre; 
    private final String descripcion;
    
    private IdBillete(double precio, String nombre, String descripcion) {
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}