package reserva_vuelos;

public class Aeropuerto {
    private String id_IATA;
    private String nombre;
    private Location location;

    public Aeropuerto(String id_IATA, String nombre, Location location){
        this.id_IATA = id_IATA;
        this.nombre = nombre;
        this.location = location;
    }

    public double calcularDistancia(Aeropuerto otroAeropuerto) { // Calcula la distancia entre dos aeropuertos
        return this.location.distanceTo(otroAeropuerto.location);
    }

    // Método toString para imprimir
    @Override
    public String toString() {
        return "Aeropuerto(IATA = " + this.id_IATA +
               ", Nombre = " + this.nombre +
               ", Ubicación = " + this.location + ")";
    }

    public static void main(String[] args) {
        // Crear ubicaciones para los aeropuertos
        Location madridLocation = new Location(40.46841660530431, -3.57097186057403); // Aeropuerto Madrid-Barajas
        Location sydneyLocation = new Location(-33.93979045611595, 151.17542733955472); // Aeropuerto Sydney

        // Crear aeropuertos
        Aeropuerto madridAirport = new Aeropuerto("MAD", "Aeropuerto de Madrid-Barajas Adolfo Suárez", madridLocation);
        Aeropuerto sydneyAirport = new Aeropuerto("SYD", "Aeropuerto de Sydney Kingsford Smith", sydneyLocation);

        // Imprimir información de los aeropuertos
        System.out.println("Información del Aeropuerto de Madrid:");
        System.out.println(madridAirport);

        System.out.println("\nInformación del Aeropuerto de Sydney:");
        System.out.println(sydneyAirport);

        // Calcular y mostrar la distancia entre los dos aeropuertos
        double distancia = madridAirport.calcularDistancia(sydneyAirport);
        System.out.println("\nDistancia entre el Aeropuerto de Madrid y el Aeropuerto de Sydney: " + distancia + " km");
    }
}
