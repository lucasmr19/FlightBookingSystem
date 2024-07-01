import java.time.LocalDate;
import java.time.LocalDateTime;
import reserva_vuelos.*;

public class MainEx2 {
    public static void main(String[] args) {
        System.out.println("\nMain para el patrón observer sobre Pasajeros interesados en un Vuelo:");
        System.out.println("---------------------------------------------\n");

        // Crear ubicaciones para los aeropuertos
        Location romaLocation = new Location(41.795584265826164, 12.255006453044356); // Aeropuerto de Roma Fiumicino
        Location parisLocation = new Location(49.005387127395984, 2.5804610047188876); // Aeropuerto de París Charles de Gaulle

        // Crear aeropuertos
        Aeropuerto romaAirport = new Aeropuerto("FCO", "Aeropuerto de Roma Fiumicino", romaLocation);
        Aeropuerto parisAirport = new Aeropuerto("CDG", "Aeropuerto de París Charles de Gaulle", parisLocation);

        // Crear Aerolínea(s)
        String aerolinea_alitalia_nombre = "Alitalia";
        Aerolinea alitalia = new Aerolinea(121, aerolinea_alitalia_nombre);

        // Crear Avión
        double capacidad_max_carga = 100000; // Capacidad máxima de carga en kg
        double precio_base_asientos = 8; // Precio base de los asientos en la moneda local
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

        // Crear los pasajeros:
        LocalDate fechaNacimiento1 = LocalDate.of(1988, 6, 20);
        DocumentoIdentidad documentoIdentidad1 = new DocumentoIdentidad("51659021A", fechaNacimiento1, "Mario", "Sanchez", "Pérez");
        PasajeroMayorEdad pasajeroMario = Registro.registrarPasajeroMayorEdad(documentoIdentidad1, "marioXX_delpino@gmail.com", "Password_123@");

        LocalDate fechaNacimiento2 = LocalDate.of(1980, 3, 15);
        DocumentoIdentidad documentoIdentidad2 = new DocumentoIdentidad("90565932C", fechaNacimiento2, "Sara", "Lopez", "Ruiz");
        PasajeroMayorEdad pasajeraSara = Registro.registrarPasajeroMayorEdad(documentoIdentidad2, "saralpzr@hotmail.com", "#PasswOrd8@9");
        pasajeraSara.addNecesidadEspecial(necesidad_silla_ruedas); // Añadir la necesidad especial al pasajero

        LocalDate fechaNacimiento3 = LocalDate.of(1980, 3, 15);
        DocumentoIdentidad documentoIdentidad3 = new DocumentoIdentidad("46509312C", fechaNacimiento3, "Luis", "Valdivia", "Bravo");
        PasajeroMayorEdad pasajeroLuis = Registro.registrarPasajeroMayorEdad(documentoIdentidad3, "saralpzr@hotmail.com", "paSswOrD@8#2");

        
        // Ahora si, la parte del patrón observer quedaría así:
        // Añadir los observadores del sujeto:
        vuelo_rom_par.addObservador(pasajeroMario);
        vuelo_rom_par.addObservador(pasajeraSara);
        vuelo_rom_par.addObservador(pasajeroLuis);


        // Pasar como referencia el Sujeto a cada ConcreteObserver (Pasajero), 
        // esto es lo mismo que si se pasase al constructor de Pasajero, que es la manera típica de hacer esto
        pasajeroMario.recibirNotificaciones(vuelo_rom_par);
        pasajeraSara.recibirNotificaciones(vuelo_rom_par);
        pasajeroLuis.recibirNotificaciones(vuelo_rom_par);
        // Simular cambios en el estado del vuelo y la puerta de embarque y ver como se imprimen en pantalla las notificaciones:
        // Notificaciones para los Pasajeros (Clientes) del sistema
        vuelo_rom_par.setEstado(EstadoVuelo.CHECK_IN_EN_LINEA_DISPONIBLE);
        vuelo_rom_par.setEstado(EstadoVuelo.CHECK_IN_PRESENCIAL_DISPONIBLE);
        vuelo_rom_par.setEstado(EstadoVuelo.EMBARQUE_ABIERTO);
        vuelo_rom_par.removeObservador(pasajeroLuis); // El pasajro Luis ya no recibirá notificaciones del estado del Vuelo
        // Se cambian varias veces las puertas de embarque mientras esté abierto:
        vuelo_rom_par.setPuertaEmbarque(11);
        vuelo_rom_par.setPuertaEmbarque(12); 
        vuelo_rom_par.setPuertaEmbarque(13);
        vuelo_rom_par.setEstado(EstadoVuelo.AVISO_DE_CIERRE_DE_EMBARQUE_CERCANO);
        vuelo_rom_par.setEstado(EstadoVuelo.EMBARQUE_CERRADO);
        vuelo_rom_par.setEstado(EstadoVuelo.VUELO_RETRASADO);
        vuelo_rom_par.setEstado(EstadoVuelo.VUELO_EN_CURSO);

    }
}
