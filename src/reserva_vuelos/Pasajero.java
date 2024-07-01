package reserva_vuelos;

import java.util.ArrayList;
import java.util.List;

public abstract class Pasajero extends Cliente implements IObservador {
    protected DocumentoIdentidad id_pasajero;
    protected List<NecesidadEspecial> necesidades_especiales = new ArrayList<>();
    protected Vuelo vuelo_suscrito;


    // De nuevo los constructores se definen como protected por lo comentado en Cliente.
    
    // En cuanto a los constructores: se podrían crear múltiples variantes que permitan incluir las listas
    // de métodos de pago, necesidades especiales y demás. Pero por no complicar en exceso se omiten estas posiblidades.    
    protected Pasajero(){};

    // Getters y setters
    public DocumentoIdentidad getId() {
        return this.id_pasajero;
    }

    public int getEdad() {
        return this.id_pasajero.getEdad();
    }

    public List<NecesidadEspecial> getNecesidadesEspeciales() {
        return necesidades_especiales;
    }

    public String getInformation() {
        return "Pasajero(identificación = " + this.id_pasajero + ")";
    }

    public void addNecesidadEspecial(NecesidadEspecial necesidadEspecial){
        this.necesidades_especiales.add(necesidadEspecial);
    }
    
    public void addNecesidadesEspeciales(List<NecesidadEspecial> necesidadesEspeciales){
        this.necesidades_especiales.addAll(necesidadesEspeciales);
    }

    public void removeNecesidadEspecial(NecesidadEspecial necesidadEspecial){
        this.necesidades_especiales.remove(necesidadEspecial);
    }
    
    public void removeNecesidadesEspeciales(List<NecesidadEspecial> necesidadesEspeciales){
        this.necesidades_especiales.removeAll(necesidadesEspeciales);
    }

    // El pasajero decide sobre que vuelo quiere recibir notificaciones. 
    // Esto sería equivalente a pasar el objeto Vuelo en el constructor del objeto
    public void recibirNotificaciones(Vuelo vuelo) {
        this.vuelo_suscrito = vuelo;
    }

    public abstract String toString();

    @Override
    public void actualizar() {
        String puertaEmbarque = (this.vuelo_suscrito.getPuertaEmbarque() != 0) ? String.valueOf(this.vuelo_suscrito.getPuertaEmbarque()) : "No disponible de momento";
        System.out.println("Notificación para el pasajero con identificación = " + this.getId() + ":");
        System.out.println("El vuelo con id = " + this.vuelo_suscrito.getId() + " actualmente tiene como estado = " + this.vuelo_suscrito.getEstado()
                            + " y como puerta de embarque = " + puertaEmbarque);
        System.out.println();
    }

}
