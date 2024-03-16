package Pair;

public class Pair<T, F>{
    private T first;
    private F second;
    Pair(T first, F second){
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public F getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return first +" "+ second;
    }
}
