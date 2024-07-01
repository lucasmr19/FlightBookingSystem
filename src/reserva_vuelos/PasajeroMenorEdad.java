package reserva_vuelos;

public class PasajeroMenorEdad extends Pasajero {

    protected PasajeroMayorEdad persona_responsable_menor = null;

    // Contructor para pasajero menor de edad (se establece un objeto Pasajero responsable y solo necesita poner su DocumentoIdentidad)
    // Si además es menor a 2 años, entonces no paga el vuelo.
    protected PasajeroMenorEdad(DocumentoIdentidad id_pasajero, PasajeroMayorEdad pasajeroResponsable) throws IllegalAccessError {
        int edad = id_pasajero.getEdad();
        if (edad < 18) {
            this.id_pasajero = id_pasajero;
            this.persona_responsable_menor = pasajeroResponsable; // Se le debe asignar un responsable si es menor de edad
        } else {
            throw new IllegalAccessError("El pasajero debe ser menor de edad para asignarle alguien a su cargo.");
        }
    }

    protected PasajeroMenorEdad(){};

    public PasajeroMayorEdad getPersonaResponsableMenor() {
        return this.persona_responsable_menor;
    }

    @Override
    public String toString() {
        return "PasajeroMenorEdad(" +
                "identificación = " + this.id_pasajero +
                ", persona_responsable = " + this.persona_responsable_menor +
                ", necesidades_especiales = " + this.necesidades_especiales +
                ')';
    }

}
