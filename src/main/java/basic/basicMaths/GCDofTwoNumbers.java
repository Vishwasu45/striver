package basic.basicMaths;

public class GCDofTwoNumbers {

    public static void main(String[] args) {
        GCDofTwoNumbers gcdCalculator = new GCDofTwoNumbers();
        int n1 = 48;
        int n2 = 18;
        int gcd = gcdCalculator.GCD(n1, n2);
        System.out.println("GCD of " + n1 + " and " + n2 + " is: " + gcd);

        int gcdEuclidean = gcdCalculator.GCDEuclidean(n1, n2);
        System.out.println("GCD of " + n1 + " and " + n2 + " using Euclidean method is: " + gcdEuclidean);
    }

    public int GCD(int n1, int n2) {
        int greatest = 1;
        for (int i = Math.min(n1, n2); i >= 1; i--) {
            if (n1 % i == 0 && n2 % i == 0) {
                return i;
            }
        }
        return greatest;
    }

    public int GCDEuclidean(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return GCDEuclidean(n2, n1 % n2);
    }
}
