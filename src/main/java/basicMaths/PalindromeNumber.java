package basicMaths;

public class PalindromeNumber {

    public static void main(String[] args) {
        int n = 12321;
        boolean isPalindrome = isPalindrome(n);
        System.out.println("Is " + n + " a palindrome? " + isPalindrome);
    }

    public static boolean isPalindrome(int n) {
        if (n == 0 || n < 0) return true;
        int reverse = 0;
        int original = n;
        while (n > 0) {
            int remainder = n % 10;
            reverse = reverse * 10 + remainder;
            n = n / 10;
        }
        if (original == reverse) return true;
        return false;
    }
}
