package reserva_vuelos;

public abstract class Asiento {
    protected int fila;
    protected char columna;
    protected double precioBase; // Precio base del asiento
    protected boolean proximoASalidaEmergencia;

    // Constructor
    public Asiento(int fila, char columna, double precioBase, boolean proximoASalidaEmergencia) {
        this.fila = fila;
        this.columna = columna;
        this.precioBase = precioBase;
        this.proximoASalidaEmergencia = proximoASalidaEmergencia;
    }

    // Getters y setters
    public boolean getProximoASalidaEmergencia() {
        return this.proximoASalidaEmergencia;
    }

    public int getFila() {
        return this.fila;
    }

    public char getColumna() {
        return this.columna;
    }

    // Distintos precios según tipo de Asiento
    public abstract double getPrecio();

    public abstract String toString();

}

