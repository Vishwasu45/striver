package basicMaths;

public class CountAllDigitsOfANumber {

    public static void main(String[] args) {
        int n = 12345;
        int count = countDigit(n);
        System.out.println("Count of digits in " + n + " is: " + count);
    }

    public static int countDigit(int n) {
        int count = 0;

        if (n == 0) return 1;
        while (n > 0) {
            n = n / 10;
            count = count + 1;
        }
        return count;
    }
}
