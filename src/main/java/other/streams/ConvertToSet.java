package other.streams;

public class ConvertToSet {

    public static void main(String[] args) {
        var numbers = java.util.Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        var numberSet = numbers.stream()
                .collect(java.util.stream.Collectors.toSet());
        System.out.println("Converted to Set: " + numberSet);
    }
}
