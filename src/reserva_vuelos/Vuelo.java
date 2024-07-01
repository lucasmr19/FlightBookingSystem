package reserva_vuelos;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
//import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


// Clase abstracta:
public abstract class Vuelo implements ISujeto {
    // Atributos
    protected String id_vuelo;
    protected double precio_vuelo; 
    protected double carga_vuelo = 0.0;
    protected EstadoVuelo estadoVuelo; // Varía con el tiempo
    protected int puertaEmbarque; // Varía con el tiempo
    protected List<Trayecto> trayectos = new ArrayList<Trayecto>();
    protected int num_primera_clase_reservadas = 0; // Pasajeros con billetes de tipo primera clase actuales en el Vuelo
    protected int num_business_reservadas = 0; // Pasajeros con billetes de tipo business en el Vuelo
    protected int num_turista_reservadas = 0; // Pasajeros con billetes de tipo turista en el Vuelo
    protected List<Asiento> asientosReservados = new ArrayList<Asiento>(); // Asientos reservados en el Vuelo
    protected List <Asiento> asientosDisponibles = new ArrayList<Asiento>(); // Asientos disponibles en el Vuelo
    protected List<IObservador> pasajeros_vuelo = new ArrayList<>(); // Referencia a los Observadores

    // Getters
    public String getId() {
        return this.id_vuelo;
    }

    public double getPrecio() {
        return this.precio_vuelo;
    }

    public double getCargaVuelo() {
        return this.carga_vuelo;
    }

    // Num pasajeros totales
    public int getNumPasajeros() {
        return this.num_primera_clase_reservadas + this.num_business_reservadas + this.num_turista_reservadas;
    }

    // Devuelve la lista de los Aviones de este Vuelo, puede haber 1..*
    public List<Avion> getAvionesVuelo() {
        List<Avion> avionesVuelo = new ArrayList<>();
        for (Trayecto trayecto : trayectos) {
            avionesVuelo.add(trayecto.getAvion());
        }
        return avionesVuelo;
    }
    

    public int getNumPrimeraClaseReservadas() {
        return this.num_primera_clase_reservadas;
    }

    public int getNumBusinessReservadas() {
        return this.num_business_reservadas;
    }

    public int getNumTuristaReservadas() {
        return this.num_turista_reservadas;
    }

    public List<Trayecto> getTrayectos() {
        return this.trayectos;
    }

    public List<Asiento> getAsientosReservados() {
        return this.asientosReservados;
    }

    public EstadoVuelo getEstado() {
        return this.estadoVuelo;
    }

    public int getPuertaEmbarque(){
        return this.puertaEmbarque;
    }  
    
    
    public void removeTrayecto(Trayecto trayecto){
        this.trayectos.remove(trayecto);
    }
    
    public void removeTrayectos(List<Trayecto> trayectos){
        this.trayectos.removeAll(trayectos);
    }    

    // Métodos de incremento, decremento y setters

    // Nos aseguramos de que haya espacio en el Vuelo para los asientos en la clase DisponibilidadReserva a la hora de realizar una reserva.
    protected void incrementNumPrimeraClaseReservadas(int cantidad) {
        this.num_primera_clase_reservadas += cantidad;
    }    
    

    protected void decrementNumPrimeraClaseReservadas(int cantidad) {
        this.num_primera_clase_reservadas -= cantidad;
    }

    protected void incrementNumBusinessReservadas(int cantidad) {
        this.num_business_reservadas += cantidad;
    }
    
    protected void decrementNumBusinessReservadas(int cantidad) {
        this.num_business_reservadas -= cantidad;
    }
    
    protected void incrementNumTuristaReservadas(int cantidad) {
        this.num_turista_reservadas += cantidad;
    }
    
    protected void decrementNumTuristaReservadas(int cantidad) {
        this.num_turista_reservadas -= cantidad;
    }

    protected void incrementCargaVuelo(double carga) {
        this.carga_vuelo += carga;
    }    

    // Métodos para reservar asiento(s)
    public void reservarAsiento(Asiento asiento){
        this.asientosReservados.add(asiento);
        this.asientosDisponibles.remove(asiento);
    }

    public void reservarAsientos(List<Asiento> asientos){
        this.asientosReservados.addAll(asientos);
        this.asientosDisponibles.removeAll(asientos);
    }

    // Método para calcular la duración total del vuelo, suponiendo que los trayectos están ordenados por fechas
    protected Duration calculateDuration() {
        if (this.trayectos.isEmpty()) {
            return Duration.ZERO;
        }
        // Sino estuviesen ordenados o bien a la hora de introducir un nuevo trayecto se utiliza un algoritmo de inserción (para mantener un orden) o
        // bien se ordena la lista de trayectos en este método antes de calcular la duración. Se podría hacer algo así:
        //Collections.sort(trayectos, (t1, t2) -> t1.getFechaSalida().compareTo(t2.getFechaSalida()));

        Trayecto primerTrayecto = trayectos.get(0);
        Trayecto ultimoTrayecto = trayectos.get(trayectos.size() - 1);

        return Duration.between(primerTrayecto.getFechaSalida(), ultimoTrayecto.getFechaLlegada());
    }

    // Cuando se cambie el Estado del Vuelo, se notifica automáticamente a los Observadores:
    public void setEstado(EstadoVuelo estadoVuelo){
        this.estadoVuelo = estadoVuelo;
        notificar();
    }

    // Cuando se cambie la puerta de embarque, se notifica automáticamente a los Observadores
    public void setPuertaEmbarque(int puertaEmbarque){
        this.puertaEmbarque = puertaEmbarque;
        notificar();
    }

    // Añadir y quitar al Observador de las notificaciones del Vuelo:
    @Override
    public void addObservador(IObservador observador) {
        System.out.println("El pasajero con identificación = " + ((Pasajero) observador).getId() + " se ha suscrito a" +
                            " las notificaciones de este vuelo\n"); 
        this.pasajeros_vuelo.add(observador);
    }

    @Override
    public void removeObservador(IObservador observador) {
        System.out.println("El pasajero con identificación = " + ((Pasajero) observador).getId() + " se ha dado de baja de" +
                            " las notificaciones de este vuelo\n"); 
        this.pasajeros_vuelo.remove(observador);
    }

    @Override
    public void notificar() {
        // Notificar a los observadores sobre el cambio de estado del vuelo
        for (IObservador observador : this.pasajeros_vuelo) {
            observador.actualizar();
        }
    }

    // Método para ejecutar en segundo plano que a las horas establecidas, antes de la salida de un Vuelo va cambiando su Estado
    public void verificarEstadoYEnviarNotificaciones() {
        Timer timer = new Timer();
    
        // Tarea para cambiar el estado a CHECK_IN_EN_LINEA_DISPONIBLE
        TimerTask taskCheckInLinea = new TimerTask() {
            @Override
            public void run() {
                Vuelo.this.setEstado(EstadoVuelo.CHECK_IN_EN_LINEA_DISPONIBLE);
            }
        };
    
        // Tarea para cambiar el estado a CHECK_IN_PRESENCIAL_DISPONIBLE
        TimerTask taskCheckInPresencial = new TimerTask() {
            @Override
            public void run() {
                Vuelo.this.setEstado(EstadoVuelo.CHECK_IN_PRESENCIAL_DISPONIBLE);
            }
        };
    
        // Tarea para cambiar el estado a EMBARQUE_ABIERTO
        TimerTask taskEmbarqueAbierto = new TimerTask() {
            @Override
            public void run() {
                Vuelo.this.setEstado(EstadoVuelo.EMBARQUE_ABIERTO);
            }
        };
    
        // Tarea para cambiar el estado a AVISO_DE_CIERRE_DE_EMBARQUE_CERCANO
        TimerTask taskAvisoCierreCercanoEmbarque = new TimerTask() {
            @Override
            public void run() {
                Vuelo.this.setEstado(EstadoVuelo.AVISO_DE_CIERRE_DE_EMBARQUE_CERCANO);
                timer.cancel(); // En la última tarea, detener el timer
            }
        };
    
        // Establecer las horas deseadas para cada tarea
        LocalDateTime fecha_salida_vuelo = this.trayectos.get(0).getFechaSalida();
        LocalDateTime hora_checkin_en_linea = fecha_salida_vuelo.minusDays(1);
        LocalDateTime hora_checkin_presencial = fecha_salida_vuelo.minusHours(3);
        LocalDateTime embarque_abierto = fecha_salida_vuelo.minusMinutes(30);
        LocalDateTime aviso_cierre_cercano_embarque = fecha_salida_vuelo.minusMinutes(10);
    
        // Convertir los LocalDateTime a Calendar
        Calendar scheduledTimeCheckInLinea = toCalendar(hora_checkin_en_linea);
        Calendar scheduledTimeCheckInPresencial = toCalendar(hora_checkin_presencial);
        Calendar scheduledTimeEmbarqueAbierto = toCalendar(embarque_abierto);
        Calendar scheduledTimeAvisoCierreCercanoEmbarque = toCalendar(aviso_cierre_cercano_embarque);
    
        // Programar las tareas para las horas deseadas
        timer.schedule(taskCheckInLinea, scheduledTimeCheckInLinea.getTime());
        timer.schedule(taskCheckInPresencial, scheduledTimeCheckInPresencial.getTime());
        timer.schedule(taskEmbarqueAbierto, scheduledTimeEmbarqueAbierto.getTime());
        timer.schedule(taskAvisoCierreCercanoEmbarque, scheduledTimeAvisoCierreCercanoEmbarque.getTime());
    }

    // Método para convertir LocalDateTime a Calendar
    private static Calendar toCalendar(LocalDateTime localDateTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear(); // Limpiar el calendar para evitar valores anteriores
        calendar.set(Calendar.YEAR, localDateTime.getYear());
        calendar.set(Calendar.MONTH, localDateTime.getMonthValue() - 1); // Calendar.MONTH es 0-indexed
        calendar.set(Calendar.DAY_OF_MONTH, localDateTime.getDayOfMonth());
        calendar.set(Calendar.HOUR_OF_DAY, localDateTime.getHour());
        calendar.set(Calendar.MINUTE, localDateTime.getMinute());
        calendar.set(Calendar.SECOND, localDateTime.getSecond());
        calendar.set(Calendar.MILLISECOND, localDateTime.getNano() / 1000000); // Convertir nanosegundos a milisegundos
        return calendar;
    }    

    public abstract List<Asiento> getAsientosDisponibles();

    // Método abstracto toString para imprimir para obligar a implementar en clases hijas
    @Override
    public abstract String toString();
}
