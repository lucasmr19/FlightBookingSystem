import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import reserva_vuelos.*;

public class MainEx1b {

    public static void main(String[] args) {
        System.out.println("\nMain para el segundo caso:");
        System.out.println("-----------------------------------\n");

        // Crear ubicaciones para los aeropuertos
        Location romaLocation = new Location(41.795584265826164, 12.255006453044356); // Aeropuerto de Roma Fiumicino
        Location parisLocation = new Location(49.005387127395984, 2.5804610047188876); // Aeropuerto de París Charles de Gaulle

        // Crear aeropuertos
        Aeropuerto romaAirport = new Aeropuerto("FCO", "Aeropuerto de Roma Fiumicino", romaLocation);
        Aeropuerto parisAirport = new Aeropuerto("CDG", "Aeropuerto de París Charles de Gaulle", parisLocation);

        // Calcular y mostrar la distancia entre Aeropuertos: (Opcional)
        double distancia = romaAirport.calcularDistancia(parisAirport);
        System.out.println("\nDistancia entre el Aeropuerto de Roma Fiumicino y el Aeropuerto de París Charles de Gaulle: " + distancia + " km\n");

        // Crear Aerolínea(s)
        String aerolinea_alitalia_nombre = "Alitalia";
        Aerolinea alitalia = new Aerolinea(121, aerolinea_alitalia_nombre);

        // Crear Avión
        double capacidad_max_carga = 100000; // Capacidad máxima de carga en kg
        double precio_base_asientos = 7; // Precio base de los asientos en la moneda local
        int num_asientos_delanteros = 21;
        int num_asientos_normales = 225;
        int num_asientos_grandes = 18;
        int num_primera_clases_ofrecidas = 10;
        int num_business_ofrecidas = 20;
        int num_turista_ofrecidas = 234;
        Avion airbus_A380 = new Avion(28, "A380", capacidad_max_carga, precio_base_asientos, num_asientos_delanteros, num_asientos_normales,
        num_asientos_grandes,num_primera_clases_ofrecidas,num_business_ofrecidas,num_turista_ofrecidas);
        airbus_A380.setNombreAerolinea(aerolinea_alitalia_nombre);

        // Crear Necesidad Especial y añadirla a las necesidades ofrecidas por el Avion:
        NecesidadEspecial necesidad_silla_ruedas = new NecesidadEspecial(01, "Silla ruedas", "Necesita asistencia para subir y bajar del avion");
        airbus_A380.addNecesidadEspecial(necesidad_silla_ruedas);

        // Crear Trayecto
        LocalDateTime fecha_salida = LocalDateTime.of(2024, 5, 10, 8, 30);
        LocalDateTime fecha_llegada = LocalDateTime.of(2024, 5, 10, 11, 30);
        
        Trayecto tray_rom_par = new Trayecto(fecha_salida, fecha_llegada, romaAirport, parisAirport, airbus_A380, 1, 2);
        airbus_A380.addTrayecto(tray_rom_par);

        // Crear VueloUnidireccional
        VueloUnidireccional vuelo_rom_par = new VueloUnidireccional("FCO-CDG", 150.0);
        vuelo_rom_par.addTrayecto(tray_rom_par); // Añadir los trayectos al vuelo (en este caso solo 1)

        alitalia.addAvion(airbus_A380);

        System.out.println("\nInformación de la Aerolinea Alitalia:\n");
        System.out.println(alitalia);
        
        // Crear los pasajeros:
        // Dos adultos (Uno con necesidades especiales)
        LocalDate fechaNacimiento1 = LocalDate.of(1988, 6, 20);
        DocumentoIdentidad documentoIdentidad1 = new DocumentoIdentidad("87654321A", fechaNacimiento1, "Mario", "Rossi", "Bianchi");
        PasajeroMayorEdad pasajeroMario = Registro.registrarPasajeroMayorEdad(documentoIdentidad1, "mariorossi@example.com", "Password_123@");
        System.out.println("\nInformación del pasajero adulto Mario:\n");
        System.out.println(pasajeroMario);

        LocalDate fechaNacimiento2 = LocalDate.of(1980, 3, 15);
        DocumentoIdentidad documentoIdentidad2 = new DocumentoIdentidad("98765432C", fechaNacimiento2, "Sara", "Bianchi", "Verdi");
        PasajeroMayorEdad pasajeraSara = Registro.registrarPasajeroMayorEdad(documentoIdentidad2, "sarabianchi@example.com", "#PasswOrd8@9");
        pasajeraSara.addNecesidadEspecial(necesidad_silla_ruedas); // Añadir la necesidad especial al pasajero
        System.out.println("\nInformación de la pasajera adulto Sara con Necesidad Especial de silla de ruedas:\n");
        System.out.println(pasajeraSara);
        System.out.println();

        // Lista de pasajeros que vayan a volar
        List<Pasajero> listaPasajeros = new ArrayList<>(Arrays.asList(pasajeroMario, pasajeraSara));

        // Crear equipajes
        Equipaje equipaje1 = new Equipaje(IdEquipaje.DE_MANO, "Maleta de mano 1", 10.0); // (Precio = 0)
        Equipaje equipaje2 = new Equipaje(IdEquipaje.DE_MANO, "Maleta de mano 2", 8.0); // (Precio = 0)
        Equipaje equipaje3 = new Equipaje(IdEquipaje.FACTURADO, "Equipo de esquí", 25.0, 40.0);

        // Lista de equipajes del vuelo
        List<Equipaje> listaEquipajes = new ArrayList<>(Arrays.asList(equipaje1, equipaje2, equipaje3));

        // Crear billetes asociados a cada Trayecto del Vuelo. En este caso al ser un Vuelo de una sola dirección y con 
        // 1 solo Trayecto solo se necesitan 2 billetes:
        Billete billete_business1 = new Billete(IdBillete.BUSINESS, vuelo_rom_par.getAsientosDisponibles().get(30), tray_rom_par, documentoIdentidad1);
        Billete billete_business2 = new Billete(IdBillete.BUSINESS, vuelo_rom_par.getAsientosDisponibles().get(31), tray_rom_par, documentoIdentidad2);

        // Lista de billetes
        List<Billete> listaBilletes = new ArrayList<>(Arrays.asList(billete_business1, billete_business2));

        // Definimos el MetodoPago que se va a utilizar para reservar:
        TarjetaCredito tarjetaCredito_juan = new TarjetaCredito("1234-5678-9012-3456", 123, "12/25", 800);
            
        // Iniciar sesión con el pasajero que vaya a realizar la reserva
        pasajeroMario.iniciarSesion("mariorossi@example.com", "Password_123@");

        // Realizar reserva con Mario por ejemplo
        pasajeroMario.realizar_reserva(listaPasajeros, listaEquipajes, listaBilletes, vuelo_rom_par, tarjetaCredito_juan);
        
        // Juan accede a sus Reservas realizadas:
        System.out.println("\nReservas realizadas por Mario:");
        System.out.println(pasajeroMario.getReservasRealizadas());

        // Como paso opcional, se puede cerrar sesión:
        pasajeroMario.cerrarSesion();
    }
}
