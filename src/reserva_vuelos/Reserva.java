package reserva_vuelos;

import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private String id_reserva;
    private List<Equipaje> equipajes = new ArrayList<Equipaje>();
    private List<DocumentoIdentidad> identificacion_pasajeros = new ArrayList<DocumentoIdentidad>();
    private Vuelo vuelo_reservado = null;
    private List<Billete> billetes = new ArrayList<Billete>();
    private double precio_total_reserva;

    // Constructor
    protected Reserva() {
    } 

    // Getters
    public String getIdReserva() {
        return id_reserva;
    }

    public List<Equipaje> getEquipajes() {
        return equipajes;
    }

    public double getPrecioTotalReserva() {
        return this.precio_total_reserva;
    }

    public List<DocumentoIdentidad> getIdPasajeros() {
        return this.identificacion_pasajeros;
    }

    public Vuelo getVueloReservado() {
        return vuelo_reservado;
    }

    public List<Billete> getBilletes() {
        return billetes;
    }

    // Setters y modificadores de las listas:
    protected void setVueloReservado(Vuelo vuelo) {
        this.vuelo_reservado = vuelo;
    }

    protected void setIdReserva(String id_reserva) {
        this.id_reserva = id_reserva;
    }

    protected void setPrecioTotalReserva(double precio_total_reserva) {
        this.precio_total_reserva = precio_total_reserva;
    }

    protected void addEquipaje(Equipaje equipaje){
        this.equipajes.add(equipaje);
    }

    protected void addEquipajes(List<Equipaje> equipajes){
        this.equipajes.addAll(equipajes);
    }

    protected void removeEquipaje(Equipaje equipaje){
        this.equipajes.remove(equipaje);
    }

    protected void removeEquipajes(List<Equipaje> equipajes){
        this.equipajes.removeAll(equipajes);
    }

    protected void addIdPasajero(DocumentoIdentidad id_pasajero){
        this.identificacion_pasajeros.add(id_pasajero);
    }
    
    protected void addIdPasajeros(List<DocumentoIdentidad> id_pasajeros){
        this.identificacion_pasajeros.addAll(id_pasajeros);
    }
    
    protected void removeIdPasajero(DocumentoIdentidad id_pasajero){
        this.identificacion_pasajeros.remove(id_pasajero);
    }
    
    protected void removeIdPasajeros(List<DocumentoIdentidad> id_pasajeros){
        this.identificacion_pasajeros.removeAll(id_pasajeros);
    }

    protected void addBillete(Billete billete){
        this.billetes.add(billete);
    }
    
    protected void addBilletes(List<Billete> billetes){
        this.billetes.addAll(billetes);
    }
    
    protected void removeBillete(Billete billete){
        this.billetes.remove(billete);
    }
    
    protected void removeBilletes(List<Billete> billetes){
        this.billetes.removeAll(billetes);
    }

    // Método toString para imprimir
    @Override
    public String toString() {

        return "Reserva(id_reserva = " + this.id_reserva +
            ", equipajes = " + this.equipajes +
            ", identificacion_pasajeros =" + this.identificacion_pasajeros + // Todos los Pasajeros de la Reserva (aunque no paguen)
            ", billetes = " + this.billetes + // Incluyen cada trayecto
            ", vuelo reservado = " + this.vuelo_reservado + // Se repite información del Vuelo ya que muestra cada Trayecto
            ", precio_total = " + this.precio_total_reserva +
            ")";
    }

}
