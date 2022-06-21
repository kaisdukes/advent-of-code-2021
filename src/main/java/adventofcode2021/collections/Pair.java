package adventofcode2021.collections;

public class Pair<U, V> {
    private final U first;
    private final V second;

    public Pair(final U first, final V second) {
        this.first = first;
        this.second = second;
    }

    public U getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }
}