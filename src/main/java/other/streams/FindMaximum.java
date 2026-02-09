package other.streams;

import java.util.Arrays;
import java.util.Optional;

public class FindMaximum {

    public static void main(String[] args) {
        var numbers = Arrays.asList(3, 5, 2, 8, 1, 4);
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        max.ifPresent(value -> System.out.println("Maximum value: " + value));
    }
}
