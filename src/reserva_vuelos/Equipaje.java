package reserva_vuelos;

public class Equipaje {
    private IdEquipaje idEquipaje;
    private String nombreEquipaje;
    private String descripcionEquipaje = "No se ha proporcionado descripción";
    private double pesoEquipaje;
    private double precioEquipaje;

    // Constructor
    public Equipaje(IdEquipaje idEquipaje, String nombreEquipaje, String descripcionEquipaje, double pesoEquipaje, double precioEquipaje) throws IllegalArgumentException {
        this.idEquipaje = idEquipaje;
        this.nombreEquipaje = nombreEquipaje;
        this.descripcionEquipaje = descripcionEquipaje;
        this.pesoEquipaje = pesoEquipaje;
        this.precioEquipaje = precioEquipaje;
        
        // Establecer precio a 0 si el idEquipaje es DE_MANO
        if (idEquipaje == IdEquipaje.DE_MANO && precioEquipaje != 0) {
            throw new IllegalArgumentException("Si el equipaje es de mano el precio debe ser 0!");
        }
    }

    // Constructor sin precio (para equipaje de mano)
    public Equipaje(IdEquipaje idEquipaje, String nombreEquipaje, double pesoEquipaje) {
        this.idEquipaje = idEquipaje;
        this.nombreEquipaje = nombreEquipaje;
        this.pesoEquipaje = pesoEquipaje;
        
        // Establecer precio a 0 si el idEquipaje es DE_MANO
        if (idEquipaje == IdEquipaje.DE_MANO) {
            this.precioEquipaje = 0.0;
        }
    }

    // Constructor sin precio (para equipaje de mano)
    public Equipaje(IdEquipaje idEquipaje, String nombreEquipaje, String descripcionEquipaje, double pesoEquipaje) {
        this.idEquipaje = idEquipaje;
        this.nombreEquipaje = nombreEquipaje;
        this.descripcionEquipaje = descripcionEquipaje;
        this.pesoEquipaje = pesoEquipaje;
        
        // Establecer precio a 0 si el idEquipaje es DE_MANO
        if (idEquipaje == IdEquipaje.DE_MANO) {
            this.precioEquipaje = 0.0;
        }
    }

    // Constructor con sobrecarga para que la descripción sea opcional
    public Equipaje(IdEquipaje idEquipaje, String nombreEquipaje, double pesoEquipaje, double precioEquipaje) {
        this.idEquipaje = idEquipaje;
        this.nombreEquipaje = nombreEquipaje;
        this.pesoEquipaje = pesoEquipaje;
        this.precioEquipaje = precioEquipaje;
    }

    // Getters
    public IdEquipaje getId() {
        return idEquipaje;
    }

    public String getNombre() {
        return nombreEquipaje;
    }

    public String getDescripcion() {
        return descripcionEquipaje;
    }

    public double getPeso() {
        return pesoEquipaje;
    }

    public double getPrecio() {
        return precioEquipaje;
    }

    // Método toString para imprimir
    @Override
    public String toString() {
        return "Equipaje(id = " + idEquipaje +
               ", nombre = " + nombreEquipaje +
               ", descripcion = " + descripcionEquipaje +
               ", peso = " + pesoEquipaje +
               ", precio = " + precioEquipaje +
               ")";
    }

    public static void main(String[] args) {
        // Crear tipos de equipaje y mostrar su información
        
        Equipaje equipaje1 = new Equipaje(IdEquipaje.DE_MANO, "Bolso", 5.0, 0.0);
        Equipaje equipaje2 = new Equipaje(IdEquipaje.FACTURADO, "Maleta grande", 20.0, 25.0);
        Equipaje equipaje3 = new Equipaje(IdEquipaje.ESPECIAL, "Bicicleta", 10.0, 50.0);

        System.out.println("Información del equipaje 1:");
        System.out.println(equipaje1);

        System.out.println("\nInformación del equipaje 2:");
        System.out.println(equipaje2);

        System.out.println("\nInformación del equipaje 3:");
        System.out.println(equipaje3);
    }
}