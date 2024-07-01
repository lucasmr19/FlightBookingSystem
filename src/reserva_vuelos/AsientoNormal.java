package reserva_vuelos;

public class AsientoNormal extends Asiento {

    // Constructor
    public AsientoNormal(int fila, char columna, double precioBase, boolean proximoASalidaEmergencia) {
        super(fila, columna, precioBase, proximoASalidaEmergencia);
    }

    // Método para obtener el precio total del asiento normal
    @Override
    public double getPrecio() {
        return this.precioBase;
    }

    // Método toString
    @Override
    public String toString() {
        return "AsientoNormal(fila = " + fila + ", columna = " + columna + ", precio = " + this.getPrecio() + ")";
    }
}
