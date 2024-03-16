package Pair;

public class Main {
    public static void main(String[] args) {
        Pair<Boolean, String> pair = new Pair<>(true, "hi");
        System.out.println(pair.toString());
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
    }
}
