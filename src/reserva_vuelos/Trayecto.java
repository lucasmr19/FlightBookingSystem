package reserva_vuelos;

import java.time.LocalDateTime;
import java.time.Duration;

// Representa una parte de todo el Vuelo en si.
public class Trayecto {
    protected LocalDateTime fecha_salida;
    protected LocalDateTime fecha_llegada;
    protected Aeropuerto aeropuerto_origen;
    protected Aeropuerto aeropuerto_destino;
    protected Avion avion_trayecto; // Referencia al Avion de este Trayecto
    protected int terminal_origen;
    protected int terminal_destino;

    // Constructor
    public Trayecto(LocalDateTime fecha_salida, LocalDateTime fecha_llegada, Aeropuerto aeropuerto_origen,
                    Aeropuerto aeropuerto_destino, Avion avion_trayecto, int terminal_origen, int terminal_destino) {
        this.fecha_salida = fecha_salida;
        this.fecha_llegada = fecha_llegada;
        this.aeropuerto_origen = aeropuerto_origen;
        this.aeropuerto_destino = aeropuerto_destino;
        this.avion_trayecto = avion_trayecto;
        this.terminal_origen = terminal_origen;
        this.terminal_destino = terminal_destino;
    }

    public LocalDateTime getFechaSalida() {
        return this.fecha_salida;
    }

    public LocalDateTime getFechaLlegada() {
        return this.fecha_llegada;
    }

    public Aeropuerto getAeropuertoOrigen() {
        return this.aeropuerto_origen;
    }

    public Aeropuerto getAeropuertoLlegada() {
        return this.aeropuerto_destino;
    }

    public int getTerminalOrigen() {
        return this.terminal_origen;
    }

    public int getTerminalDestino() {
        return this.terminal_destino;
    }

    public Avion getAvion() {
        return this.avion_trayecto;
    }

    public Duration getDurationTrayecto() {
        return Duration.between(this.fecha_salida, this.fecha_llegada);
    }

    public void setAvion(Avion avion){
        this.avion_trayecto = avion;
    }

    @Override
    public String toString() {
        return "Trayecto(" +
                "fecha_salida = " + fecha_salida +
                ", fecha_llegada = " + fecha_llegada +
                ", duracion_trayecto = " + this.getDurationTrayecto() +
                ", aeropuerto_origen = " + aeropuerto_origen +
                ", aeropuerto_destino = " + aeropuerto_destino +
                ", terminal_origen = terminal " + terminal_origen +
                ", terminal_destino = terminal " + terminal_destino +
                ")";
    }
}
