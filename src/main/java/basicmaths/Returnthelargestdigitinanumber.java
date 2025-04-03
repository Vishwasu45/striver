package basicmaths;

public class Returnthelargestdigitinanumber {

    public static void main(String[] args) {
        int n = 12345;
        int largestDigit = largestDigit(n);
        System.out.println("Largest digit in " + n + " is: " + largestDigit);
    }

    public static int largestDigit(int n) {
        if (n == 0) return 0;
        int largest = 0;
        while (n > 0) {
            int remainder = n % 10;
            if (remainder > largest) {
                largest = remainder;
            }
            n = n / 10;
        }
        return largest;
    }
}
