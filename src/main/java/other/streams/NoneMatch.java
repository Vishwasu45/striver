package other.streams;

public class NoneMatch {

    public static void main(String[] args) {
        var numbers = java.util.Arrays.asList(1, 3, 5, 7, 9);
        boolean noneMatch = numbers.stream()
                .noneMatch(n -> n % 2 == 0);
        System.out.println("No even numbers: " + noneMatch);
    }
}
