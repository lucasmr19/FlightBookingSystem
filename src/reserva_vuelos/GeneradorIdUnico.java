package reserva_vuelos;

import java.util.UUID;

public class GeneradorIdUnico {
    public static String generarIdUnico() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
