package reserva_vuelos;

import java.util.ArrayList;
import java.util.List;

public class Avion {
    private final int num_serie;
    private final String modelo;
    private String nombre_aerolinea = null;
    private List<Trayecto> trayectos_programados = new ArrayList<Trayecto>();
    private final double capacidad_max_carga;
    private int num_asientos_totales;
    private double precio_base_asientos;
    private int num_asientos_pequenos = 0;
    private int num_asientos_normales = 0;
    private int num_asientos_grandes = 0;
    private final int num_primera_clases_ofrecidas; // Valores del nº asientos fijo para cada tipo de clase.
    private final int num_business_ofrecidas;
    private final int num_turista_ofrecidas;
    private List<NecesidadEspecial> necesidades_especiales_ofrecidas = new ArrayList<NecesidadEspecial>();
    private List<Asiento> listaAsientos = new ArrayList<Asiento>();

    // Se podrían añadir múltiples variaciones más para construir el objeto dejando por defecto las listas y la aerolinea.
    
    // Constructor con todos los argumentos posibles:
    public Avion(int num_serie, String modelo, String nombre_aerolinea, double capacidad_max_carga, 
                List<Trayecto> trayectos_programados, double precio_base_asientos, int num_asientos_pequenos, int num_asientos_normales, 
                int num_asientos_grandes, int num_primera_clases_ofrecidas, int num_business_ofrecidas, int num_turista_ofrecidas, 
                List<NecesidadEspecial> necesidades_especiales_ofrecidas) {
        this.num_serie = num_serie;
        this.modelo = modelo;
        this.nombre_aerolinea = nombre_aerolinea;
        this.capacidad_max_carga = capacidad_max_carga;
        this.trayectos_programados = trayectos_programados;
        this.precio_base_asientos = precio_base_asientos;
        this.num_asientos_grandes = num_asientos_grandes;
        this.num_asientos_normales = num_asientos_normales;
        this.num_asientos_pequenos = num_asientos_pequenos;
        this.num_primera_clases_ofrecidas = num_primera_clases_ofrecidas;
        this.num_business_ofrecidas = num_business_ofrecidas;
        this.num_turista_ofrecidas = num_turista_ofrecidas;
        this.necesidades_especiales_ofrecidas = necesidades_especiales_ofrecidas;
        this.num_asientos_totales = this.num_primera_clases_ofrecidas + this.num_business_ofrecidas + this.num_turista_ofrecidas;
        this.listaAsientos = this.generarAsientos();
    }

    // Constructor dejando vacías las listas y la aerolínea
    public Avion(int num_serie, String modelo, double capacidad_max_carga, double precio_base_asientos, int num_asientos_pequenos, 
                int num_asientos_normales, int num_asientos_grandes, int num_primera_clases_ofrecidas, int num_business_ofrecidas, 
                int num_turista_ofrecidas) {
        this.num_serie = num_serie;
        this.modelo = modelo;
        this.capacidad_max_carga = capacidad_max_carga;
        this.precio_base_asientos = precio_base_asientos;
        this.num_asientos_grandes = num_asientos_grandes;
        this.num_asientos_normales = num_asientos_normales;
        this.num_asientos_pequenos = num_asientos_pequenos;
        this.num_primera_clases_ofrecidas = num_primera_clases_ofrecidas;
        this.num_business_ofrecidas = num_business_ofrecidas;
        this.num_turista_ofrecidas = num_turista_ofrecidas;
        this.num_asientos_totales = this.num_primera_clases_ofrecidas + this.num_business_ofrecidas + this.num_turista_ofrecidas;
        this.listaAsientos = this.generarAsientos();
    }

    // Getters
    public int getNumSerie() {
        return this.num_serie;
    }

    public String getModelo() {
        return this.modelo;
    }

    public List<Trayecto> getTrayectosProgramados() {
        return this.trayectos_programados;
    }

    public double getCapacidadMaxCarga() {
        return this.capacidad_max_carga;
    }

    public List<NecesidadEspecial> getNecesidadesEspecialesOfrecidas() {
        return this.necesidades_especiales_ofrecidas;
    }

    public int getNumPrimeraClasesOfrecidas(){
        return this.num_primera_clases_ofrecidas;
    }

    public int getNumBussinessOfrecidas(){
        return this.num_business_ofrecidas;
    }

    public int getNumTuristaOfrecidas(){
        return this.num_turista_ofrecidas;
    }

    public int getAsientosTotales(){
        return this.num_asientos_totales;
    }

    public List<Asiento> getListaAsientos(){
        return this.listaAsientos;
    }

    public String getNombreAerolinea() {
        return this.nombre_aerolinea;
    }

    // Setters:
    public void setNombreAerolinea(String nombre_aerolinea){
        this.nombre_aerolinea = nombre_aerolinea;
    }

    public void addTrayecto(Trayecto trayecto){
        this.trayectos_programados.add(trayecto);
    }

    public void addTrayectos(List<Trayecto> trayectos){
        this.trayectos_programados.addAll(trayectos);
    }

    public void removeTrayecto(Trayecto trayecto){
        this.trayectos_programados.remove(trayecto);
    }

    public void removeTrayectos(List<Trayecto> trayectos){
        this.trayectos_programados.removeAll(trayectos);
    }
    

    public void addNecesidadEspecial(NecesidadEspecial necesidadEspecial) {
        this.necesidades_especiales_ofrecidas.add(necesidadEspecial);
    }
    
    public void addNecesidadesEspeciales(List<NecesidadEspecial> necesidadesEspeciales) {
        this.necesidades_especiales_ofrecidas.addAll(necesidadesEspeciales);
    }
    
    public void removeNecesidadEspecial(NecesidadEspecial necesidadEspecial) {
        this.necesidades_especiales_ofrecidas.remove(necesidadEspecial);
    }
    
    public void removeNecesidadesEspeciales(List<NecesidadEspecial> necesidadesEspeciales) {
        this.necesidades_especiales_ofrecidas.removeAll(necesidadesEspeciales);
    }

    // Método para generar la lista de asientos del avion
    private List<Asiento> generarAsientos() throws IllegalArgumentException {
        return GenerarAsientos.generarAsientos(this.listaAsientos, this.precio_base_asientos, this.num_asientos_grandes, this.num_asientos_normales, this.num_asientos_pequenos);
    }

    // IMPORTANTE:
    // Aquí depende de la implementación, se podría imprimir una lista de Vuelos del Avion, pero como en nuestra implementación en un mismo Trayecto
    // pueden intervenir distintos Aviones (de distintas Aerolineas o de la misma), entonces se ha optado por que cada Avion guarde solo
    // los Trayectos que va a realizar.
    @Override
    public String toString() {
        return "Avion(" +
                "num_serie = " + this.num_serie +
                ", modelo = " + this.modelo +
                ", trayectos programados = " + this.trayectos_programados +
                ", capacidad máxima carga = " + this.capacidad_max_carga +
                ", numero total de asientos = " + this.getAsientosTotales() +
                ", necesidades especiales ofrecidas = " + this.necesidades_especiales_ofrecidas +
                ")";
    }
}
