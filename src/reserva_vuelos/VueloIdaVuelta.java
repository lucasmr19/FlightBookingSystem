package reserva_vuelos;

import java.util.ArrayList;
import java.util.List;

public class VueloIdaVuelta extends Vuelo {

    private VueloUnidireccional vueloIda;
    private VueloUnidireccional vueloVuelta;

    public VueloIdaVuelta(VueloUnidireccional vueloIda, VueloUnidireccional vueloVuelta) {
        this.vueloIda = vueloIda;
        this.vueloVuelta = vueloVuelta;
    }

    // Al tratarse de dos Vuelos de única dirección, la mayoría de métodos será hacer varias veces lo mismo para cada objeto
    @Override
    public String getId() {
        return vueloIda.getId() + "/" + vueloVuelta.getId();
    }

    @Override
    public double getPrecio() {
        return vueloIda.getPrecio() + vueloVuelta.getPrecio();
    }

    @Override
    public double getCargaVuelo() {
        return vueloIda.getCargaVuelo() + vueloVuelta.getCargaVuelo();
    }

    @Override
    public int getNumPasajeros() {
        return vueloIda.getNumPasajeros() + vueloVuelta.getNumPasajeros();
    }

    @Override
    public int getNumPrimeraClaseReservadas() {
        return vueloIda.getNumPrimeraClaseReservadas() + vueloVuelta.getNumPrimeraClaseReservadas();
    }

    @Override
    public int getNumBusinessReservadas() {
        return vueloIda.getNumBusinessReservadas() + vueloVuelta.getNumBusinessReservadas();
    }

    @Override
    public int getNumTuristaReservadas() {
        return vueloIda.getNumTuristaReservadas() + vueloVuelta.getNumTuristaReservadas();
    }

    @Override
    public List<Trayecto> getTrayectos() {
        List<Trayecto> trayectos = new ArrayList<Trayecto>();
        trayectos.addAll(vueloIda.getTrayectos());
        trayectos.addAll(vueloVuelta.getTrayectos());
        return trayectos;
    }

    @Override
    public List<Asiento> getAsientosDisponibles() {
        List<Asiento> asientos = new ArrayList<Asiento>();
        asientos.addAll(vueloIda.getAsientosDisponibles());
        asientos.addAll(vueloVuelta.getAsientosDisponibles());
        return asientos;
    }


    @Override
    protected void incrementNumPrimeraClaseReservadas(int cantidad) throws IllegalStateException {
        vueloIda.incrementNumPrimeraClaseReservadas(cantidad);
        vueloVuelta.incrementNumPrimeraClaseReservadas(cantidad);
    }

    @Override
    protected void decrementNumPrimeraClaseReservadas(int cantidad) throws IllegalStateException {
        vueloVuelta.decrementNumPrimeraClaseReservadas(cantidad);
    }

    @Override
    protected void incrementNumBusinessReservadas(int cantidad) throws IllegalStateException {
        vueloIda.incrementNumBusinessReservadas(cantidad);
        vueloVuelta.incrementNumBusinessReservadas(cantidad);
    }

    @Override
    protected void decrementNumBusinessReservadas(int cantidad) throws IllegalStateException {
        vueloIda.decrementNumBusinessReservadas(cantidad);
        vueloVuelta.decrementNumBusinessReservadas(cantidad);
    }

    @Override
    protected void incrementNumTuristaReservadas(int cantidad) throws IllegalStateException {
        vueloIda.incrementNumTuristaReservadas(cantidad);
        vueloVuelta.incrementNumTuristaReservadas(cantidad);
    }

    @Override
    protected void decrementNumTuristaReservadas(int cantidad) throws IllegalStateException {
        vueloIda.decrementNumTuristaReservadas(cantidad);
        vueloVuelta.decrementNumTuristaReservadas(cantidad);
    }

    @Override
    protected void incrementCargaVuelo(double carga) throws IllegalStateException {
        vueloIda.incrementCargaVuelo(carga);
        vueloVuelta.incrementCargaVuelo(carga);
    }

    @Override
    public String toString() {
        return "VueloIdaVuelta(" +
                "ida = " + vueloIda +
                ", vuelta = " + vueloVuelta +
                ")";
    }

}
