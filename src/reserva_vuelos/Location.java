package reserva_vuelos;

// Clase para saber la ubicación exacta de cada Aeropuerto. También calcula distancia entre 2 objetos Location.

public class Location {
    private double longitude;
    private double latitude;

    // create and initialize a point with given name and
    // (latitude, longitude) specified in degrees
    public Location(double latitude, double longitude) {
        this.latitude  = latitude;
        this.longitude = longitude;
    }

    // return distance between this location and that location
    // measured in kilometers
    protected double distanceTo(Location that) {
        double KILOMETERS_PER_NAUTICAL_MILE = 1.852;
        double lat1 = Math.toRadians(this.latitude);
        double lon1 = Math.toRadians(this.longitude);
        double lat2 = Math.toRadians(that.latitude);
        double lon2 = Math.toRadians(that.longitude);

        // great circle distance in radians, using law of cosines formula
        double angle = Math.acos(Math.sin(lat1) * Math.sin(lat2)
                               + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));

        // each degree on a great circle of Earth is 60 nautical miles
        double nauticalMiles = 60 * Math.toDegrees(angle);

        // transform to kilometers
        double kilometers = KILOMETERS_PER_NAUTICAL_MILE * nauticalMiles;
        return kilometers;
    }

    public String toString() {
        return "(" + latitude + ", " + longitude + ")";
    }

    public static void main(String[] args) {
        Location loc1 = new Location(40.46841660530431, -3.57097186057403); // Aeropuerto Madrid-Barajas
        Location loc2 = new Location(-33.93979045611595, 151.17542733955472); // Aeropuerto Sydney
        double distance = loc1.distanceTo(loc2);
        System.out.printf("%6.3f kilometers of distance\n", distance);
    }
}

