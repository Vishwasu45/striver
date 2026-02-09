package other.streams;

public class SkipElements {

    public static void main(String[] args) {
        var numbers = java.util.Arrays.asList(10, 20, 30, 40, 50);
        var skippedNumbers = numbers.stream()
                .skip(2)
                .toList();
        System.out.println("After skipping first two elements: " + skippedNumbers);
    }
}
