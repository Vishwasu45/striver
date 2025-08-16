package basicmaths;

import java.util.ArrayList;
import java.util.List;

public class DivisorsOfNumer {

    public static void main(String[] args) {
        DivisorsOfNumer divisorsOfNumer = new DivisorsOfNumer();
        int n = 28; // Example number
        int[] divisors = divisorsOfNumer.divisors(n);
        System.out.print("Divisors of " + n + " are: ");
        for (int divisor : divisors) {
            System.out.print(divisor + " ");
        }
    }

    public int[] divisors(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }
        list.add(n);
        return list.stream()
                .distinct()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
