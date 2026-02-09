package other.streams;

public class FindFirst {

    public static void main(String[] args) {
        var numbers = java.util.Arrays.asList(1, 2, 3, 4, 5);
        var firstEven = numbers.stream()
                .filter(n -> n % 2 == 0)
                .findFirst();
        firstEven.ifPresent(n -> System.out.println("First even number: " + n));
    }
}
