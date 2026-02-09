package other.streams;

import java.util.Arrays;

public class SumOfElements {

    public static void main(String[] args) {
        var numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum of elements: " + sum);
    }
}
