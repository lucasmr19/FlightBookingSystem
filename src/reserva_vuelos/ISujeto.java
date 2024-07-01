package reserva_vuelos;

public interface ISujeto {
    void addObservador(IObservador observador);
    void removeObservador(IObservador observador);
    void notificar();
}   
