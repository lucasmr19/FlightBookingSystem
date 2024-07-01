package reserva_vuelos;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PasajeroMayorEdad extends Pasajero {
    private List<MetodoPago> metodos_pago = new ArrayList<>();
    private List<Reserva> reservas_realizadas = new ArrayList<>();

    // Constructor para mayor de edad
    protected PasajeroMayorEdad(DocumentoIdentidad id_pasajero, String correo_electronico, String contrasena) {
        //super(correo_electronico, contrasena);
        int edad = id_pasajero.getEdad();
        if (edad < 18) {
            throw new IllegalArgumentException("El pasajero menor de edad debe tener una persona a su cargo!");
        }
        this.id_pasajero = id_pasajero;
        this.correo_electronico = correo_electronico;
        this.contrasena = contrasena;
    }

    public List<MetodoPago> getMetodosPago() {
        return metodos_pago;
    }

    public List<Reserva> getReservasRealizadas() {
        return reservas_realizadas;
    }

    protected void addMetodoPago(MetodoPago metodoPago){
        this.metodos_pago.add(metodoPago);
    }

    protected void addMetodosPago(List<MetodoPago> metodosPago){
        this.metodos_pago.addAll(metodosPago);
    }

    protected void removeMetodoPago(MetodoPago metodoPago){
        this.metodos_pago.remove(metodoPago);
    }

    protected void removeMetodosPago(List<MetodoPago> metodosPago){
        this.metodos_pago.removeAll(metodosPago);
    }

    public void addReserva(Reserva reserva){
        this.reservas_realizadas.add(reserva);
    }
    
    public void addReservas(List<Reserva> reservas){
        this.reservas_realizadas.addAll(reservas);
    }
    
    public void removeReserva(Reserva reserva){
        this.reservas_realizadas.remove(reserva);
    }
    
    public void removeReservas(List<Reserva> reservas){
        this.reservas_realizadas.removeAll(reservas);
    }

    public void realizar_reserva(List<Pasajero> pasajeros, List<Equipaje> equipajes, List<Billete> billetes, Vuelo vuelo, MetodoPago metodoPago){
        if (!gestionarSesion.isSesionIniciada()) {
            throw new IllegalStateException("Se debe iniciar sesión para poder reservar.");
        }
        RealizarReserva.realizar_reserva(this, pasajeros, equipajes,  billetes, vuelo, metodoPago);
    }

    public Reserva consultar_reserva(String id_reserva) throws NoSuchElementException{
        for(Reserva reserva: this.reservas_realizadas) {
            if (reserva.getIdReserva() == id_reserva) {
                return reserva;
            }
        }
        throw new NoSuchElementException("No se ha encontrado su Reserva con el ID proporcionado");
    }

    @Override
    public String toString() {
        return "PasajeroMayorEdad(" +
                "identificación = " + this.id_pasajero +
                ", correo_electronico = " + this.correo_electronico +
                //", contraseña = " + this.contrasena + // Por privacidad del pasajero se podría no mostrar la contraseña
                ", métodos_pago = " + this.metodos_pago +
                ", reservas_realizadas = " + this.reservas_realizadas +
                ", necesidades_especiales = " + this.necesidades_especiales +
                ')';
    }

}
