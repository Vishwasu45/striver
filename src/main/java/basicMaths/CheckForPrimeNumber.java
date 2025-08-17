package basicMaths;

public class CheckForPrimeNumber {

    public static void main(String[] args) {
        int n = 29; // Example number to check
        boolean isPrime = isPrime(n);
        System.out.println(n + " is prime: " + isPrime);
    }

    public static boolean isPrime(int n) {
        //your code goes here
        if (n == 0 || n == 1) return false;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
