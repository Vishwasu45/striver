package other.streams;

public class ReduceToSum {

    public static void main(String[] args) {
        var numbers = java.util.Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum of elements: " + sum);
    }
}
