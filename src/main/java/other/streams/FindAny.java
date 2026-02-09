package other.streams;

public class FindAny {

    public static void main(String[] args) {
        var numbers = java.util.Arrays.asList(10, 12, 3, 14, 5);
        var anyNumberGreaterThanFive = numbers.stream()
                .filter(n -> n > 5)
                .findAny();
        anyNumberGreaterThanFive.ifPresent(n -> System.out.println("Found a number greater than 5: " + n));
    }
}
