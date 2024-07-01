package reserva_vuelos;

public class AsientoGrande extends Asiento {
    private double precioExtra; // Precio extra para el asiento grande

    // Constructor
    public AsientoGrande(int fila, char columna, double precioBase, double precioExtra, boolean proximoASalidaEmergencia) {
        super(fila, columna, precioBase, proximoASalidaEmergencia);
        this.precioExtra = precioExtra;
    }

    // Método para obtener el precio total del asiento grande
    @Override
    public double getPrecio() {
        return this.precioBase + precioExtra;
    }

    @Override
    public String toString() {
        return "AsientoGrande(fila = " + fila + ", columna = " + columna + ", precio = " + this.getPrecio() + ")";
    }
}
