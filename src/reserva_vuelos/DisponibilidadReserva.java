package reserva_vuelos;

import java.util.ArrayList;
import java.util.List;

// Métodos para checkear la disponiblidad del Vuelo al realizar una Reserva por un Pasajero
public class DisponibilidadReserva {

    // Devuelve una Tupla con una bandera booleana si se pueden reservar esos billetes en el vuelo,
    // así como la lista con el precio de la suma de los billetes, los asientos de los billetes y los contadores de cuantos billetes de cada tipo.
    protected static Fourth<Boolean, Double, List<Asiento>, Third<Integer, Integer, Integer>> isAsientosDisponibles(List<Billete> billetes, Vuelo vuelo) {
        boolean asiento_disponible = true;

        // Obtener un avion cualquiera del vuelo, todos tienen los mismos asientos disponibles
        Trayecto primerTrayecto = vuelo.getTrayectos().get(0);
        Avion avion = primerTrayecto.getAvion();


        List<Asiento> asientos_reservados_vuelo = vuelo.getAsientosReservados();
        List<Asiento> asientos_deseados = new ArrayList<Asiento>();

        double precio_a_pagar_billetes_asientos = 0;

        int contadorPrimeraClase = avion.getNumPrimeraClasesOfrecidas() - vuelo.getNumPrimeraClaseReservadas();
        int contadorBusiness = avion.getNumBussinessOfrecidas() - vuelo.getNumBusinessReservadas();
        int contadorTurista = avion.getNumTuristaOfrecidas() - vuelo.getNumTuristaReservadas();

        int num_primera_clase_deseadas = 0;
        int num_business_deseadas = 0;
        int num_turistas_deseadas = 0;

        for (Billete billete : billetes) {
            Asiento asiento = billete.getAsiento();
            IdBillete tipo_asiento_deseado = billete.getId();
            precio_a_pagar_billetes_asientos += billete.getPrecio() + billete.getAsiento().getPrecio();
            asientos_deseados.add(asiento);
            if (asientos_reservados_vuelo.contains(asiento)) {
                asiento_disponible = false; // El asiento como tal, no está disponible
            }
            switch (tipo_asiento_deseado) {
                case PRIMERA_CLASE:
                num_primera_clase_deseadas++;
                    if (contadorPrimeraClase <= 0) {
                        asiento_disponible = false; // No hay más asientos de primera clase disponibles
                    } else {
                        contadorPrimeraClase--;
                    }
                    break;
                case BUSINESS:
                    num_business_deseadas++;
                    if (contadorBusiness <= 0) {
                        asiento_disponible = false; // No hay más asientos de business disponibles
                    } else {
                        contadorBusiness--;
                    }
                    break;
                case TURISTA:
                    num_turistas_deseadas++;
                    if (contadorTurista <= 0) {
                        asiento_disponible = false; // No hay más asientos de turista disponibles
                    } else {
                        contadorTurista--;
                    }
                    break;
            }
        }
        Third<Integer, Integer, Integer> contadoresAsientos = new Third<>(num_primera_clase_deseadas, num_business_deseadas, num_turistas_deseadas);
        return new Fourth<Boolean, Double, List<Asiento>, Third<Integer, Integer, Integer>>(asiento_disponible, precio_a_pagar_billetes_asientos, asientos_deseados, contadoresAsientos);
    }

    // Devuelve tanto la carga acumulada de los equipajes como la bandera booleana de si cabe.
    // Esto se hace para no volver a reccorer luego la lista de equipajes y calcular 2 veces la carga a aumentar.
    protected static Third<Boolean, Double, Double> getInfoEquipajes(List<Equipaje> equipajes, Vuelo vuelo) {
        // Calcular la carga total sumando los pesos de los equipajes
        double cargaTotal = 0;
        double precio_a_pagar_equipajes = 0;
        for (Equipaje equipaje : equipajes) {
            cargaTotal += equipaje.getPeso();
            precio_a_pagar_equipajes += equipaje.getPrecio();
        }
    
        // Obtener un avion cualquiera del vuelo, todos tienen la misma carga
        Trayecto primerTrayecto = vuelo.getTrayectos().get(0);
        Avion avion = primerTrayecto.getAvion();
    
        // Verificar si la carga total cabe en el avión
        boolean cabe = (vuelo.getCargaVuelo() + cargaTotal) <= avion.getCapacidadMaxCarga();
    
        // Devolver la tupla con el resultado y la carga total calculada
        return new Third<Boolean, Double, Double>(cabe, cargaTotal, precio_a_pagar_equipajes);
    }
}