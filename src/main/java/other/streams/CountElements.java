package other.streams;

public class CountElements {

    public static void main(String[] args) {
        var numbers = java.util.Arrays.asList(10, 12, 3, 14, 5);
        long count = numbers.stream()
                .filter(n -> n > 5)
                .count();
        System.out.println("Count of elements: " + count);
    }
}
