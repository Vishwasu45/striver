package basicMaths;

public class ReverseANumber {

    public static void main(String[] args) {
        int n = 12345;
        int reversedNumber = reverseNumber(n);
        System.out.println("Reversed number of " + n + " is: " + reversedNumber);
    }

    public static int reverseNumber(int n) {

        if (n == 0) return 0;
        int reverseNumber = 0;
        while (n > 0) {
            int remainder = n % 10;
            reverseNumber = reverseNumber * 10 + remainder;
            n = n / 10;
        }
        return reverseNumber;
    }
}
