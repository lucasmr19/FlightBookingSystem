package reserva_vuelos;

import java.util.List;
// Vuelo en 1 sola dirección y con posibles escalas (varios trayectos):
public class VueloUnidireccional extends Vuelo {
    // Constructor con todos los argumentos posibles de entrada:
    public VueloUnidireccional(String id_vuelo, double precio_vuelo,  List<Trayecto> trayectos) {
        this.id_vuelo = id_vuelo;
        this.precio_vuelo = precio_vuelo;
        this.trayectos = trayectos;
        inicializarAsientosDisponibles();
    }

    // Constructor sin los argumentos por defecto.
    public VueloUnidireccional(String id_vuelo, double precio_vuelo) {
        this.id_vuelo = id_vuelo;
        this.precio_vuelo = precio_vuelo;
    }

    // Adders y más métodos:
    public void addTrayecto(Trayecto trayecto) throws IllegalArgumentException {
        if (this.trayectos.isEmpty()) {
            this.trayectos.add(trayecto);
            inicializarAsientosDisponibles();
            return;
        }
        
        // Comprobar que el nuevo trayecto tiene el mismo número de asientos disponibles para cada tipo de clase
        if (!checkNuevoTrayecto(trayecto)) {
            throw new IllegalArgumentException("Todos los aviones del Vuelo deben tener el mismo número de asientos disponibles de cada clase y la misma capacidad de carga!");
        }
        
        // Si pasa la validación, agregar el trayecto
        this.trayectos.add(trayecto);;
    }
    
    public void addTrayectos(List<Trayecto> trayectos) throws IllegalArgumentException {
        if (this.trayectos.isEmpty()) {
            this.trayectos.addAll(trayectos);
            inicializarAsientosDisponibles();
            return;
        }
        
        // Comprobar que cada nuevo trayecto tiene el mismo número de asientos disponibles para cada tipo de clase
        for (Trayecto trayecto : trayectos) {
            if (!checkNuevoTrayecto(trayecto)) {
                throw new IllegalArgumentException("Todos los aviones del Vuelo deben tener el mismo número de asientos disponibles de cada clase y la misma capacidad de carga!");
            }
        }
        
        // Si pasan la validación, agregar los trayectos
        this.trayectos.addAll(trayectos);
    }

    // Método para verificar que el nuevo trayecto tiene el mismo número de asientos disponibles 
    // para cada tipo de clase, así como la misma capacidad de carga
    private boolean checkNuevoTrayecto(Trayecto nuevoTrayecto) {
        // Obtener el último trayecto agregado
        Trayecto ultimoTrayecto = this.trayectos.get(this.trayectos.size() - 1);
        
        Avion avionExistente = ultimoTrayecto.getAvion(); // Obtener el avión del último trayecto agregado
        Avion nuevoAvion = nuevoTrayecto.getAvion(); // Obtener el avión del nuevo trayecto
        
        // Comprobar si los aviones tienen las mismas características
        return avionExistente.getNumPrimeraClasesOfrecidas() == nuevoAvion.getNumPrimeraClasesOfrecidas() &&
               avionExistente.getNumBussinessOfrecidas() == nuevoAvion.getNumBussinessOfrecidas() &&
               avionExistente.getNumTuristaOfrecidas() == nuevoAvion.getNumTuristaOfrecidas() &&
               avionExistente.getNecesidadesEspecialesOfrecidas().equals(nuevoAvion.getNecesidadesEspecialesOfrecidas()) &&
               avionExistente.getCapacidadMaxCarga() == nuevoAvion.getCapacidadMaxCarga();
    }

    private void inicializarAsientosDisponibles() {
        // Tomar cualquier trayecto del vuelo ya que todos los aviones deben tener los mismos asientos disponibles
        Trayecto trayecto = this.getTrayectos().get(0);
        Avion avion = trayecto.getAvion();
        
        List<Asiento> asientosTotales = avion.getListaAsientos();
        this.asientosDisponibles = asientosTotales;
    }

     // Método para obtener los asientos disponibles
    @Override
    public List<Asiento> getAsientosDisponibles() {
        return this.asientosDisponibles;
    }

    // Método toString para imprimir
    @Override
    public String toString() {
        return "VueloUnidireccional(ID = " + this.id_vuelo + 
               ", Precio = " + this.precio_vuelo + 
               ", trayectos = " + this.trayectos +
               ")";
    }
}
