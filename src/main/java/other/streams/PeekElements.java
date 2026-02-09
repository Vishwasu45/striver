package other.streams;

public class PeekElements {

    public static void main(String[] args) {
        var numbers = java.util.Arrays.asList(1, 2, 3, 4, 5);

        var processedNumbers = numbers.stream()
                .peek(n -> System.out.println("Original number: " + n))
                .map(n -> n * n)
                .peek(n -> System.out.println("Squared number: " + n))
                .toList();

        System.out.println("Processed Numbers: " + processedNumbers);
    }
}
