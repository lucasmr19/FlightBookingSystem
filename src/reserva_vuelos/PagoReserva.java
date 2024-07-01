package reserva_vuelos;

import java.util.List;
import java.util.Scanner;

public class PagoReserva {
    protected static void realizarPago(PasajeroMayorEdad pasajero, List<Pasajero> pasajeros, List<Equipaje> equipajes, List<Billete> billetes, 
                        Vuelo vuelo, MetodoPago metodoPago, double precioTotal, double cargaTotal, List<Asiento> asientosDeseados, 
                        Third<Integer, Integer, Integer> contadoresTipoClase, List<DocumentoIdentidad> idPasajeros) {
        // Verificar si el método de pago está en la lista
        if (!pasajero.getMetodosPago().contains(metodoPago)) {
            // Si el método de pago no estaba en la lista, añadirlo a esta.
            pasajero.addMetodoPago(metodoPago);
        }

        // Realizar el pago
        double saldoActual = metodoPago.getSaldoDisponible();
        if (saldoActual >= precioTotal) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("El pago total de la reserva es de " + precioTotal + " euros, ¿Seguro que desea continuar? [Y/N]");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            scanner.close();
            if (respuesta.equals("yes") || respuesta.equals("y")) {

                // Actualizar el objeto Vuelo:
                vuelo.incrementCargaVuelo(cargaTotal);
                vuelo.reservarAsientos(asientosDeseados);
                vuelo.incrementNumPrimeraClaseReservadas(contadoresTipoClase.getFirst());
                vuelo.incrementNumBusinessReservadas(contadoresTipoClase.getSecond());
                vuelo.incrementNumTuristaReservadas(contadoresTipoClase.getThird());

                // Quitar saldo del metodoPago
                metodoPago.removeCantidadSaldo(precioTotal);
                // Añadir la reserva a las realizadas por el pasajero:
                // Crear una nueva instancia de Reserva
                Reserva reserva = new Reserva(); 

                // Generar un ID único para la reserva:
                reserva.setIdReserva(GeneradorIdUnico.generarIdUnico());

                // Agregar equipajes, pasajeros, vuelo y método de pago a la reserva, cuando se traten de listas, utilizar la interfaz.
                reserva.addEquipajes(equipajes);
                reserva.addIdPasajeros(idPasajeros);
                reserva.setVueloReservado(vuelo);
                reserva.addBilletes(billetes);
                reserva.setPrecioTotalReserva(precioTotal);
                pasajero.addReserva(reserva);
                
                System.out.println("Operación confiramada. La Reserva se ha realizado correctamente.");
                //System.out.println("Recordatorio: le quedan " + metodoPago.getSaldoDisponible() + " euros en su " + metodoPago.getClass().getSimpleName());
                return;
            } else if (respuesta.equals("n") || respuesta.equals("no") ) {
                System.out.println("Operación cancelada. No se confirmó la Reserva.");
                return;
            } else {
                System.out.println("Respuesta inválida. Operación cancelada. No se realizó ningún pago.");
                return;
            }
        } else {
            throw new IllegalStateException("El saldo de su " + metodoPago.getClass().getSimpleName() + " (" + metodoPago.getSaldoDisponible() + " euros) es insuficiente para realizar el pago de esta operación (" + precioTotal + " euros)");
        }
    }
}
