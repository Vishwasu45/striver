package basicmaths;

public class CountofprimenumberstillN {

        public int primeUptoN(int n) {
            int count = 0;
            if (n == 0 || n == 1) return 0;
            for (int i = 2; i <= n; i++) {
                boolean prime = isPrime(i);
                if (prime) count++;
            }
            return count;
        }

        private boolean isPrime(int i) {
            for (int j = 2; j <= Math.sqrt(i);j++) {
                if (i%j==0) {
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {
            CountofprimenumberstillN main = new CountofprimenumberstillN();
            int n = 6;
            int primeCount = main.primeUptoN(n);
            System.out.println("Number of prime numbers up to " + n + " is: " + primeCount);
        }
}
