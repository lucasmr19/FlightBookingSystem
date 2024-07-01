package reserva_vuelos;

// Ignorar esta clase, solo sirve para devolver 4 objetos de cualquier tipo.
public class Fourth<A, B, C, D> {
    private final A first;
    private final B second;
    private final C third;
    private final D fourth;

    public Fourth(A first, B second, C third, D fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
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

    public D getFourth() {
        return this.fourth;
    }
}
