package reserva_vuelos;

public abstract class MetodoPago {
    protected double saldoDisponible;

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    // Método abstracto toString para imprimir para obligar a implementar en clases hijas
    @Override
    public abstract String toString();
    
    // Métodos para actualizar el saldo
    protected void addCantidadSaldo(double monto) {
        this.saldoDisponible += monto;
    }

    protected void removeCantidadSaldo(double monto) {
        this.saldoDisponible -= monto;
    }
}
