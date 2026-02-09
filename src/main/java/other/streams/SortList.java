package other.streams;

public class SortList {

    public static void main(String[] args) {
        var numbers = java.util.Arrays.asList(5, 2, 8, 1, 4);
        var sortedNumbers = numbers.stream()
                .sorted()
                .toList();
        System.out.println("Sorted Numbers: " + sortedNumbers);
    }
}
