package other.streams;

public class GetDistinctElements {

    public static void main(String[] args) {
        var numbers = java.util.Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        var distinctNumbers = numbers.stream()
                .distinct()
                .toList();
        System.out.println("Distinct Numbers: " + distinctNumbers);
    }
}
