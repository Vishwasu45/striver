package other.streams;

public class AllMatch {

    public static void main(String[] args) {
        var numbers = java.util.Arrays.asList(2, 4, 6, 8, 10);
        boolean allEven = numbers.stream()
                .allMatch(n -> n % 2 == 0);
        System.out.println("All numbers are even: " + allEven);
    }
}
