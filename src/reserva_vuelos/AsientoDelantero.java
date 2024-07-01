package reserva_vuelos;

public class AsientoDelantero extends Asiento {
    private double precioExtra; // Precio extra por estar entre las filas 2-5

    // Constructor
    public AsientoDelantero(int fila, char columna, double precioBase, double precioExtra, boolean proximoASalidaEmergencia) {
        super(fila, columna, precioBase, proximoASalidaEmergencia);
        this.precioExtra = precioExtra;
    }

    // Método para obtener el precio total del asiento pequeño
    @Override
    public double getPrecio() {
        return this.precioBase + precioExtra;
    }

    @Override
    public String toString() {
        return "AsientoDelantero(fila = " + fila + ", columna = " + columna + ", precio = " + this.getPrecio() + ")";
    }
}
