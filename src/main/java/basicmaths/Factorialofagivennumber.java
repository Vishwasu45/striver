package basicmaths;

public class Factorialofagivennumber {

    public static void main(String[] args) {
        int n = 5;
        int result = factorial(n);
        System.out.println("Factorial of " + n + " is: " + result);
    }

    public static int factorial(int n) {
        if (n == 0) return 1;
        int result = 1;
        while(n > 0) {
            result = result * n;
            n = n - 1;
        }
        return result;
    }
}
