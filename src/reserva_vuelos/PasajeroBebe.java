package reserva_vuelos;

public class PasajeroBebe extends PasajeroMenorEdad {

    protected PasajeroBebe(DocumentoIdentidad id_pasajero, PasajeroMayorEdad pasajeroResponsable) throws IllegalAccessError {
        int edad = id_pasajero.getEdad();
        if (edad < 18) {
            this.id_pasajero = id_pasajero;
            this.persona_responsable_menor = pasajeroResponsable; // Se le debe asignar un responsable si es menor de edad
        } else {
            throw new IllegalAccessError("El pasajero debe ser menor de edad para asignarle alguien a su cargo.");
        }
    }

    @Override
    public String toString() {
        return "PasajeroBebe(" +
                "identificación = " + this.id_pasajero +
                ", persona_responsable = " + this.persona_responsable_menor +
                ", necesidades_especiales = " + this.necesidades_especiales +
                ')';
    }
}
