package basic.basicMaths;

public class CheckForPerfectNumber {

    public static void main(String[] args) {
        int n = 28; // Example number
        boolean isPerfect = isPerfect(n);
        if (isPerfect) {
            System.out.println(n + " is a perfect number.");
        } else {
            System.out.println(n + " is not a perfect number.");
        }
    }

    public static boolean isPerfect(int n) {
        if (n == 0)
            return false;
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum = sum + i;
            }
        }
        return sum == n;
    }
}
