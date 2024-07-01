package reserva_vuelos;

public class Billete {
    private IdBillete idBillete; // Nombre, precio y descripción (fijos) para cada clase. No tiene porque ser único
    private double precio;
    private String descripcion;
    private Asiento asiento;
    private Trayecto trayecto; // Referencia al trayecto que abarca el billete
    private DocumentoIdentidad pasajero_id; // Referencia a la identificación de la persona asociada a este billete

    /// Constructor
    public Billete(IdBillete idBillete, Asiento asiento, Trayecto trayecto, DocumentoIdentidad pasajeroId) {
        this.idBillete = idBillete;
        this.precio = idBillete.getPrecio();
        this.descripcion = idBillete.getDescripcion();
        this.asiento = asiento;
        this.trayecto = trayecto;
        this.pasajero_id = pasajeroId;
    }

    // Getters
    public IdBillete getId() {
        return this.idBillete;
    }

    public double getPrecio() {
        return this.precio;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public Asiento getAsiento() {
        return this.asiento;
    }

    public Trayecto getTrayecto() {
        return this.trayecto;
    }

    public DocumentoIdentidad getPasajeroId() {
        return this.pasajero_id;
    }

    // Método toString para mostrar información sobre el billete
    @Override
    public String toString() {
        return "Billete(" +
                "pasajeroId = " + this.pasajero_id +
                ", clase = " + this.idBillete +
                ", Descripción = " + this.descripcion +
                ", precio = " + this.precio +
                ", asiento = " + this.asiento +
                ", trayecto = " + this.trayecto +
                ")";
    }
}
