package basicMaths;

public class CountNumberOfOddDigitsInANumber {

    public static void main(String[] args) {
        int n = 12345;
        int count = countOddDigit(n);
        System.out.println("Count of odd digits in " + n + " is: " + count);
    }

    public static int countOddDigit(int n) {
        int count = 0;

        if (n == 0) return 0;
        while (n > 0) {
            int reminder = n % 10;
            if (reminder % 2 == 1) {
                count = count + 1;
            }
            n = n / 10;
        }
        return count;
    }
}
