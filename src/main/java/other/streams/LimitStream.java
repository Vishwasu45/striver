package other.streams;

public class LimitStream {

    public static void main(String[] args) {
        var numbers = java.util.Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        var limitedNumbers = numbers.stream()
                .limit(5)
                .toList();

        System.out.println("First 5 numbers: " + limitedNumbers);
    }
}
