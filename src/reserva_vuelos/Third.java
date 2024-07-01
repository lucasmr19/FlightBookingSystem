package reserva_vuelos;

// Ignorar esta clase, solo sirve para devolver 3 objetos de cualquier tipo.
public class Third<A, B, C> {
    private final A first;
    private final B second;
    private final C third;
    
    public Third(A first, B second, C third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public A getFirst() {
        return this.first;
    }

    public B getSecond() {
        return this.second;
    }

    public C getThird() {
        return this.third;
    }
}
