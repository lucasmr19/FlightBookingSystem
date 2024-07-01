package reserva_vuelos;

import java.util.ArrayList;
import java.util.List;

public class Aerolinea {
    private final int id_aerolinea;
    private String nombre_aerolinea;
    private List<Avion> flota_aviones = new ArrayList<Avion>();
    private String politica_equipaje = "No se ha establecido una política de equipaje";

    // Constructor
    public Aerolinea(int id_aerolinea, String nombre_aerolinea, List<Avion> flota_aviones, String politica_equipaje) {
        this.id_aerolinea = id_aerolinea;
        this.nombre_aerolinea = nombre_aerolinea;
        this.flota_aviones = flota_aviones;
        this.politica_equipaje = politica_equipaje;
    }

    // Constructor sin la flota de aviones
    public Aerolinea(int id_aerolinea, String nombre_aerolinea, String politica_equipaje) {
        this.id_aerolinea = id_aerolinea;
        this.nombre_aerolinea = nombre_aerolinea;
        this.politica_equipaje = politica_equipaje;
    }

    // Constructor sin la politica de equipaje
    public Aerolinea(int id_aerolinea, String nombre_aerolinea, List<Avion> flota_aviones) {
        this.id_aerolinea = id_aerolinea;
        this.nombre_aerolinea = nombre_aerolinea;
        this.flota_aviones = flota_aviones;
    }

    // Constructor sin la flota de aviones y sin politica de equipaje
    public Aerolinea(int id_aerolinea, String nombre_aerolinea) {
        this.id_aerolinea = id_aerolinea;
        this.nombre_aerolinea = nombre_aerolinea;
    }

    // Getters
    public int getIdAerolinea() {
        return id_aerolinea;
    }

    public String getNombreAerolinea() {
        return nombre_aerolinea;
    }

    public void setNombreAerolinea(String nombre_aerolinea) {
        this.nombre_aerolinea = nombre_aerolinea;
    }

    public List<Avion> getFlotaAviones() {
        return flota_aviones;
    }

    public String getPoliticaEquipaje() {
        return politica_equipaje;
    }

    // Setters
    protected void setPoliticaEquipaje(String politica_equipaje) {
        this.politica_equipaje = politica_equipaje;
    }

    public void addAvion(Avion avion){
        this.flota_aviones.add(avion);
    }
    
    public void addAviones(List<Avion> aviones){
        this.flota_aviones.addAll(aviones);
    }
    
    public void removeAvion(Avion avion){
        this.flota_aviones.remove(avion);
    }
    
    public void removeAviones(List<Avion> aviones){
        this.flota_aviones.removeAll(aviones);
    }

    // Método toString
    @Override
    public String toString() {
        return "Aerolinea(" +
                "id = " + id_aerolinea +
                ", nombre = " + nombre_aerolinea +
                ", flota de aviones = " + flota_aviones +
                ", politica de equipaje = " + politica_equipaje +
                ")";
    }
}