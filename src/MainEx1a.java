import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import reserva_vuelos.*;

public class MainEx1a {
    public static void main(String[] args) {
        System.out.println("Main para el primer caso:");
        System.out.println("-----------------------------------");

        // Crear ubicaciones para los aeropuertos
        Location madridLocation = new Location(40.49228276663479, -3.5934901824518133); // Localización Aeropuerto Madrid-Barajas
        Location sydneyLocation = new Location(-33.93642483779725, 151.16621061506456); // Localización Aeropuerto Sydney
        Location dubaiLocation = new Location(25.24368509471394, 55.360617825564404); // Localización Aeropuerto Dubai

        // Crear aeropuertos
        Aeropuerto madridAirport = new Aeropuerto("MAD", "Aeropuerto de Madrid-Barajas Adolfo Suárez", madridLocation);
        Aeropuerto sydneyAirport = new Aeropuerto("SYD", "Aeropuerto de Sydney Kingsford Smith", sydneyLocation);
        Aeropuerto dubaiAirport = new Aeropuerto("DXB", "Aeropuerto Internacional de Dubái", dubaiLocation);

        // Calcular y mostrar la distancia entre Aeropuertos: (Opcional)
        double distancia1 = madridAirport.calcularDistancia(dubaiAirport);
        double distancia2 = dubaiAirport.calcularDistancia(sydneyAirport);
        double distancia = distancia1 + distancia2;
        System.out.println("\nDistancia entre el Aeropuerto de Madrid y el Aeropuerto de Sydney, haciendo escala en Dubái: " + distancia + " km\n");

        // Crear Aerolíneas
        String aerolinea_iberia_nombre = "Iberia";
        String aerolinea_emirates_nombre = "Emirates";
        Aerolinea iberia = new Aerolinea(075, aerolinea_iberia_nombre);
        Aerolinea emirates = new Aerolinea(13, aerolinea_emirates_nombre);


        // Crear Aviones:
        // Todos los Aviones de un Vuelo, por coherencia, deben tener los mismos valores de los siguientes atributos:
        double capacidad_max_carga = 100000; // Capacidad máxima de carga en kg
        double precio_base_asientos = 7; // Precio base de los asientos en la moneda local
        int num_asientos_delanteros = 21;
        int num_asientos_normales = 225;
        int num_asientos_grandes = 18;
        int num_primera_clases_ofrecidas = 10;
        int num_business_ofrecidas = 20;
        int num_turista_ofrecidas = 234;

        // 1. Avion que va de Barajas a Dubai (y viceversa) con Iberia
        Avion airbus_330 = new Avion(137, "A330", capacidad_max_carga, precio_base_asientos, num_asientos_delanteros, num_asientos_normales,
        num_asientos_grandes,num_primera_clases_ofrecidas,num_business_ofrecidas,num_turista_ofrecidas);
        airbus_330.setNombreAerolinea(aerolinea_iberia_nombre);

        // 2. Avion que va de Dubai a Sydney (y viceversa) con Emirates
        Avion boeing_777 = new Avion(39, "777", capacidad_max_carga, precio_base_asientos, num_asientos_delanteros, num_asientos_normales,
        num_asientos_grandes,num_primera_clases_ofrecidas,num_business_ofrecidas,num_turista_ofrecidas);
        boeing_777.setNombreAerolinea(aerolinea_emirates_nombre);

        //System.out.println("airbus_330 = " + airbus_330.getListaAsientos());


        // Crear 2 Vuelos de ida = VueloIdaVuelta:
        //Fechas de salida y llegada del 1er trayecto:
        LocalDateTime fecha_salida1 = LocalDateTime.of(2024,4, 15, 10, 30);
        LocalDateTime fecha_llegada1 = LocalDateTime.of(2024, 4, 16, 8, 0); 
        
        Trayecto tray_mad_dub = new Trayecto(fecha_salida1, fecha_llegada1, madridAirport, dubaiAirport, airbus_330, 4, 3);
        // Añadir el Trayecto a la lista de Trayectos Programados para cada Avion.
        // IMPORTANTE: Mirar la nota en el método toString de la clase Avion sobre como manejar estos objetos.
        airbus_330.addTrayecto(tray_mad_dub);
        tray_mad_dub.setAvion(airbus_330);

        // Fechas de salida y llegada del 2do trayecto
        LocalDateTime fecha_salida2 = LocalDateTime.of(2024, 4, 15, 18, 0);
        LocalDateTime fecha_llegada2 = LocalDateTime.of(2024, 4, 15, 21, 0);

        Trayecto tray_dub_syd = new Trayecto(fecha_salida2, fecha_llegada2, dubaiAirport, sydneyAirport, boeing_777, 3, 1);        
        boeing_777.addTrayecto(tray_dub_syd);
        tray_dub_syd.setAvion(boeing_777);

        // Crear el objeto VueloUnidireccional
        VueloUnidireccional vuelo_ida_mad_syd = new VueloUnidireccional("MAD-DUB-SYD", 127.2);

        // Añadir los correspondientes trayectos al vuelo:
        vuelo_ida_mad_syd.addTrayecto(tray_mad_dub);
        vuelo_ida_mad_syd.addTrayecto(tray_dub_syd);

        // Repetir el proceso pero para la vuelta, añadiendo nuevas fechas y cambiando el orden de los aeropuertos, terminales, etc:

        LocalDateTime fecha_salida_vuelta1 = LocalDateTime.of(2024, 4, 20, 10, 30);
        LocalDateTime fecha_llegada_vuelta1 = LocalDateTime.of(2024, 4, 21, 8, 0);
        
        Trayecto tray_syd_dub_vuelta = new Trayecto(fecha_salida_vuelta1, fecha_llegada_vuelta1, sydneyAirport, dubaiAirport, boeing_777, 1, 3);
        boeing_777.addTrayecto(tray_syd_dub_vuelta);
        tray_syd_dub_vuelta.setAvion(boeing_777);

        LocalDateTime fecha_salida_vuelta2 = LocalDateTime.of(2024, 4, 24, 18, 0);
        LocalDateTime fecha_llegada_vuelta2 = LocalDateTime.of(2024, 4, 24, 21, 0);
        
        Trayecto tray_dub_mad_vuelta = new Trayecto(fecha_salida_vuelta2, fecha_llegada_vuelta2, dubaiAirport, madridAirport, airbus_330, 3, 4);
        airbus_330.addTrayecto(tray_dub_mad_vuelta);
        tray_dub_mad_vuelta.setAvion(airbus_330);

        VueloUnidireccional vuelo_vuelta_mad_syd = new VueloUnidireccional("SYD-DUB-MAD", 123); // Véase que no tiene porque coincidir ni la ID ni el precio

        vuelo_vuelta_mad_syd.addTrayecto(tray_syd_dub_vuelta);
        vuelo_vuelta_mad_syd.addTrayecto(tray_dub_mad_vuelta);

        VueloIdaVuelta vuelo_mad_syd = new VueloIdaVuelta(vuelo_ida_mad_syd, vuelo_vuelta_mad_syd);

        // Añadir aviones a sus aerolíneas
        iberia.addAvion(airbus_330);
        emirates.addAvion(boeing_777);

        // Información de las Aerolineas:
        System.out.println("\nInformación de la Aerolinea Iberia:\n");
        System.out.println(iberia);

        System.out.println("\nInformación de la Aerolinea Emirates:\n");
        System.out.println(emirates);

        // Crear los pasajeros:
        // 2 son adultos (matrimonio en este caso): 
        LocalDate fechaNacimientoMayor = LocalDate.of(1990, 3, 20);
        DocumentoIdentidad documentoIdentidadMayor = new DocumentoIdentidad("87654321A", fechaNacimientoMayor, "Juan", "García", "López");
        PasajeroMayorEdad pasajeroJuan = Registro.registrarPasajeroMayorEdad(documentoIdentidadMayor, "juangarcia@example.com", "PasS_word@123");
        System.out.println("\nInformación del pasajero adulto Juan:\n");
        System.out.println(pasajeroJuan);

        LocalDate fechaNacimientoOtro = LocalDate.of(1985, 7, 10);
        DocumentoIdentidad documentoIdentidadOtro = new DocumentoIdentidad("13579246B", fechaNacimientoOtro, "Ana", "Rodríguez", "Gómez");
        PasajeroMayorEdad pasajeraAna = Registro.registrarPasajeroMayorEdad(documentoIdentidadOtro, "anarodriguez@example.com", "PasWord_456");
        System.out.println("\nInformación de la pasajera adulta Ana:\n");
        System.out.println(pasajeraAna);

        // El 3ero es un bebé menor de edad que no paga (no se le asigna billete)
        LocalDate fechaNacimientoMenor = LocalDate.of(2023, 6, 15); // Menor de 2 años
        DocumentoIdentidad documentoIdentidadMenor = new DocumentoIdentidad("12345678Z", fechaNacimientoMenor, "María", "García", "Rodríguez");
        PasajeroBebe pasajeraMaria = Registro.registrarPasajeroBebe(documentoIdentidadMenor, pasajeroJuan); // Necesita el DNI para registrarse y la persona a su cargo
        System.out.println("\nInformación del pasajero menor María:\n");
        System.out.println(pasajeraMaria);
        System.out.println();

        // Declarar el equipaje que van a llevar:
        Equipaje equipaje1 = new Equipaje(IdEquipaje.DE_MANO, "Bolso", 5.0); // (Precio = 0)
        Equipaje equipaje2 = new Equipaje(IdEquipaje.FACTURADO, "Maleta grande 1", 25.0, 25.0);
        Equipaje equipaje3 = new Equipaje(IdEquipaje.DE_MANO, "Maleta grande 2", 23.0, 23.0);
        Equipaje equipaje4 = new Equipaje(IdEquipaje.ESPECIAL, "Carrito de bebé", 15.0, 10.0);

        // Crear billetes para cada trayecto del vuelo. En este caso hay 4 trayectos en total, y como son 2 pasajeros que pagan habrá 8 billetes.
        Billete billete_turista1_mad_dub = new Billete(IdBillete.TURISTA, vuelo_mad_syd.getAsientosDisponibles().get(10), tray_mad_dub, documentoIdentidadMayor);
        Billete billete_turista2_mad_dub = new Billete(IdBillete.TURISTA, vuelo_mad_syd.getAsientosDisponibles().get(11), tray_mad_dub, documentoIdentidadOtro);
        
        Billete billete_turista1_dub_syd = new Billete(IdBillete.TURISTA, vuelo_mad_syd.getAsientosDisponibles().get(10), tray_dub_syd, documentoIdentidadMayor);
        Billete billete_turista2_dub_syd = new Billete(IdBillete.TURISTA, vuelo_mad_syd.getAsientosDisponibles().get(11), tray_dub_syd, documentoIdentidadOtro);

        Billete billete_turista1_syd_dub = new Billete(IdBillete.TURISTA, vuelo_mad_syd.getAsientosDisponibles().get(10), tray_syd_dub_vuelta, documentoIdentidadMayor);
        Billete billete_turista2_syd_dub = new Billete(IdBillete.TURISTA, vuelo_mad_syd.getAsientosDisponibles().get(11), tray_syd_dub_vuelta, documentoIdentidadOtro);
        
        Billete billete_turista1_dub_mad = new Billete(IdBillete.TURISTA, vuelo_mad_syd.getAsientosDisponibles().get(10), tray_dub_mad_vuelta, documentoIdentidadMayor);
        Billete billete_turista2_dub_mad = new Billete(IdBillete.TURISTA, vuelo_mad_syd.getAsientosDisponibles().get(11), tray_dub_mad_vuelta, documentoIdentidadOtro);
        
        // Crear las listas de pasajeros, equipajes y billetes
        List<Pasajero> listaPasajeros = new ArrayList<Pasajero>(Arrays.asList(pasajeroJuan, pasajeraAna, pasajeraMaria));
        List<Equipaje> listaEquipajes = new ArrayList<Equipaje>(Arrays.asList(equipaje1, equipaje2, equipaje3, equipaje4));
        List<Billete> listaBilletes = new ArrayList<Billete>(Arrays.asList(billete_turista1_mad_dub, billete_turista2_mad_dub,
        billete_turista1_dub_syd, billete_turista2_dub_syd, billete_turista1_syd_dub, billete_turista2_syd_dub, billete_turista1_dub_mad,
        billete_turista2_dub_mad));


        // Definimos el MetodoPago que se va a utilizar para reservar:
        TarjetaCredito tarjetaCredito_juan = new TarjetaCredito("1234-5678-9012-3456", 123, "12/25", 800);

        // El pasajero que realiza la reserva (Juan, por ejemplo) debe iniciar sesión con su correo y contraseña:
        pasajeroJuan.iniciarSesion("juangarcia@example.com", "PasS_word@123");

        //Juan realiza la reserva:
        pasajeroJuan.realizar_reserva(listaPasajeros, listaEquipajes, listaBilletes, vuelo_mad_syd, tarjetaCredito_juan);

        // Juan accede a sus Reservas realizadas:
        System.out.println("\nInformación de las Reservas realizadas por Juan:");
        System.out.println(pasajeroJuan.getReservasRealizadas());

        // Como paso opcional, puede cerrar sesión:
        pasajeroJuan.cerrarSesion();
    }
}

