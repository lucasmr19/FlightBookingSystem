package reserva_vuelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RealizarReserva {
    protected static void realizar_reserva(PasajeroMayorEdad pasajero, List<Pasajero> pasajeros, List<Equipaje> equipajes, List<Billete> billetes, Vuelo vuelo, MetodoPago metodoPago){

        // El pasajero que realiza la Reserva debe haber iniciado Sesión.
        if (!pasajero.getGestionarSesion().isSesionIniciada()) {
            throw new IllegalStateException("Se debe Iniciar Sesión para poder reservar!");
        }

        Trayecto primerTrayecto = vuelo.getTrayectos().get(0);
        Avion avion = primerTrayecto.getAvion();

        List<DocumentoIdentidad> idPasajeros = new ArrayList<DocumentoIdentidad>();

        // Comprobar cuántos pasajeros no pagan (los bebés)
        int numPasajerosPagan = 0;
        for (Pasajero p : pasajeros) {
            idPasajeros.add(p.getId());
            if (!(p instanceof PasajeroBebe)) {
                numPasajerosPagan++;
            }
            List<NecesidadEspecial> necesidades_pasajero = p.getNecesidadesEspeciales();
            for (NecesidadEspecial n: necesidades_pasajero){
                if (!avion.getNecesidadesEspecialesOfrecidas().contains(n)) {
                    if (!confirmarContinuarReserva(p)) {
                        System.out.println("Operación cancelada. No se confirmó la Reserva.");
                        return;
                    }
                }
            }
        }

        // Verificar que la cantidad de billetes coincida con la cantidad de pasajeros (que pagan) * num_trayectos_vuelo:
        int num_trayectos_vuelo =  vuelo.getTrayectos().size();
        if (billetes.size() != numPasajerosPagan*num_trayectos_vuelo) {
            throw new IllegalArgumentException("El número de billetes debe coincidir con el número de pasajeros.");
        }


        // Checkear la disponiblidad de la Reserva en el Vuelo deseado
        Fourth<Boolean, Double, List<Asiento>, Third<Integer, Integer, Integer>> asientos_reserva = DisponibilidadReserva.isAsientosDisponibles(billetes, vuelo);
        Third<Boolean, Double, Double> equipaje_reserva = DisponibilidadReserva.getInfoEquipajes(equipajes, vuelo);

        // Caso de que o bien el asiento este ocupado para el vuelo, o el tipo de clase seleccionada tampoco esté disponible
        if (!asientos_reserva.getFirst()) {
            throw new IllegalArgumentException("Los asientos seleccionados para el vuelo, no existen o no se encuentran disponibles");
        }

        if (!equipaje_reserva.getFirst()) {
            throw new IllegalArgumentException("Lo sentimos, el peso total de su equipaje excede la capacidad de carga del avión para este vuelo. Por favor, intente reducir la cantidad de equipaje.");
        }


        // Calcular el precio total a pagar por la reserva, esto se calcula en la clase DisponiblidadReserva:
        double precio_a_pagar_equipajes = equipaje_reserva.getThird();

        double precio_a_pagar_vuelo = vuelo.getPrecio();

        double precio_a_pagar_billetes = asientos_reserva.getSecond();

        double cargaTotal = equipaje_reserva.getSecond();

        // Lo único que no paga el menor de 2 años es el vuelo como tal y el billete (porque no se le asigna ninguno)
        double precio_a_pagar_total = precio_a_pagar_equipajes + numPasajerosPagan*precio_a_pagar_vuelo + precio_a_pagar_billetes;


        // Pagar la reserva y añadirla a la lista de reservas del pasajero si sale todo bien
        PagoReserva.realizarPago(pasajero, pasajeros, equipajes, billetes, vuelo, metodoPago, precio_a_pagar_total, cargaTotal, asientos_reserva.getThird(), asientos_reserva.getFourth(), idPasajeros);
    }

    private static boolean confirmarContinuarReserva(Pasajero pasajero) {
        System.out.println("La necesidad especial del pasajero " + pasajero.getId() + " no está disponible en estos momentos.");
        System.out.println("¿Aún así, desea continuar con la Reserva? [Y/N]");

        Scanner scanner = new Scanner(System.in);
        String respuesta = scanner.nextLine().trim().toLowerCase();
        scanner.close();
        return respuesta.equals("y") || respuesta.equals("yes");
    }
}